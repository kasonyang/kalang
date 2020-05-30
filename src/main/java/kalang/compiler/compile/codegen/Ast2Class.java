
package kalang.compiler.compile.codegen;

import kalang.compiler.ast.*;
import kalang.compiler.compile.AstLoader;
import kalang.compiler.compile.AstNotFoundException;
import kalang.compiler.compile.CodeGenerator;
import kalang.compiler.compile.CompilationUnit;
import kalang.compiler.compile.codegen.op.*;
import kalang.compiler.compile.semantic.MalformedAstException;
import kalang.compiler.compile.semantic.analyzer.TerminalStatementAnalyzer;
import kalang.compiler.core.*;
import kalang.compiler.tool.OutputManager;
import kalang.compiler.util.*;
import kalang.mixin.CollectionMixin;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.invoke.*;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

import static kalang.compiler.core.Types.*;
import static org.objectweb.asm.Opcodes.*;
/**
 *The class generate the java class binary data for ast
 * 
 * @author Kason Yang 
 */
public class Ast2Class extends AbstractAstVisitor<Object> implements CodeGenerator{

    private static Logger LOG = Logger.getLogger(Ast2Class.class.getName());
    private final CompilationUnit compilationUnit;

    private ClassWriter classWriter;
    private OpCollector opCollector;
    
    private OutputManager outputManager;

    private final AstLoader astLoader;
    
    private Map<Integer, LabelOp> lineLabels = new HashMap<>();
    
    private Map<VarObject,Integer> varIds = new HashMap<>();
    
    private Stack<Integer> varStartIndexOfFrame = new Stack<>();
    
    private Map<VarObject, LabelOp> varStartLabels = new HashMap<>();
    
    private VarTable<Integer,LocalVarNode> varTables = new VarTable<>();
    
    private int varIdCounter = 0;
    
    private Stack<LabelOp> breakLabels = new Stack<>();
    private Stack<LabelOp> continueLabels = new Stack<>();

    private Stack<CatchContext> catchContextStack = new Stack<>();

    private final static int
            T_I = 0,
            T_L = 1,
            T_F = 2,
            T_D = 3,
            T_A = 4;
    private ClassNode clazz;
    private TerminalStatementAnalyzer terminalStmtAnalyzer = new TerminalStatementAnalyzer(true);
    private String classInternalName;


    public Ast2Class(OutputManager outputManager, AstLoader astLoader, CompilationUnit compilationUnit) {
        this.outputManager = outputManager;
        this.astLoader = astLoader;
        this.compilationUnit = compilationUnit;
    }
    
    private int getT(Type type){
        int t;
            if(
                    type.equals(INT_TYPE)
                    ||type.equals(BOOLEAN_TYPE)
                    || type.equals(CHAR_TYPE)
                    || type.equals(BYTE_TYPE)
                    || type.equals(SHORT_TYPE)
                    ){
                t = T_I;
            }else if(type.equals(LONG_TYPE)){
                t = T_L;
            }else if(type.equals(FLOAT_TYPE)){
                t = T_F;
            }else if(type.equals(DOUBLE_TYPE)){
                t = T_D;
            }else{
                t = T_A;
            }
            return t;
    }
    
    @Nullable
    private String classSignature(ClassNode c){
        GenericType[] genericTypes = c.getGenericTypes();
        if(genericTypes==null || genericTypes.length==0){
            return null;
        }
        StringBuilder gnrTypeStr = new StringBuilder();
        for(GenericType t:genericTypes){
            gnrTypeStr.append(t.getName()).append(":").append("Ljava/lang/Object;");
        }
        StringBuilder superTypeStr = new StringBuilder();
        if(c.getSuperType()!=null) superTypeStr.append(typeSignature(c.getSuperType()));
        for(ObjectType itf:c.getInterfaces()){
            superTypeStr.append(typeSignature(itf));
        }
        return "<" + gnrTypeStr + ">" + superTypeStr ;
        
    }
    
    private String methodSignature(MethodNode m){
        StringBuilder ptype = new StringBuilder();
        for(ParameterNode p:m.getParameters()){
            ptype.append(typeSignature(p.getType()));
        }
        return "(" + ptype + ")" + typeSignature(m.getType());
    }
    
    @Nullable
    private String typeSignature(Type type){
        if(type instanceof GenericType){
            return "T" + type.getName() + ";" ;
        }else if(type instanceof ClassType){
            ClassType pt = (ClassType) type;
            StringBuilder ptypes = new StringBuilder();
            for(Type p:pt.getTypeArguments()){
                ptypes.append(typeSignature(p));
            }
            if(ptypes.length() > 0) ptypes = new StringBuilder("<" + ptypes + ">");
            return "L" + pt.getClassNode().name.replace('.', '/') + ptypes + ";";
        }else if(type instanceof PrimitiveType){
            return getTypeDescriptor(type);
        }else if(type instanceof ArrayType){
            return "[" + typeSignature(((ArrayType)type).getComponentType());
        }else if(type instanceof WildcardType){
            WildcardType wt = (WildcardType) type;
            Type[] lbs = wt.getLowerBounds();
            Type[] ubs = wt.getUpperBounds();
            if(lbs.length>0){
                //FIXME handle other lowerBounds
                return "-" + typeSignature(lbs[0]) ;
            }else if(ubs.length>0){
                //FIXME handle other lowerBounds
                return "+" + typeSignature(ubs[0]) ;
            }else{
                return "*";
            }
        }else{
            throw Exceptions.unsupportedTypeException(type);
        }
    }

    private String internalName(String className){
        return className.replace(".", "/");
    }
    
    private String[] internalNames(String[] names){
        String[] inames = new String[names.length];
        for(int i=0;i<names.length;i++){
            inames[i] = internalName(names[i]);
        }
        return inames;
    }
    
    protected String getNullableAnnotation(ObjectType type){
        NullableKind nullable = type.getNullable();
        if(nullable == NullableKind.NONNULL){
            return "kalang.annotation.Nonnull";
        }else if(nullable == NullableKind.NULLABLE){
            return "kalang.annotation.Nullable";
        }else{
            return null;
        }
    }
    
    protected void annotationNullable(Object obj,ObjectType type){
        String annotation = getNullableAnnotation(type);
        if(annotation!=null){
            try {
                annotation(obj, new AnnotationNode(AstLoader.BASE_AST_LOADER.loadAst(annotation)));
            } catch (AstNotFoundException ex) {
                throw Exceptions.missingRuntimeClass(ex.getMessage());
            }
        }
    }
    
    protected void annotation(Object obj,AnnotationNode... annotations){
        for(AnnotationNode an:annotations){
            AnnotationVisitor av;
            String desc = getTypeDescriptor(Types.getClassType(an.getAnnotationType()));
            //TODO set annotation visible
            boolean isVisible = true;
            if(obj instanceof ClassWriter){
                av = ((ClassWriter)obj).visitAnnotation(desc,isVisible);
            }else if(obj instanceof MethodVisitor){
                av = ((MethodVisitor)obj).visitAnnotation(desc, isVisible);
            }else{
                throw Exceptions.unsupportedTypeException(obj);
            }
            for(String v:an.values.keySet()){
                //TODO handle enum value
                Object javaConst = getJavaConst(an.values.get(v));
                av.visit(v, javaConst);
            }
        }
    }
    
    @Override
    public Object visitClassNode(ClassNode node) {        
        ClassNode oldClass = this.clazz;
        this.clazz = node;
        String oldClassInternalName = this.classInternalName;
        this.classInternalName = internalName(clazz);
        ClassWriter oldClassWriter = this.classWriter;
        this.classWriter = new  KlClassWriter(ClassWriter.COMPUTE_FRAMES, astLoader);
        annotation(classWriter, clazz.getAnnotations());
        String parentName = "java.lang.Object";
        ObjectType superType = node.getSuperType();
        if(superType!=null){
            parentName = internalName(superType);
        }
        String[] interfaces = null;
        if(node.getInterfaces().length>0){
            interfaces = internalName(node.getInterfaces());
        }
        int access = node.modifier;
        classWriter.visit(V1_8, access,internalName(node.name),classSignature(node), internalName(parentName),interfaces);
        String fileName = node.fileName;
        if(fileName!=null && !fileName.isEmpty()){
            classWriter.visitSource(fileName, null);
        }
        visitChildren(node);
        Map<MethodDescriptor, MethodNode> implementationMap = InterfaceUtil.getImplementationMap(node);
        for(Map.Entry<MethodDescriptor,MethodNode> e:implementationMap.entrySet()) {
            MethodDescriptor interfaceMethod = e.getKey();
            MethodNode implementedMethod = e.getValue();
            if (implementedMethod!=null) {
                this.createInterfaceBridgeMethodIfNeed(interfaceMethod.getMethodNode(),implementedMethod);
            }
        }

        //clinit
        if(!node.staticInitStmts.isEmpty()){
            MethodVisitor method = classWriter.visitMethod(ACC_STATIC, "<clinit>", "()V", null, null);
            opCollector = new OpCollector();
            visitAll(node.staticInitStmts);
            opCollector.visitInsn(RETURN);
            applyOp(method, opCollector);
            method.visitMaxs(1, 1);
        }
        if(node.enclosingClass!=null){
            this.classWriter.visitInnerClass(this.internalName(node), this.internalName(node.enclosingClass), NameUtil.getSimpleClassName(node.name), node.modifier);
        }
        for(ClassNode ic:node.classes){
            classWriter.visitInnerClass(internalName(ic), internalName(node), NameUtil.getSimpleClassName(ic.name), ic.modifier);
        }
        classWriter.visitEnd();
        if(outputManager!=null){
            try {
                try (OutputStream os = outputManager.createOutputStream(node.name)) {
                    os.write(this.classWriter.toByteArray());
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }else{
            LOG.log(Level.WARNING, "outputManager is null");
        }
        this.clazz = oldClass;
        this.classInternalName = oldClassInternalName;
        this.classWriter = oldClassWriter;
        return null;
    }

    @Override
    public Object visitMethodNode(MethodNode node) {
        int access = node.getModifier();
        MethodVisitor method = classWriter.visitMethod(access, internalName(node.getName()), getMethodDescriptor(node), methodSignature(node), internalName(node.getExceptionTypes()));
        opCollector = new OpCollector();
        if(node.getType() instanceof ObjectType){
            annotationNullable(method,(ObjectType)node.getType());
        }
        annotation(method, node.getAnnotations());
        //Label methodStartLabel = new Label();
        //Label methodEndLabel = new Label();
        if(AstUtil.isStatic(node.getModifier())){
            varIdCounter = 0;
        }else{
            varIdCounter = 1;
        }
        BlockStmt body = node.getBody();
        ParameterNode[] parameters = node.getParameters();
        for(int i=0;i<parameters.length;i++){
            ParameterNode p = parameters[i];
            method.visitParameter(p.getName(), p.modifier);
            this.declareNewVar(p);
            if(p.getType() instanceof ObjectType){
                String nullableAnnotation = getNullableAnnotation((ObjectType)p.getType());
                if (nullableAnnotation!=null && nullableAnnotation.isEmpty()) {
                    method.visitParameterAnnotation(i,getClassDescriptor(nullableAnnotation), true).visitEnd();
                }
            }
        }
        //opCollector.visitLabel(methodStartLabel);
        if(body!=null){
            visit(body);
            if(node.getType().equals(VOID_TYPE)){
                opCollector.visitInsn(RETURN);
            }
            //opCollector.visitLabel(methodEndLabel);
            applyOp(method, opCollector);
            try{
                method.visitMaxs(0, 0);
            }catch(Exception ex){
                ex.printStackTrace(System.err);
                //throw new RuntimeException("exception when visit method:" + node.name, ex);
            }
        }
        method.visitEnd();
        return null;
    }
    
    private void newFrame(){
        this.varStartIndexOfFrame.push(this.varIdCounter);
        this.varTables = this.varTables.newStack();
    }
    
    private void popFrame(){
        for(LocalVarNode v:this.varTables.values()){
            this.destroyLocalVarNode(v);
        }
        this.varIdCounter = this.varStartIndexOfFrame.pop();
        this.varTables = this.varTables.popStack();
    }

    private int declareNewVar(Type type) {
        int vid = varIdCounter;
        int vSize = asmType(type).getSize();
        varIdCounter += vSize;
        return vid;
    }
    
    private void declareNewVar(VarObject vo){
        int vid = varIdCounter;
        int vSize = asmType(vo.getType()).getSize();
        if(vSize==0){
            throw Exceptions.unexpectedException("");
        }
        varIdCounter+= vSize;
        varIds.put(vo, vid);          
        LabelOp startLabel = new LabelOp();
        opCollector.visitLabel(startLabel);
        this.varStartLabels.put(vo,startLabel);
        if(vo instanceof LocalVarNode){
            this.varTables.put(vid, (LocalVarNode) vo);
        }
    }
    
    private void destroyLocalVarNode(LocalVarNode var){
        Integer vid = this.varIds.get(var);
        //TODO why vid==null
//        if(vid==null){
//            throw Exceptions.unexpectedValue(vid);
//        }
        LabelOp endLabel = new LabelOp();
        opCollector.visitLabel(endLabel);
        this.varIds.remove(var);
        String name = var.getName();
        if(vid!=null && name!=null && !name.isEmpty()){
            opCollector.visitLocalVariable(name, getTypeDescriptor(var.getType()),null ,varStartLabels.get(var), endLabel, vid);
        }
    }

    @Override
    public Object visitBlockStmt(BlockStmt node) {
        this.newFrame();
        visitChildren(node);
        this.popFrame();
        return null;
    }

    @Override
    public Object visitBreakStmt(BreakStmt node) {
        if (breakLabels.isEmpty()) {
            throw new MalformedAstException("break outside of loop", node);
        }
        opCollector.visitJumpInsn(GOTO, breakLabels.peek());
        return null;
    }

    @Override
    public Object visitContinueStmt(ContinueStmt node) {
        if (continueLabels.isEmpty()) {
            throw new MalformedAstException("continue outside of loop", node);
        }
        opCollector.visitJumpInsn(GOTO, continueLabels.peek());
        return null;
    }
    
    private void pop(Type type){
        int size =  asmType(type).getSize();
        if(size==1){
            opCollector.visitInsn(POP);
        }else if(size==2){
            opCollector.visitInsn(POP2);
        }else{
            throw new UnsupportedOperationException("It is unsupported to pop for the type:" + type);
        }
    }

    @Override
    public Object visitExprStmt(ExprStmt node) {
        visitChildren(node);
        Type type = node.getExpr().getType();
        if(!Types.VOID_TYPE.equals(type)){
            pop(type);
        }
        return null;
    }
    
    private void ifExpr(boolean jumpOnTrue, ExprNode condition, LabelOp label){
        if(condition instanceof LogicBinaryExpr){
            LogicBinaryExpr be = (LogicBinaryExpr) condition;
            ExprNode e1 = be.getExpr1();
            ExprNode e2 = be.getExpr2();
            String op = be.getOperation();
            switch(op){
                case "&&":
                    if(jumpOnTrue){
                        LabelOp stopLabel = new LabelOp();
                        ifExpr(false,e1,stopLabel);
                        ifExpr(false,e2,stopLabel);
                        opCollector.visitJumpInsn(GOTO, label);
                        opCollector.visitLabel(stopLabel);
                    }else{
                        ifExpr(false, e1, label);
                        ifExpr(false, e2, label);
                    }
                    break;
                case "||":
                    if(jumpOnTrue){
                        ifExpr(true, e1, label);
                        ifExpr(true, e2, label);
                    }else{
                        LabelOp stopLabel = new LabelOp();
                        ifExpr(true, e1, stopLabel);
                        ifExpr(true, e2, stopLabel);
                        opCollector.visitJumpInsn(GOTO, label);
                        opCollector.visitLabel(stopLabel);
                    }
                    break;
                default:
                    throw  new UnsupportedOperationException("Unsupported operation:" + op);
            }
        }else if(condition instanceof CompareBinaryExpr){
            ifCompare(jumpOnTrue,((CompareBinaryExpr) condition).getExpr1(), ((CompareBinaryExpr) condition).getExpr2(), ((CompareBinaryExpr) condition).getOperation(), label);
        }else if(condition instanceof UnaryExpr && ((UnaryExpr)condition).getOperation().equals("!")){
            ifExpr(!jumpOnTrue, ((UnaryExpr)condition).getExpr(), label);
        }else{
            visit(condition);
            opCollector.visitJumpInsn(jumpOnTrue ? IFNE : IFEQ, label);
        }
    }

    @Override
    public Object visitIfStmt(IfStmt node) {
        LabelOp stopLabel = new LabelOp();
        LabelOp falseLabel = new LabelOp();
        ExprNode condition = node.getConditionExpr();
        Statement trueBody = node.getTrueBody();
        Statement falseBody = node.getFalseBody();    
        ifExpr(false,condition,falseLabel);
        visit(trueBody);
        opCollector.visitJumpInsn(GOTO, stopLabel);
        opCollector.visitLabel(falseLabel);
        visit(falseBody);
        opCollector.visitLabel(stopLabel);
        return null;
    }

    @Override
    public Object visitLoopStmt(LoopStmt node) {
        //visitAll(node.initStmts);
        LabelOp startLabel = new LabelOp();
        LabelOp continueLabel = new LabelOp();
        LabelOp stopLabel = new LabelOp();
        continueLabels.push(continueLabel);
        breakLabels.push(stopLabel);
        opCollector.visitLabel(startLabel);
        if(node.getPreConditionExpr()!=null){
            ifExpr(false, node.getPreConditionExpr(),stopLabel);
        }
        visit(node.getLoopBody());
        opCollector.visitLabel(continueLabel);
        visit(node.getUpdateStmt());
        if(node.getPostConditionExpr()!=null){
            ifExpr(false, node.getPostConditionExpr(),stopLabel);
        }
        opCollector.visitJumpInsn(GOTO, startLabel);
        opCollector.visitLabel(stopLabel);
        continueLabels.pop();
        breakLabels.pop();
        return null;
    }

    @Override
    public Object visitReturnStmt(ReturnStmt node) {
        int lnsn = RETURN;
        int returnVar = -1;
        Type returnType = null;
        if(node.expr!=null){
            visit(node.expr);
            returnType = node.expr.getType();
            lnsn = asmType(returnType).getOpcode(IRETURN);
            returnVar = declareNewVar(returnType);
            opCollector.visitVarInsn(asmType(returnType).getOpcode(ISTORE), returnVar);
        }
        Stack<CatchContext> ccStack = new Stack<>();
        while (!catchContextStack.isEmpty()){
            CatchContext catchContext  = catchContextStack.pop();
            ccStack.push(catchContext);
            Statement finallyStmt = catchContext.getFinallyStatement();
            if (finallyStmt!=null) {
                this.newFrame();
                LabelOp startLabel = new LabelOp();
                LabelOp endLabel = new LabelOp();
                opCollector.visitLabel(startLabel);
                visit(finallyStmt);
                opCollector.visitLabel(endLabel);
                popFrame();
                catchContext.addExclude(startLabel, endLabel);
            }
        }
        while(!ccStack.isEmpty()) {
            catchContextStack.push(ccStack.pop());
        }
        if (returnVar > -1) {
            opCollector.visitVarInsn(asmType(returnType).getOpcode(ILOAD), returnVar);
        }
        opCollector.visitInsn(lnsn);
        return null;
    }

    @Override
    public Object visitTryStmt(TryStmt node) {
        BlockStmt execStmt = node.getExecStmt();
        BlockStmt finallyStmt = node.getFinallyStmt();
        boolean hasFinallyStmt = finallyStmt!=null && !finallyStmt.statements.isEmpty();
        if (execStmt.statements.isEmpty()) {
            if (hasFinallyStmt) {
                visit(finallyStmt);
            }
            return null;
        }
        this.newFrame();
        LabelOp tryStartLabel = new LabelOp();
        LabelOp tryEndLabel = new LabelOp();
        LabelOp exitLabel = new LabelOp();
        LabelOp finallyStartLabel = new LabelOp();
        CatchContext catchContextOfTry = new CatchContext(tryStartLabel, tryEndLabel, finallyStmt);
        catchContextStack.push(catchContextOfTry);
        opCollector.visitLabel(tryStartLabel);
        visit(execStmt);
        opCollector.visitLabel(tryEndLabel);
        this.popFrame();
        catchContextStack.pop();
        if (!terminalStmtAnalyzer.isTerminalStatement(execStmt)) {
            if (finallyStmt!=null) {
                this.newFrame();
                visit(finallyStmt);
                this.popFrame();
            }
            opCollector.visitJumpInsn(GOTO,exitLabel);
        }
        LabelOp[] catchLabelsOfTry = catchContextOfTry.getCatchLabels();
        if(node.getCatchStmts()!=null){
            for(CatchBlock s:node.getCatchStmts()){
                this.newFrame();
                LabelOp catchStartLabel = new LabelOp();
                LabelOp catchStopLabel = new LabelOp();
                CatchContext catchContextOfCatch = new CatchContext(catchStartLabel,catchStopLabel,finallyStmt);
                catchContextStack.push(catchContextOfCatch);
                opCollector.visitLabel(catchStartLabel);
                visit(s);
                opCollector.visitLabel(catchStopLabel);
                this.popFrame();
                catchContextStack.pop();
                if (!terminalStmtAnalyzer.isTerminalStatement(s.execStmt)) {
                    if (finallyStmt!=null) {
                        this.newFrame();
                        visit(finallyStmt);
                        this.popFrame();
                    }
                    opCollector.visitJumpInsn(GOTO,exitLabel);
                }
                LabelOp[] catchLabelsOfCatch = catchContextOfCatch.getCatchLabels();
                String type = asmType(s.catchVar.getType()).getInternalName();
                for(int j=0;j<catchLabelsOfTry.length;j+=2) {
                    opCollector.visitTryCatchBlock(catchLabelsOfTry[j],catchLabelsOfTry[j+1],catchStartLabel,type);
                }
                if (hasFinallyStmt) {
                    for(int j=0;j<catchLabelsOfCatch.length;j+=2) {
                        opCollector.visitTryCatchBlock(catchLabelsOfCatch[j],catchLabelsOfCatch[j+1],finallyStartLabel,null);
                    }
                }
            }
        }
        if(hasFinallyStmt){//any exception handler
            for(int i=0;i<catchLabelsOfTry.length-1;i+=2) {
                opCollector.visitTryCatchBlock(catchLabelsOfTry[i],catchLabelsOfTry[i+1],finallyStartLabel,null);
            }
            this.newFrame();
            opCollector.visitLabel(finallyStartLabel);
            int exVarId = this.declareNewVar(Types.getRootType());
            opCollector.visitVarInsn(ASTORE,exVarId);
            visit(finallyStmt);
            opCollector.visitVarInsn(ALOAD,exVarId);
            opCollector.visitInsn(ATHROW);
            this.popFrame();
        }
        opCollector.visitLabel(exitLabel);
        opCollector.visitInsn(NOP);
        return null;
    }

    @Override
    public Object visitCatchBlock(CatchBlock node) {
        visit(node.catchVar);
        int exVarId = getVarId(node.catchVar);
        opCollector.visitVarInsn(ASTORE, exVarId);
        visit(node.execStmt);
        return null;
    }

    @Override
    public Object visitThrowStmt(ThrowStmt node) {
        visit(node.expr);
        opCollector.visitInsn(ATHROW);
        return null;
    }
    
    private void assignVarObject(VarObject to,ExprNode from){
        visit(from);
        int vid = getVarId(to);
        opCollector.visitVarInsn(getOpcode(to.getType(),ISTORE), vid);
    }
    
    private void assignField(FieldNode fn,ExprNode target, ExprNode from, int valueVar){
        int opc = PUTFIELD;
        if (AstUtil.isStatic(fn.modifier)) {
            opc = PUTSTATIC;
        } else {
            visit(target);
        }
        visit(from);
        dupX(from.getType());
        opCollector.visitVarInsn(getOpcode(from.getType(),ISTORE), valueVar);
        opCollector.visitFieldInsn(opc,
                asmType(Types.getClassType(fn.getClassNode())).getInternalName(), fn.getName(), getTypeDescriptor(fn.getType()));
    }
    
    private void assignField(FieldExpr fieldExpr,ExprNode from, int valueVar){
        if(fieldExpr instanceof StaticFieldExpr){
            assignField(fieldExpr.getField().getFieldNode(), null, from, valueVar);
        }else if(fieldExpr instanceof ObjectFieldExpr){
            assignField(fieldExpr.getField().getFieldNode(), ((ObjectFieldExpr) fieldExpr).getTarget(), from, valueVar);
        }else{
            throw new UnsupportedOperationException();
        }
    }
    
    private void astore(ExprNode expr){
        visit(expr);
        org.objectweb.asm.Type type = asmType(expr.getType());
        opCollector.visitInsn(type.getOpcode(IASTORE));
    }
    
    private void assignArrayElement(ExprNode array,ExprNode key,ExprNode from, int valueVar){
        Parameters.requireNonNull(array);
        Parameters.requireNonNull(key);
        visit(array);
        visit(key);
        visit(from);
        dupX(from.getType());
        opCollector.visitVarInsn(getOpcode(from.getType(), ISTORE), valueVar);
        ArrayType arrayType = (ArrayType) array.getType();
        opCollector.visitInsn(getOpcode(arrayType.getComponentType(),IASTORE));
    }

    @Override
    public Object visitAssignExpr(AssignExpr node) {
        ExprNode from = node.getFrom();
        AssignableExpr to = node.getTo();
        int valueVar;
        if (to instanceof FieldExpr) {
            valueVar = declareNewVar(from.getType());
            assignField((FieldExpr) to, from, valueVar);
        } else if (to instanceof VarExpr) {
            LocalVarNode toVar = ((VarExpr) to).getVar();
            assignVarObject(toVar, from);
            valueVar = getVarId(toVar);
        } else if (to instanceof ElementExpr) {
            ElementExpr elementExpr = (ElementExpr) to;
            valueVar = declareNewVar(from.getType());
            assignArrayElement(elementExpr.getArrayExpr(), elementExpr.getIndex(), from, valueVar);
        } else if (to instanceof ParameterExpr) {
            ParameterNode toParam = ((ParameterExpr) to).getParameter();
            assignVarObject(toParam, from);
            valueVar = getVarId(toParam);
        } else {
            throw new UnknownError("unknown expression:" + to);
        }
        opCollector.visitVarInsn(getOpcode(from.getType(),ILOAD), valueVar);
        return null;
    }

    @Override
    public Object visitBinaryExpr(BinaryExpr node) {
        ExprNode e1 = node.getExpr1();
        ExprNode e2 = node.getExpr2();
        switch (node.getOperation()){
            case BinaryExpr.OP_SHIFT_LEFT:
            case BinaryExpr.OP_SHIFT_RIGHT:
            case BinaryExpr.OP_UNSIGNED_SHIFT_RIGHT:
                break;
            default:
                int type1 = getT(e1.getType());
                int type2 = getT(e2.getType());
                if (type1 != type2) {
                    throw new IllegalArgumentException(String.format("invalid types:%s and %s",type1,type2));
                }
        }
        int op;
        org.objectweb.asm.Type at = asmType(node.getExpr1().getType());
        switch(node.getOperation()){
            case "+": op = IADD;break;
            case "-" : op = ISUB;break;
            case "*" : op = IMUL;break;
            case "/" : op = IDIV;break;
            case "%":op = IREM;break;
            //bitwise
            case BinaryExpr.OP_AND:op = IAND;break;
            case BinaryExpr.OP_OR:op = IOR;break;
            case BinaryExpr.OP_XOR: op = IXOR;break;
            case BinaryExpr.OP_SHIFT_LEFT:op = ISHL;break;
            case BinaryExpr.OP_SHIFT_RIGHT:op = ISHR;break;
            case BinaryExpr.OP_UNSIGNED_SHIFT_RIGHT: op = IUSHR;break;
            default://logic expression
                LabelOp trueLabel = new LabelOp();
                LabelOp stopLabel = new LabelOp();
                ifExpr(true,node, trueLabel);
                constFalse();
                opCollector.visitJumpInsn(GOTO, stopLabel);
                opCollector.visitLabel(trueLabel);
                constTrue();
                opCollector.visitLabel(stopLabel);
                return null;
        }
        visit(e1);
        visit(e2);
        opCollector.visitInsn(at.getOpcode(op));
        return null;
    }
    
    protected Object getJavaConst(ConstExpr ce){
        Object v = ce.getValue();
        if(v==null){
            return null;
        }else if(v instanceof Type){
            return asmType((Type)v);
        }else{
            Type ct = ce.getType();
            if(
                    Types.isNumber(ct)
                            || Types.isBoolean(ct)
                            || Types.isCharType(ct)
                            || ct.equals(Types.getCharClassType())
                            || ct.equals(Types.getStringClassType())
            ){
                return ce.getValue();
            }
            throw Exceptions.unsupportedTypeException(ct);
        }
    }

    @Override
    public Object visitConstExpr(ConstExpr node) {
        Object v = getJavaConst(node);
        if(v == null) {
            opCollector.visitInsn(ACONST_NULL);
        } else if (v instanceof Integer) {
            int iv = (int) v;
            if (iv >= 0 && iv <= 5) {
                opCollector.visitInsn(ICONST_0 + iv);
            } else {
                opCollector.visitLdcInsn(iv);
            }
        } else if (v instanceof Long) {
            long lv = (long) v;
            if (lv == 0 || lv == 1) {
                opCollector.visitInsn(LCONST_0 + (int) lv);
            } else {
                opCollector.visitLdcInsn(lv);
            }
        } else if (v instanceof Float) {
            float fv = (float) v;
            if (fv == 0) {
                opCollector.visitInsn(FCONST_0);
            } else if (fv == 1) {
                opCollector.visitInsn(FCONST_1);
            } else {
                opCollector.visitLdcInsn(fv);
            }
        } else if (v instanceof Double) {
            double dv = (double) v;
            if (dv == 0) {
                opCollector.visitInsn(DCONST_0);
            } else if (dv == 1) {
                opCollector.visitInsn(DCONST_1);
            } else {
                opCollector.visitLdcInsn(dv);
            }
        }else{
            opCollector.visitLdcInsn(v);
        }
        return null;
    }

    @Override
    public Object visitElementExpr(ElementExpr node) {
        visit(node.getArrayExpr());
        visit(node.getIndex());
        org.objectweb.asm.Type t = asmType(node.getType());
        opCollector.visitInsn(t.getOpcode(IALOAD));
        return null;
    }

    @Override
    public Object visitFieldExpr(FieldExpr node) {
        int   opc ;
        String owner = internalName(node.getField().getFieldNode().getClassNode());
        if(node instanceof ObjectFieldExpr){
            ExprNode target =((ObjectFieldExpr)node).getTarget();
            visit(target);
            opc = GETFIELD;
        }else if(node instanceof StaticFieldExpr){
            opc = GETSTATIC;
        }else{
            throw new UnsupportedOperationException("unsupported field type:" + node);
        }
        opCollector.visitFieldInsn(opc
                ,owner
                , node.getField().getName()
                ,getTypeDescriptor(node.getType()));
        return null;
    }

    @Override
    public Object visitInvocationExpr(InvocationExpr node) {
        int opc;
        MethodDescriptor method = node.getMethod();
        String ownerClass;// = internalName(node.getMethod().classNode);
        if (node instanceof StaticInvokeExpr) {
            opc = INVOKESTATIC;
            ownerClass = internalName(((StaticInvokeExpr) node).getInvokeClass().getReferencedClassNode());
        } else if(node instanceof ObjectInvokeExpr) {
            ObjectInvokeExpr oie = (ObjectInvokeExpr) node;
            ObjectType targetType = (ObjectType) oie.getInvokeTarget().getType();
            ownerClass = internalName(targetType);
            ExprNode target = oie.getInvokeTarget();
            visit(target);
            if (Modifier.isPrivate(method.getModifier()) || (target instanceof SuperExpr) || method.getName().equals("<init>")) {
                opc = INVOKESPECIAL;
            } else {
                opc = ModifierUtil.isInterface(targetType.getClassNode().modifier) ?
                        INVOKEINTERFACE : INVOKEVIRTUAL;
            }
        }else{
            throw Exceptions.unsupportedTypeException(node);
        }
        visitAll(node.getArguments());
        opCollector.visitMethodInsn(
                opc 
                ,ownerClass
                ,method.getName()
                ,getMethodDescriptor(method.getMethodNode())
                , opc == INVOKEINTERFACE
        );
        String expectedReturnType = internalName(method.getReturnType());
        String actualReturnType = internalName(method.getMethodNode().getType());
        if (!expectedReturnType.equals(actualReturnType)) {
            opCollector.visitTypeInsn(CHECKCAST,expectedReturnType);
        }
        return null;
    }

    @Override
    public Object visitUnaryExpr(UnaryExpr node) {
        Type exprType = node.getExpr().getType();
        org.objectweb.asm.Type t = asmType(exprType);
        visit(node.getExpr());
        switch(node.getOperation()){
            case UnaryExpr.OPERATION_POS:
                break;
            case UnaryExpr.OPERATION_NEG:
                opCollector.visitInsn(t.getOpcode(INEG));
                break;
            case UnaryExpr.OPERATION_NOT:
                //TODO here I am not sure
                constX(exprType, -1);
                opCollector.visitInsn(t.getOpcode(IXOR));
                break;
                //opCollector.visitInsn(ICONST_M1);
           case UnaryExpr.OPERATION_LOGIC_NOT:
               LabelOp falseLabel = new LabelOp();
               LabelOp stopLabel = new LabelOp();
               opCollector.visitJumpInsn(IFEQ, falseLabel);
               constFalse();
               opCollector.visitJumpInsn(GOTO, stopLabel);
               opCollector.visitLabel(falseLabel);
               constTrue();
               opCollector.visitLabel(stopLabel);
               break;
           default:
               throw new UnsupportedOperationException("unsupported unary operation:" + node.getOperation());
        }
        return null;
    }

    @Override
    public Object visitVarExpr(VarExpr node) {
        visitVarObject(node.getVar());
        return null;
    }

    @Override
    public Object visitParameterExpr(ParameterExpr node) {
        visitVarObject(node.getParameter());
        return null;
    }

    @Override
    public Object visitCastExpr(CastExpr node) {
        visit(node.getExpr());
        opCollector.visitTypeInsn(CHECKCAST, internalName(node.getToType()));
        return null;
    }

    @Override
    public Object visitNewArrayExpr(NewArrayExpr node) {
        ExprNode[] sizes = node.getSizes();
        visitAll(sizes);
        Type ct = node.getComponentType();
        if (sizes.length < 1) {
            throw new IllegalArgumentException("illegal sizes length " + sizes.length);
        }
        if (sizes.length == 1) {
            int opr = -1;
            int op = NEWARRAY;
            if(ct.equals(BOOLEAN_TYPE)){
                opr = T_BOOLEAN;
            }else if(ct.equals(CHAR_TYPE)){
                opr = T_CHAR;
            }else if(ct.equals(SHORT_TYPE)){
                opr = T_SHORT;
            }else if(ct.equals(INT_TYPE)){
                opr = T_INT;
            }else if(ct.equals(LONG_TYPE)){
                opr = T_LONG;
            }else if(ct.equals(FLOAT_TYPE)){
                opr = T_FLOAT;
            }else if(ct.equals(DOUBLE_TYPE)){
                opr = T_DOUBLE;
            }else if(ct.equals(BYTE_TYPE)){
                opr = T_BYTE;
            }else{
                op = ANEWARRAY;
            }
            if(op == NEWARRAY){
                opCollector.visitIntInsn(op, opr);
            }else{
                opCollector.visitTypeInsn(ANEWARRAY, internalName(ct));
            }
        } else {
            opCollector.visitMultiANewArrayInsn(getTypeDescriptor(node.getType()), sizes.length);
        }
        return null;
    }

    @Override
    public Object visitThisExpr(ThisExpr node) {
        opCollector.visitVarInsn(ALOAD, 0);
        return null;
    }

    @Override
    public Object visitMultiStmtExpr(MultiStmtExpr node) {
        visitAll(node.getStatements());
        if (node.reference != null) {
            visit(node.reference);
        }
        return null;
    }
    
    private String getTypeDescriptor(Type[] types){
        if(types==null) return null;
        if(types.length==0) return null;
        StringBuilder ts = new StringBuilder();
        for(Type t:types){
            ts.append(getTypeDescriptor(t));
        }
        return ts.toString();
    }
    
    private String getTypeDescriptor(Type t){
        if(t instanceof PrimitiveType){
            if(t.equals(VOID_TYPE)){
                return "V";
            }else if(t.equals(BOOLEAN_TYPE)){
                return "Z";
            }else if(t.equals(LONG_TYPE)){
                return "J";
            }else if(t.equals(INT_TYPE)){
                return "I";
            }else if(t.equals(CHAR_TYPE)){
                return "C";
            }else if(t.equals(SHORT_TYPE)){
                return "S";
            }else if(t.equals(BYTE_TYPE)){
                return "B";
            }else if(t.equals(FLOAT_TYPE)){
                return "F";
            }else if(t.equals(DOUBLE_TYPE)){
                return "D";
            }else if(t.equals(NULL_TYPE)){
                return "Ljava/lang/Object;";
            }else{
                throw Exceptions.unsupportedTypeException(t);
            }
        }else if(t instanceof ArrayType){
            return "[" + getTypeDescriptor(((ArrayType)t).getComponentType());
        }else if(t instanceof GenericType){
            GenericType gt = (GenericType) t;
            ObjectType st = gt.getSuperType();
            ObjectType[] itfs = gt.getInterfaces();
            if (itfs.length == 1 && st != null && st.isAssignableFrom(itfs[0])) {
                st = itfs[0];
            }
            return getTypeDescriptor(st);
        }else if(t instanceof ClassType){
            return "L" + internalName(((ClassType) t).getClassNode().name) + ";";
        }else if(t instanceof WildcardType){
            return getTypeDescriptor(((WildcardType) t).getSuperType());
        }else{
            throw Exceptions.unsupportedTypeException(t);
        }
    }
    
    private String getClassDescriptor(String className){
        return "L" + internalName(className) + ";" ;
    }
    
    private String getMethodDescriptor(Type returnType,Type[] parameterTypes){
        StringBuilder desc = new StringBuilder();
        String retTyp = getTypeDescriptor(returnType);
        if(parameterTypes!=null){
            for(Type t:parameterTypes){
                desc.append(getTypeDescriptor(t));
            }
        }
        return "(" + desc + ")" + retTyp;     
    }
        
    private String getMethodDescriptor(MethodNode node) {
        return getMethodDescriptor(node.getType(), MethodUtil.getParameterTypes(node));
    }
    
    private org.objectweb.asm.Type asmType(Type type){
        String typeDesc = getTypeDescriptor(type);
        return org.objectweb.asm.Type.getType(typeDesc);
    }

    private int getVarId(VarObject var) {
        Integer vid = varIds.get(var);
        if(vid==null){
            throw new UnknownError("unknown var:" + var);
        }
        return vid;
    }
    
    private void visitVarObject(VarObject vo){
        org.objectweb.asm.Type type = asmType(vo.getType());
        int vid = getVarId(vo);
        opCollector.visitVarInsn(type.getOpcode(ILOAD),vid);
    }
    
    @Nonnull
    private String[] internalName(@Nonnull ClassNode[] clazz){
        String[] names = new String[clazz.length];
        for(int i=0;i<clazz.length;i++){
            names[i] = internalName(clazz[i]);
        }
        return names;
    }
    
    private String internalName(ClassNode clazz){
        return internalName(Types.getClassType(clazz));
    }

    private String internalName(Type t) {
        org.objectweb.asm.Type asmType = asmType(t);
        Objects.requireNonNull(asmType, "couldn't get asm type for " + t);
        try{
            return asmType.getInternalName();
        }catch(Exception ex){
            throw new RuntimeException("couldn't get asm type for " + t);
        }
    }
    
    private String[] internalName(Type[] types){
        String[] ts = new String[types.length];
        for(int i=0;i<types.length;i++){
            ts[i] = internalName(types[i]);
        }
        return ts;
    }
    
    @Override
    public void generateCode() {
        ClassNode classNode = compilationUnit.getAst();
        try {
            visitClassNode(classNode);
        } catch (MalformedAstException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new CodeGenerationException("fail to generate class:" + classNode.name, classNode, ex);
        }
    }

    @Override
    public Object visitVarDeclStmt(VarDeclStmt node) {
        return visitChildren(node);
    }
    
    private void primitiveCast(Type fromType,Type toType){
        if ((fromType instanceof PrimitiveType) && (toType instanceof PrimitiveType)) {
            String fn = fromType.getName();
            String tn = toType.getName();
            if (BYTE_NAME.equals(tn)) {
                switch (fn){
                    case DOUBLE_NAME:
                    case LONG_NAME:
                    case FLOAT_NAME:
                        primitiveCast(fromType,INT_TYPE);
                    case INT_NAME:
                    case SHORT_NAME:
                    case CHAR_NAME:
                        opCollector.visitInsn(I2B);
                        return;
                }
            } else if (CHAR_NAME.equals(tn)) {
                switch (fn){
                    case DOUBLE_NAME:
                    case LONG_NAME:
                    case FLOAT_NAME:
                        primitiveCast(fromType,INT_TYPE);
                    case INT_NAME:
                    case SHORT_NAME:
                    case BYTE_NAME:
                        opCollector.visitInsn(I2C);
                        return;
                }
            } else if (SHORT_NAME.equals(tn)) {
                switch (fn) {
                    case LONG_NAME:
                    case FLOAT_NAME:
                    case DOUBLE_NAME:
                        primitiveCast(fromType,INT_TYPE);
                    case INT_NAME:
                    case CHAR_NAME:
                    case BYTE_NAME:
                        opCollector.visitInsn(I2S);
                        return;
                }
            } else if (INT_NAME.equals(tn)) {
                switch (fn) {
                    case BYTE_NAME:
                    case CHAR_NAME:
                    case SHORT_NAME:
                        return;
                    case FLOAT_NAME:
                        opCollector.visitInsn(F2I);
                        return;
                    case LONG_NAME:
                        opCollector.visitInsn(L2I);
                        return;
                    case DOUBLE_NAME:
                        opCollector.visitInsn(D2I);
                        return;
                }
            } else if (FLOAT_NAME.equals(tn)) {
                switch (fn) {
                    case BYTE_NAME:
                    case CHAR_NAME:
                    case SHORT_NAME:
                    case INT_NAME:
                        opCollector.visitInsn(I2F);
                        return;
                    case LONG_NAME:
                        opCollector.visitInsn(L2F);
                        return;
                    case DOUBLE_NAME:
                        opCollector.visitInsn(D2F);
                        return;
                }
            } else if (LONG_NAME.equals(tn)) {
                switch (fn) {
                    case BYTE_NAME:
                    case CHAR_NAME:
                    case SHORT_NAME:
                    case INT_NAME:
                        opCollector.visitInsn(I2L);
                        return;
                    case FLOAT_NAME:
                        opCollector.visitInsn(F2L);
                        return;
                    case DOUBLE_NAME:
                        opCollector.visitInsn(D2L);
                        return;
                }
            } else if (DOUBLE_NAME.equals(tn)) {
                switch (fn) {
                    case BYTE_NAME:
                    case CHAR_NAME:
                    case SHORT_NAME:
                    case INT_NAME:
                        opCollector.visitInsn(I2D);
                        return;
                    case LONG_NAME:
                        opCollector.visitInsn(L2D);
                        return;
                    case FLOAT_NAME:
                        opCollector.visitInsn(F2D);
                        return;
                    }
            }
        }
        throw Exceptions.unexpectedException("It is unable to cast " + fromType + " to " + toType);
    }

    @Override
    public Object visitPrimitiveCastExpr(PrimitiveCastExpr node) {
        ExprNode expr = node.getExpr();
        visit(expr);
        Type ft = expr.getType();
        Type tt = node.getToType();
        primitiveCast(ft, tt);
        return null;
    }

    @Override
    public Object visitLocalVarNode(LocalVarNode localVarNode) {
        this.declareNewVar(localVarNode);
        return null;
    }

    @Override
    public Object visitParameterNode(ParameterNode parameterNode) {
        throw Exceptions.unexpectedException("visit parameter node");
    }

    @Override
    public Object visitFieldNode(FieldNode fieldNode) {
        classWriter.visitField(fieldNode.modifier, fieldNode.getName(), getTypeDescriptor(fieldNode.getType()), null, null);
        return null;
    }

    @Override
    public Object visitNewObjectExpr(NewObjectExpr node) {
        org.objectweb.asm.Type t = asmType(node.getObjectType());
        opCollector.visitTypeInsn(NEW, t.getInternalName());
        opCollector.visitInsn(DUP);
        visitAll(node.getConstructor().getArguments());
        opCollector.visitMethodInsn(
                INVOKESPECIAL
                , t.getInternalName()
                , "<init>"
                ,getMethodDescriptor(node.getConstructor().getMethod().getMethodNode())
                , false);
        return null;
    }

    private void dupX(Type type){
        int size = asmType(type).getSize();
        if(size==1) opCollector.visitInsn(DUP);
        else if(size==2) opCollector.visitInsn(DUP2);
        else throw new UnsupportedOperationException("unsupported type:" + type);
    }
    
    private ConstExpr getConstX(Type type, int i) {
        Object obj;
        int t = getT(type);
        switch (t) {
            case T_I:
                obj = i;
                break;
            case T_L:
                obj = (long) i;
                break;
            case T_F:
                obj = (float) i;
                break;
            case T_D:
                obj = (double) i;
                break;
            default:
                throw new UnsupportedOperationException("unsupported type:" + type);
        }
        return new ConstExpr(obj);
    }
    private void constX(Object x){
        opCollector.visitLdcInsn(x);
    }

    private void constX(Type type,int i) {
        visitConstExpr(getConstX(type, i));
    }

    @Override
    public Object visit(AstNode node) {
        int lineNum = node.offset.startLine;
        if(lineNum>0 && (node instanceof Statement || node instanceof ExprNode) &&  !lineLabels.containsKey(lineNum)){
            LabelOp lb = new LabelOp();
            opCollector.visitLabel(lb);
            opCollector.visitLineNumber(lineNum, lb);
            lineLabels.put(lineNum, lb);
        }
        return super.visit(node);
    }

    @Override
    public Object visitArrayLengthExpr(ArrayLengthExpr node) {
        visit(node.getArrayExpr());
        opCollector.visitInsn(ARRAYLENGTH);
        return null;
    }
    
    private void constTrue(){
        constX(1);
    }
    
    private void constFalse(){
        constX(0);
    }

    @Override
    public Object visitUnknownFieldExpr(UnknownFieldExpr node) {
        throw new UnsupportedOperationException("BUG:invoking unknown method:" + node.getFieldName());
    }

    @Override
    public Object visitUnknownInvocationExpr(UnknownInvocationExpr node) {
        throw new UnsupportedOperationException("BUG:invoking unknown method:" + node.getMethodName());
    }

    @Override
    public Object visitClassReference(ClassReference node) {
        //do nothing
        return null;
    }

    @Override
    public Object visitSuperExpr(SuperExpr node) {
        opCollector.visitVarInsn(ALOAD, 0);
        return null;
    }

    @Override
    public Object visitErrorousExpr(ErrorousExpr node) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitInstanceOfExpr(InstanceOfExpr node) {
        visit(node.getExpr());
        opCollector.visitTypeInsn(INSTANCEOF, internalName(node.getTarget().getReferencedClassNode()));
        return null;
    }

    private void ifCompare(boolean jumpOnTrue,ExprNode expr1, ExprNode expr2, String op, LabelOp label) {
        Type type = expr1.getType();
        visit(expr1);
        visit(expr2);
        int t = getT(type);
        if(T_I == t){
            int opc;
            switch(op){
                case "==" :
                    opc = jumpOnTrue ? IF_ICMPEQ : IF_ICMPNE;
                    break;
                case ">"    : 
                    opc =jumpOnTrue ? IF_ICMPGT : IF_ICMPLE;
                    break;
                case ">=" : 
                    opc =jumpOnTrue ? IF_ICMPGE : IF_ICMPLT;
                    break;
                case "<"   : 
                    opc = jumpOnTrue ? IF_ICMPLT : IF_ICMPGE;
                    break;
                case "<=" : 
                    opc =jumpOnTrue ? IF_ICMPLE : IF_ICMPGT;
                    break;
                case "!=" : 
                    opc = jumpOnTrue ? IF_ICMPNE : IF_ICMPEQ;
                    break;
                default:
                    throw  new UnsupportedOperationException("Unsupported operation:" + op);
            }
            opCollector.visitJumpInsn(opc, label);
        }else if(T_A==t){//object type
             if(op.equals("==")){
                opCollector.visitJumpInsn(jumpOnTrue ? IF_ACMPEQ : IF_ACMPNE,label);
            }else if(op.equals("!=")){
                opCollector.visitJumpInsn(jumpOnTrue ? IF_ACMPNE:IF_ACMPEQ,label);
            }else{
                throw new UnsupportedOperationException("It is unsupported to compare object type:" + type);
            }
        }else{//type is not int,not object            
            if(T_L==t){
                opCollector.visitInsn(LCMP);
            }else if(T_F==t){
                opCollector.visitInsn(FCMPL);
            }else if(T_D==t){
                opCollector.visitInsn(DCMPL);
            }else{
               throw new UnsupportedOperationException("It is unsupported to compare object type:" + type);
            }
            int opc;
            switch(op){
                case "==" : opc =jumpOnTrue ? IFEQ : IFNE;break;
                case ">"    : opc =jumpOnTrue ? IFGT : IFLE ;break;
                case ">=" : opc =jumpOnTrue ? IFGE : IFLT ;break;
                case "<"   : opc =jumpOnTrue ? IFLT:IFGE;break;
                case "<=" : opc =jumpOnTrue ? IFLE:IFGT;break;
                case "!=" : opc =jumpOnTrue ? IFNE:IFEQ;break;
                default:
                    throw  new UnsupportedOperationException("Unsupported operation:" + op);
            }
            opCollector.visitJumpInsn(opc, label);
        }
    }

    @Override
    public Object visitMultiStmt(MultiStmt node) {
        visitAll(node.statements);
        return null;
    }

    @Override
    public Object visitLambdaExpr(LambdaExpr node) {
        MethodNode invokeMethod = node.getInvokeMethod();
        boolean isStatic = ModifierUtil.isStatic(invokeMethod.getModifier());
        for (ExprNode arg: node.getCaptureArguments()) {
            visit(arg);
        }
        MethodDescriptor interfaceMd = node.getInterfaceMethod();
        List<Type> invokeTypes = CollectionMixin.map(node.getCaptureArguments(), ExprNode::getType);
        String invokeMdDesc = getMethodDescriptor(Types.getClassType(interfaceMd.getMethodNode().getClassNode()), invokeTypes.toArray(new Type[0]));
        String mdDesc = getMethodDescriptor(interfaceMd.getReturnType(), interfaceMd.getParameterTypes());
        String metafactoryDesc = org.objectweb.asm.Type.getMethodDescriptor(
                org.objectweb.asm.Type.getType(CallSite.class)
                , org.objectweb.asm.Type.getType(MethodHandles.Lookup.class)
                , org.objectweb.asm.Type.getType(String.class)
                , org.objectweb.asm.Type.getType(MethodType.class)
                , org.objectweb.asm.Type.getType(MethodType.class)
                , org.objectweb.asm.Type.getType(MethodHandle.class)
                , org.objectweb.asm.Type.getType(MethodType.class)
        );
        int invokeTag;
        if (isStatic) {
            invokeTag = H_INVOKESTATIC;
        } else if (invokeMethod.getClassNode().equals(clazz)) {
            invokeTag = H_INVOKESPECIAL;
        } else {
            invokeTag = H_INVOKEVIRTUAL;
        }
        Object[] bootstrapArgs = new Object[] {
                org.objectweb.asm.Type.getMethodType(getMethodDescriptor(interfaceMd.getMethodNode()))
                , new Handle(invokeTag, internalName(invokeMethod.getClassNode()), invokeMethod.getName(), getMethodDescriptor(invokeMethod), false)
                , org.objectweb.asm.Type.getMethodType(mdDesc)
        };
        Handle bootstrapMd = new Handle(H_INVOKESTATIC, internalName(LambdaMetafactory.class.getName()), "metafactory", metafactoryDesc, false);
        opCollector.visitInvokeDynamicInsn(interfaceMd.getName(), invokeMdDesc, bootstrapMd, bootstrapArgs);
        return null;
    }

    private void createInterfaceBridgeMethodIfNeed(MethodNode interfaceMethod,MethodNode implementMethod) {
        String desc = getMethodDescriptor(interfaceMethod);
        String implementDesc = getMethodDescriptor(implementMethod);
        if (desc.equals(implementDesc)) {
            return;
        }
        int access = interfaceMethod.getModifier() & ~Modifier.ABSTRACT;
        String name = interfaceMethod.getName();
        MethodVisitor methodVisitor = classWriter.visitMethod(access, name, desc, methodSignature(interfaceMethod), null);
        ParameterNode[] params = interfaceMethod.getParameters();
        for(ParameterNode p : params) {
            methodVisitor.visitParameter(p.getName(),p.modifier);
        }
        ParameterNode[] implementedParams = implementMethod.getParameters();
        methodVisitor.visitVarInsn(ALOAD,0);
        int varIdx = 1;
        for(int i=0;i<params.length;i++) {
            Type implementedParamType = implementedParams[i].getType();
            Type interfaceParamType = params[i].getType();
            org.objectweb.asm.Type interfaceParamAsmType = asmType(interfaceParamType);
            methodVisitor.visitVarInsn(interfaceParamAsmType.getOpcode(ILOAD),varIdx);
            if (!implementedParamType.isAssignableFrom(interfaceParamType)) {
                methodVisitor.visitTypeInsn(CHECKCAST,internalName(implementedParamType));
            }
            varIdx += interfaceParamAsmType.getSize();
        }
        String owner = internalName(implementMethod.getClassNode());
        methodVisitor.visitMethodInsn(INVOKEVIRTUAL,owner,implementMethod.getName(),implementDesc,false);
        Type returnType = interfaceMethod.getType();
        if (VOID_TYPE.equals(returnType)) {
            methodVisitor.visitInsn(RETURN);
        } else {
            methodVisitor.visitInsn(asmType(returnType).getOpcode(IRETURN));
        }
        methodVisitor.visitMaxs(0,0);
        methodVisitor.visitEnd();
    }

    private int getOpcode(Type type, int opcode) {
        return asmType(type).getOpcode(opcode);
    }


    private static class KlClassWriter extends ClassWriter {

        private AstLoader astLoader;

        public KlClassWriter(int flags, AstLoader astLoader) {
            super(flags);
            this.astLoader = astLoader;
        }

        @Override
        protected String getCommonSuperClass(String type1, String type2) {
            ClassNode cn1;
            try {
                cn1 = astLoader.loadAst(type1.replace('/', '.'));
            } catch (AstNotFoundException e) {
                throw new TypeNotPresentException(type1, e);
            }
            ClassNode cn2;
            try {
                cn2 = astLoader.loadAst(type2.replace('/', '.'));
            } catch (AstNotFoundException e) {
                throw new TypeNotPresentException(type2, e);
            }
            ObjectType t1 = getClassType(cn1);
            ObjectType t2 = getClassType(cn2);
            if (t1.isAssignableFrom(t2)) {
                return type1;
            }
            if (t2.isAssignableFrom(t1)) {
                return type2;
            }
            if (ModifierUtil.isInterface(cn1.modifier) || ModifierUtil.isInterface(cn2.modifier)) {
                return "java/lang/Object";
            } else {
                do {
                    t1 = t1.getSuperType();
                    assert t1 != null;
                } while (!t1.isAssignableFrom(t2));
                return t1.getName().replace('.', '/');
            }
        }
    }

    private void applyOp(MethodVisitor mv, OpCollector opCollector) {
        new OpOptimizer().optimize(opCollector);
        Map<LabelOp, Label> labelMap = new HashMap<>();
        Function<LabelOp, Label> labelMapper = lb -> labelMap.computeIfAbsent(lb, (k) -> new Label());
        for (OpBase code : opCollector) {
            if (code instanceof FieldInsnOp) {
                FieldInsnOp fio = (FieldInsnOp) code;
                mv.visitFieldInsn(fio.opcode, fio.owner, fio.name, fio.descriptor);
            } else if (code instanceof InsnOp) {
                mv.visitInsn(((InsnOp) code).opcode);
            } else if (code instanceof IntInsnOp) {
                IntInsnOp iio = (IntInsnOp) code;
                mv.visitIntInsn(iio.opcode, iio.operand);
            } else if (code instanceof InvokeDynamicInsnOp) {
                InvokeDynamicInsnOp op = (InvokeDynamicInsnOp) code;
                mv.visitInvokeDynamicInsn(op.name, op.descriptor, op.bootstrapMethodHandle, op.bootstrapMethodArguments);
            } else if (code instanceof JumpInsnOp) {
                JumpInsnOp op = (JumpInsnOp) code;
                mv.visitJumpInsn(op.opcode, labelMapper.apply(op.label));
            } else if (code instanceof LabelOp) {
                mv.visitLabel(labelMapper.apply((LabelOp)code));
            } else if (code instanceof LdcInsnOp) {
                mv.visitLdcInsn(((LdcInsnOp) code).value);
            } else if (code instanceof MethodInsnOp) {
                MethodInsnOp op = (MethodInsnOp) code;
                mv.visitMethodInsn(op.opcode, op.owner, op.name, op.descriptor, op.isInterface);
            } else if (code instanceof MultiANewArrayInsnOp) {
                MultiANewArrayInsnOp op = (MultiANewArrayInsnOp) code;
                mv.visitMultiANewArrayInsn(op.descriptor, op.numDimensions);
            } else if (code instanceof TypeInsnOp) {
                TypeInsnOp op = (TypeInsnOp) code;
                mv.visitTypeInsn(op.opcode, op.type);
            } else if (code instanceof VarInsnOp) {
                VarInsnOp op = (VarInsnOp) code;
                mv.visitVarInsn(op.opcode, op.var);
            } else {
                throw Exceptions.unexpectedValue(code);
            }
        }
        for (LocalVariable lv: opCollector.getLocalVariables()) {
            mv.visitLocalVariable(lv.name, lv.descriptor, lv.signature, labelMapper.apply(lv.start), labelMapper.apply(lv.end), lv.index);
        }
        for (LineNumber ln : opCollector.getLineNumbers()) {
            mv.visitLineNumber(ln.lineNum, labelMapper.apply(ln.label));
        }
        for (TryCatchBlock tcb : opCollector.getTryCatchBlocks()) {
            mv.visitTryCatchBlock(
                    labelMapper.apply(tcb.start),
                    labelMapper.apply(tcb.end),
                    labelMapper.apply(tcb.handler),
                    tcb.type
            );
        }
    }

}
