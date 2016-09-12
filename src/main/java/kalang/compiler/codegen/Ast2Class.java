
package kalang.compiler.codegen;
import kalang.ast.AbstractAstVisitor;
import kalang.ast.AssignExpr;
import kalang.ast.AstVisitor;
import kalang.ast.BinaryExpr;
import kalang.ast.BlockStmt;
import kalang.ast.BreakStmt;
import kalang.ast.CastExpr;
import kalang.ast.CatchBlock;
import kalang.ast.ClassNode;
import kalang.ast.ConstExpr;
import kalang.ast.ContinueStmt;
import kalang.ast.ElementExpr;
import kalang.ast.ExprStmt;
import kalang.ast.FieldExpr;
import kalang.ast.IfStmt;
import kalang.ast.InvocationExpr;
import kalang.ast.ThisExpr;
import kalang.ast.LoopStmt;
import kalang.ast.MethodNode;
import kalang.ast.MultiStmtExpr;
import kalang.ast.NewArrayExpr;
import kalang.ast.ParameterExpr;
import kalang.ast.ReturnStmt;
import kalang.ast.ThrowStmt;
import kalang.ast.TryStmt;
import kalang.ast.UnaryExpr;
import kalang.ast.VarExpr;
import kalang.ast.VarObject;
import java.io.*;
import java.lang.reflect.Modifier;
import java.nio.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import kalang.AstNotFoundException;
import kalang.ast.AnnotationNode;
import kalang.ast.ArrayLengthExpr;
import kalang.ast.AssignableExpr;
import kalang.ast.AstNode;
import kalang.ast.ClassReference;
import kalang.ast.CompareExpr;
import kalang.ast.ErrorousExpr;
import kalang.ast.ExprNode;
import kalang.ast.FieldNode;
import kalang.ast.IncrementExpr;
import kalang.ast.InstanceOfExpr;
import kalang.ast.LocalVarNode;
import kalang.ast.LogicExpr;
import kalang.ast.MathExpr;
import kalang.ast.MultiStmt;
import kalang.ast.NewObjectExpr;
import kalang.ast.ObjectFieldExpr;
import kalang.ast.ObjectInvokeExpr;
import kalang.ast.ParameterNode;
import kalang.ast.PrimitiveCastExpr;
import kalang.ast.Statement;
import kalang.ast.StaticFieldExpr;
import kalang.ast.StaticInvokeExpr;
import kalang.ast.StoreArrayElementExpr;
import kalang.ast.SuperExpr;
import kalang.ast.UnknownFieldExpr;
import kalang.ast.UnknownInvocationExpr;
import kalang.ast.VarDeclStmt;
import kalang.compiler.AstLoader;
import kalang.compiler.CodeGenerator;
import kalang.core.ArrayType;
import kalang.core.ObjectType;
import kalang.core.ExecutableDescriptor;
import kalang.core.GenericType;
import kalang.core.ClassType;
import kalang.core.NullableKind;
import kalang.core.PrimitiveType;
import kalang.core.Type;
import kalang.core.Types;
import static kalang.core.Types.*;
import kalang.core.VarTable;
import kalang.core.WildcardType;
import kalang.exception.Exceptions;
import kalang.tool.OutputManager;
import kalang.util.AstUtil;
import kalang.util.MethodUtil;
import kalang.util.ModifierUtil;
import kalang.util.NameUtil;
import kalang.util.Parameters;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import static org.objectweb.asm.Opcodes.*;
/**
 *The class generate the java class binary data for ast
 * 
 * @author Kason Yang <i@kasonyang.com>
 */
public class Ast2Class extends AbstractAstVisitor<Object> implements CodeGenerator{

    private ClassWriter classWriter;
    private MethodVisitor md;
    
    OutputManager outputManager;
    
    private Map<Integer,Label> lineLabels = new HashMap();
    
    private Map<VarObject,Integer> varIds = new HashMap<>();
    
    private int varIdCounter = 0;
    
    private Stack<Label> breakLabels = new Stack<>();
    private Stack<Label> continueLabels = new Stack<>();
    
    private Label methodStartLabel ;
    private Label methodEndLabel;
    
    List<LocalVariableInfo> localVarInfos;
    
    private final static int 
            T_I = 0,
            T_L = 1,
            T_F = 2,
            T_D = 3,
            T_A = 4;
    private ClassNode clazz;
    private String classInternalName;

    public Ast2Class(OutputManager outputManager) {
        this.outputManager = outputManager;
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
        String gnrTypeStr = "";
        for(GenericType t:genericTypes){
            gnrTypeStr += t.getName() + ":" + "Ljava/lang/Object;";
        }
        String superTypeStr = "";
        if(c.superType!=null) superTypeStr += typeSignature(c.superType);
        for(ObjectType itf:c.interfaces){
            superTypeStr += typeSignature(itf);
        }
        return "<" + gnrTypeStr + ">" + superTypeStr ;
        
    }
    
    private String methodSignature(MethodNode m){
        String ptype = "";
        for(ParameterNode p:m.parameters){
            ptype += typeSignature(p.type);
        }
        return "(" + ptype + ")" + typeSignature(m.type);
    }
    
    @Nullable
    private String typeSignature(Type type){
        if(type instanceof GenericType){
            return "T" + type.getName() + ";" ;
        }else if(type instanceof ClassType){
            ClassType pt = (ClassType) type;
            String ptypes = "";
            for(Type p:pt.getTypeArguments()){
                ptypes += typeSignature(p);
            }
            if(!ptypes.isEmpty()) ptypes = "<" + ptypes + ">";
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
        this.classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        annotation(classWriter, clazz.getAnnotations());
        String parentName = "java.lang.Object";
        ObjectType superType = node.superType;
        if(superType!=null){
            parentName = superType.getName();
        }
        String[] interfaces = null;
        if(node.interfaces!=null){
            interfaces = internalName(node.interfaces.toArray(new Type[0]));
        }
        int access = node.modifier;
        classWriter.visit(V1_6, access,internalName(node.name),classSignature(node), internalName(parentName),interfaces);        String fileName = node.fileName;
        if(fileName!=null && !fileName.isEmpty()){
            classWriter.visitSource(fileName, null);
        }
        visitChildren(node);
        //clinit
        if(!node.staticInitStmts.isEmpty()){
            md = classWriter.visitMethod(ACC_STATIC, "<clinit>", "()V", null, null);
            visitAll(node.staticInitStmts);
            md.visitInsn(RETURN);
            md.visitMaxs(1, 1);
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
    private static final Logger LOG = Logger.getLogger(Ast2Class.class.getName());

    @Override
    public Object visitMethodNode(MethodNode node) {
        int access = node.modifier;
        md = classWriter.visitMethod(access, internalName(node.name),getMethodDescriptor(node),methodSignature(node),internalName(node.exceptionTypes.toArray(new Type[0])) );
        if(node.type instanceof ObjectType){
            annotationNullable(md,(ObjectType)node.type);
        }
        annotation(md, node.getAnnotations());
        this.methodStartLabel = new Label();
        this.methodEndLabel = new Label();
        localVarInfos = new LinkedList();
        if(AstUtil.isStatic(node.modifier)){
            varIdCounter = 0;
        }else{
            localVarInfos.add(new LocalVariableInfo("this", this.getClassDescriptor(this.clazz.name) , null, methodStartLabel, methodEndLabel, 0));
            varIdCounter = 1;
        }
        BlockStmt body = node.body;
        for(int i=0;i<node.parameters.size();i++){
            ParameterNode p = node.parameters.get(i);
            visit(p);
            if(p.type instanceof ObjectType){
                md.visitParameterAnnotation(i,getClassDescriptor(getNullableAnnotation((ObjectType)p.type)), true).visitEnd();
            }
        }
        md.visitLabel(methodStartLabel);
        if(body!=null){
            visit(body);
            if(node.type.equals(VOID_TYPE)){
                md.visitInsn(RETURN);
            }
            md.visitLabel(methodEndLabel);
            for(ParameterNode p:node.parameters){
                this.saveVarInfomation(p, methodStartLabel, methodEndLabel);
            }
            for(LocalVariableInfo li:localVarInfos){
                md.visitLocalVariable(li.getName(), li.getDescriptor(), li.getSignature(), li.getStartLabel(), li.getEndLabel(), li.getIndex());
            }
            try{
                md.visitMaxs(0, 0);
            }catch(Exception ex){
                ex.printStackTrace(System.err);
                //throw new RuntimeException("exception when visit method:" + node.name, ex);
            }
        }
        md.visitEnd();
        return null;
    }
    
    private void declareNewVar(VarObject vo){
        int vid = varIdCounter;
        int vSize = asmType(vo.type).getSize();
        varIdCounter+= vSize;
        varIds.put(vo, vid);            
    }
    
    private void saveVarInfomation(VarObject vo,Label startLabel,Label endLabel){
            int vid = this.getVarId(vo);
            if(vo.name!=null){
                this.localVarInfos.add(new LocalVariableInfo(vo.name, getTypeDescriptor(vo.getType()), null, startLabel, endLabel, vid));
            }
    }

    @Override
    public Object visitBlockStmt(BlockStmt node) {
        VarTable<String, LocalVarNode> varTable = node.getScopeVarTable();
        int varCounter = this.varIdCounter;
        LocalVarNode[] vars = varTable.toArray(new LocalVarNode[0]);
        Label startLabel = new Label();
        Label endLabel = new Label();
        md.visitLabel(startLabel);
        visitChildren(node);
        md.visitLabel(endLabel);
        for(int i=0;i<vars.length;i++){
            this.saveVarInfomation(vars[i], startLabel, endLabel);
        }
        this.varIdCounter = varCounter;
        return null;
    }

    @Override
    public Object visitBreakStmt(BreakStmt node) {
        md.visitJumpInsn(GOTO, breakLabels.peek());
        return null;
    }

    @Override
    public Object visitContinueStmt(ContinueStmt node) {
        md.visitJumpInsn(GOTO, continueLabels.peek());
        return null;
    }
    
    private void pop(Type type){
        int size =  asmType(type).getSize();
        if(size==1){
            md.visitInsn(POP);
        }else if(size==2){
            md.visitInsn(POP2);
        }else{
            throw new UnsupportedOperationException("It is unsupported to pop for the type:" + type);
        }
    }

    @Override
    public Object visitExprStmt(ExprStmt node) {
        visitChildren(node);
        Type type = node.getExpr().getType();
        if(type !=null && !Types.VOID_TYPE.equals(type)){
            pop(type);
        }
        return null;
    }
    
    private void ifExpr(boolean jumpOnTrue,ExprNode condition,Label label){
        if(condition instanceof LogicExpr){
            LogicExpr be = (LogicExpr) condition;
            ExprNode e1 = be.getExpr1();
            ExprNode e2 = be.getExpr2();
            String op = be.getOperation();
            switch(op){
                case "&&":
                    if(jumpOnTrue){
                        Label stopLabel = new Label();
                        ifExpr(false,e1,stopLabel);
                        ifExpr(false,e2,stopLabel);
                        md.visitJumpInsn(GOTO, label);
                        md.visitLabel(stopLabel);
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
                        Label stopLabel = new Label();
                        ifExpr(true, e1, stopLabel);
                        ifExpr(true, e2, stopLabel);
                        md.visitJumpInsn(GOTO, label);
                        md.visitLabel(stopLabel);
                    }
                    break;
                default:
                    throw  new UnsupportedOperationException("Unsupported operation:" + op);
            }
        }else if(condition instanceof CompareExpr){
            ifCompare(jumpOnTrue,((CompareExpr) condition).getExpr1(), ((CompareExpr) condition).getExpr2(), ((CompareExpr) condition).getOperation(), label);
        }else if(condition instanceof UnaryExpr && ((UnaryExpr)condition).getOperation().equals("!")){
            ifExpr(!jumpOnTrue, ((UnaryExpr)condition).getExpr(), label);
        }else{
            visit(condition);
            md.visitJumpInsn(jumpOnTrue ? IFNE : IFEQ, label);
        }
    }

    @Override
    public Object visitIfStmt(IfStmt node) {
        Label stopLabel = new Label();
        Label falseLabel = new Label();
        ExprNode condition = node.getConditionExpr();
        Statement trueBody = node.getTrueBody();
        Statement falseBody = node.getFalseBody();    
        ifExpr(false,condition,falseLabel);
        if(trueBody!=null){
            visit(trueBody);
        }
        if(falseBody==null){
            md.visitLabel(falseLabel);
        }else{
            md.visitJumpInsn(GOTO, stopLabel);
            md.visitLabel(falseLabel);
            visit(falseBody);
        }
        md.visitLabel(stopLabel);
        return null;
    }

    @Override
    public Object visitLoopStmt(LoopStmt node) {
        //visitAll(node.initStmts);
        Label startLabel = new Label();
        Label stopLabel = new Label();
        continueLabels.push(startLabel);
        breakLabels.push(stopLabel);
        md.visitLabel(startLabel);
        if(node.preConditionExpr!=null){
            ifExpr(false,node.preConditionExpr,stopLabel);
        }
        visit(node.loopBody);
        if(node.postConditionExpr!=null){
            ifExpr(false,node.postConditionExpr,stopLabel);
        }
        md.visitJumpInsn(GOTO, startLabel);
        md.visitLabel(stopLabel);
        continueLabels.pop();
        breakLabels.pop();
        return null;
    }

    @Override
    public Object visitReturnStmt(ReturnStmt node) {
        int lnsn = RETURN;
        if(node.expr!=null){
            visit(node.expr);
            Type type = node.expr.getType();
            lnsn = asmType(type).getOpcode(IRETURN);
        }
        md.visitInsn(lnsn);
        return null;
    }

    @Override
    public Object visitTryStmt(TryStmt node) {
        Label startLabel = new Label();
        Label endLabel = new Label();
        Label stopLabel = new Label();
        md.visitLabel(startLabel);
        visit(node.getExecStmt());
        md.visitJumpInsn(GOTO, stopLabel);
        md.visitLabel(endLabel);
        if(node.getCatchStmts()!=null){
            for(CatchBlock s:node.getCatchStmts()){
                Label handler = new Label();
                md.visitLabel(handler);
                visit(s);
                md.visitJumpInsn(GOTO, stopLabel);
                String type = asmType(s.catchVar.type).getInternalName();
                md.visitTryCatchBlock(startLabel, endLabel, handler,type);
            }
        }
        if(node.getFinallyStmt()!=null){
            Label handler = new Label();
            md.visitLabel(handler);
            visit(node.getFinallyStmt());
            md.visitJumpInsn(GOTO, stopLabel);
            md.visitTryCatchBlock(startLabel, endLabel, handler, null);
        }
        md.visitLabel(stopLabel);
        return null;
    }

    @Override
    public Object visitCatchBlock(CatchBlock node) {
        visit(node.catchVar);
        int exVarId = getVarId(node.catchVar);
        md.visitVarInsn(ASTORE, exVarId);
        visit(node.execStmt);
        return null;
    }

    @Override
    public Object visitThrowStmt(ThrowStmt node) {
        visit(node.expr);
        md.visitInsn(ATHROW);
        return null;
    }
    
    private void assignVarObject(VarObject to,ExprNode from){
        org.objectweb.asm.Type type = asmType(to.type);
        visit(from);
        int vid = getVarId(to);
        md.visitVarInsn(type.getOpcode(ISTORE), vid);
    }
    
    private void assignField(FieldNode fn,ExprNode target,ExprNode expr){
        int opc = PUTFIELD;
        if (AstUtil.isStatic(fn.modifier)) {
            opc = PUTSTATIC;
        } else {
            visit(target);
        }
        visit(expr);
        md.visitFieldInsn(opc,
                asmType(Types.getClassType(fn.classNode)).getInternalName(), fn.name, getTypeDescriptor(fn.type));
    }
    
    private void assignField(FieldExpr fieldExpr,ExprNode expr){
        if(fieldExpr instanceof StaticFieldExpr){
            assignField(fieldExpr.getField().getFieldNode(), null, expr);
        }else if(fieldExpr instanceof ObjectFieldExpr){
            assignField(fieldExpr.getField().getFieldNode(), ((ObjectFieldExpr) fieldExpr).getTarget(), expr);
        }else{
            throw new UnsupportedOperationException();
        }
    }
    
    private void astore(ExprNode expr){
        visit(expr);
        org.objectweb.asm.Type type = asmType(expr.getType());
        md.visitInsn(type.getOpcode(IASTORE));
    }
    
    private void assignArrayElement(ExprNode array,ExprNode key,ExprNode value){
        Parameters.requireNonNull(array);
        Parameters.requireNonNull(key);
        Parameters.requireNonNull(value);
        visit(array);
        visit(key);
        astore(value);
    }
    
    private void assign(ExprNode to,ExprNode from){
        if(to instanceof FieldExpr){
            FieldExpr toField = (FieldExpr) to;
            assignField(toField, from);
        }else if(to instanceof VarExpr){
            assignVarObject(((VarExpr) to).getVar(), from);
        }else if(to instanceof ElementExpr){
            ElementExpr elementExpr = (ElementExpr) to;
            assignArrayElement(elementExpr.getArrayExpr(), elementExpr.getIndex(), from);
        }else{
            throw new UnknownError("unknown expression:" + to);
        }
    }

    @Override
    public Object visitAssignExpr(AssignExpr node) {
        assign(node.getTo(), node.getFrom());
        visit(node.getTo());
        return null;
    }

    @Override
    public Object visitBinaryExpr(BinaryExpr node) {
        ExprNode e1 = node.getExpr1();
        ExprNode e2 = node.getExpr2();
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
            default://logic expression
                Label trueLabel = new Label();
                Label stopLabel = new Label();
                ifExpr(true,node, trueLabel);
                constFalse();
                md.visitJumpInsn(GOTO, stopLabel);
                md.visitLabel(trueLabel);
                constTrue();
                md.visitLabel(stopLabel);
                return null;
        }
        visit(e1);
        visit(e2);
        md.visitInsn(at.getOpcode(op));
        return null;
    }
    
    protected Object getJavaConst(ConstExpr ce){
        Object v = ce.getValue();
        if(v==null){
            return null;
        }else if(v instanceof ClassReference){
            return asmType(Types.getClassType(((ClassReference) v).getReferencedClassNode()));
        }else{
            Type ct = ce.getType();
            if(
                    Types.isNumber(ct)
                    || Types.isBoolean(ct)
                    || ct.equals(Types.getCharClassType())
                    || ct.equals(Types.getStringClassType())
                    ){
                return ce.getValue();
            }
            throw Exceptions.unsupportedTypeException(ce);
        }
    }

    @Override
    public Object visitConstExpr(ConstExpr node) {
        Object v = getJavaConst(node);
        if(v==null){
            md.visitInsn(ACONST_NULL);
        }else{
            md.visitLdcInsn(v);
        }
        return null;
    }

    @Override
    public Object visitElementExpr(ElementExpr node) {
        visit(node.getArrayExpr());
        visit(node.getIndex());
        org.objectweb.asm.Type t = asmType(node.getType());
        md.visitInsn(t.getOpcode(IALOAD));
        return null;
    }

    @Override
    public Object visitFieldExpr(FieldExpr node) {
        int   opc ;
        String owner = internalName(node.getField().getFieldNode().classNode);
        if(node instanceof ObjectFieldExpr){
            ExprNode target =((ObjectFieldExpr)node).getTarget();
            visit(target);
            opc = GETFIELD;
        }else if(node instanceof StaticFieldExpr){
            opc = GETSTATIC;
        }else{
            throw new UnsupportedOperationException("unsupported field type:" + node);
        }
        md.visitFieldInsn(opc
                ,owner
                , node.getField().getName()
                ,getTypeDescriptor(node.getType()));
        return null;
    }

    @Override
    public Object visitInvocationExpr(InvocationExpr node) {
        int opc;
        ExecutableDescriptor method = node.getMethod();
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
            if (target instanceof SuperExpr || method.getName().equals("<init>")) {
                opc = INVOKESPECIAL;
            } else {
                opc =ModifierUtil.isInterface(targetType.getClassNode().modifier) ?
                        INVOKEINTERFACE : INVOKEVIRTUAL;
            }
        }else{
            throw Exceptions.unsupportedTypeException(node);
        }
        visitAll(node.getArguments());
        md.visitMethodInsn(
                opc 
                ,ownerClass
                ,method.getName()
                ,getMethodDescriptor(method.getMethodNode())
        );
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
                md.visitInsn(t.getOpcode(INEG));
                break;
            case UnaryExpr.OPERATION_NOT:
                //TODO here I am not sure
                constX(exprType, -1);
                md.visitInsn(t.getOpcode(IXOR));
                break;
                //md.visitInsn(ICONST_M1);
           case UnaryExpr.OPERATION_LOGIC_NOT:
               Label falseLabel = new Label();
               Label stopLabel = new Label();
               md.visitJumpInsn(IFEQ, falseLabel);
               constFalse();
               md.visitJumpInsn(GOTO, stopLabel);
               md.visitLabel(falseLabel);
               constTrue();
               md.visitLabel(stopLabel);
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
        md.visitTypeInsn(CHECKCAST, internalName(node.getToType()));
        return null;
    }

    @Override
    public Object visitNewArrayExpr(NewArrayExpr node) {
        visit(node.getSize());
        Type t = node.getComponentType();
        int opr = -1;
        int op = NEWARRAY;
        if(t.equals(BOOLEAN_TYPE)){
            opr = T_BOOLEAN;
        }else if(t.equals(CHAR_TYPE)){
            opr = T_CHAR;
        }else if(t.equals(SHORT_TYPE)){
            opr = T_SHORT;
        }else if(t.equals(INT_TYPE)){
            opr = T_INT;
        }else if(t.equals(LONG_TYPE)){
            opr = T_LONG;
        }else if(t.equals(FLOAT_TYPE)){
            opr = T_FLOAT;
        }else if(t.equals(DOUBLE_TYPE)){
            opr = T_DOUBLE;
        }else if(t.equals(BYTE_TYPE)){
            opr = T_BYTE;
        }else{
            op = ANEWARRAY;
        }
        if(op==NEWARRAY){
            md.visitIntInsn(op, opr);
        }else{
            md.visitTypeInsn(ANEWARRAY, internalName(t));
        }
        return null;
    }

    @Override
    public Object visitThisExpr(ThisExpr node) {
        md.visitVarInsn(ALOAD, 0);
        return null;
    }

    @Override
    public Object visitMultiStmtExpr(MultiStmtExpr node) {
        visitAll(node.stmts);
        visit(node.reference);
        return null;
    }
    
    private String getTypeDescriptor(Type[] types){
        if(types==null) return null;
        if(types.length==0) return null;
        String ts = "";
        for(Type t:types){
            ts += getTypeDescriptor(t);
        }
        return ts;
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
            return getTypeDescriptor(((GenericType) t).getSuperType());
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
        String desc = "";
        String retTyp = getTypeDescriptor(returnType);
        if(parameterTypes!=null){
            for(Type t:parameterTypes){
                desc += getTypeDescriptor(t);
            }
        }
        return "(" + desc + ")" + retTyp;     
    }
        
    private String getMethodDescriptor(MethodNode node) {
        return getMethodDescriptor(node.type , MethodUtil.getParameterTypes(node));
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
        org.objectweb.asm.Type type = asmType(vo.type);
        int vid = getVarId(vo);
        md.visitVarInsn(type.getOpcode(ILOAD),vid);
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
    public void generate(ClassNode classNode){
        visitClassNode(classNode);
    }

    @Override
    public Object visitVarDeclStmt(VarDeclStmt node) {
        return visitChildren(node);
    }
    
    private int getPrimitiveCastOpc(Type fromType,Type toType){
        
        Type f = fromType;
        Type tt = toType;
        if(f.equals(INT_TYPE)){
            if(tt.equals(LONG_TYPE)) return I2L;
            if(tt.equals(FLOAT_TYPE)) return I2F;
            if(tt.equals(DOUBLE_TYPE)) return I2D;
            if(tt.equals(SHORT_TYPE)) return I2S;
            if(tt.equals(BYTE_TYPE)) return I2B;
            if(tt.equals(CHAR_TYPE)) return I2C;
        }else if(f.equals(FLOAT_TYPE)){
            if(tt.equals(INT_TYPE)) return F2I;
            if(tt.equals(LONG_TYPE)) return F2L;
            if(tt.equals(DOUBLE_TYPE)) return F2D;
        }else if(f.equals(LONG_TYPE)){
            if(tt.equals(INT_TYPE)) return L2I;
            if(tt.equals(FLOAT_TYPE)) return L2F;
            if(tt.equals(DOUBLE_TYPE)) return L2D;
        }else if(f.equals(DOUBLE_TYPE)){
            if(tt.equals(INT_TYPE)) return D2I;
            if(tt.equals(LONG_TYPE)) return D2L;
            if(tt.equals(FLOAT_TYPE)) return D2F;
        }else if(f.equals(BYTE_TYPE)){
            if(tt.equals(SHORT_TYPE)) return 0;
            if(tt.equals(INT_TYPE)) return 0;
            if(tt.equals(LONG_TYPE)) return I2L;
            if(tt.equals(FLOAT_TYPE)) return I2F;
            if(tt.equals(DOUBLE_TYPE)) return I2D;
        }
        throw new UnsupportedOperationException("It is unable to cast " + fromType + " to " + toType);
    }

    @Override
    public Object visitPrimitiveCastExpr(PrimitiveCastExpr node) {
        ExprNode expr = node.getExpr();
        visit(expr);
        int opc;
        Type ft = expr.getType();
        Type tt = node.getToType();
        opc = getPrimitiveCastOpc(ft, tt);
        if(opc>0){
            md.visitInsn(opc);
        }
        return null;
    }

    @Override
    public Object visitLocalVarNode(LocalVarNode localVarNode) {
        this.declareNewVar(localVarNode);
        return null;
    }

    @Override
    public Object visitParameterNode(ParameterNode parameterNode) {
        md.visitParameter(parameterNode.name, parameterNode.modifier);
        this.declareNewVar(parameterNode);
        return null;
    }

    @Override
    public Object visitFieldNode(FieldNode fieldNode) {
        classWriter.visitField(fieldNode.modifier, fieldNode.name, getTypeDescriptor(fieldNode.type), null, null);
        return null;
    }

    @Override
    public Object visitNewObjectExpr(NewObjectExpr node) {
        org.objectweb.asm.Type t = asmType(node.getObjectType());
        md.visitTypeInsn(NEW, t.getInternalName());
        md.visitInsn(DUP);
        visitAll(node.getConstructor().getArguments());
        md.visitMethodInsn(
                INVOKESPECIAL
                , t.getInternalName()
                , "<init>"
                ,getMethodDescriptor(node.getConstructor().getMethod().getMethodNode())
                , false);
        return null;
    }

    private void dupX(Type type){
        int size = asmType(type).getSize();
        if(size==1) md.visitInsn(DUP);
        else if(size==2) md.visitInsn(DUP2);
        else throw new UnsupportedOperationException("unsupported type:" + type);
    }
    
    @Override
    public Object visitIncrementExpr(IncrementExpr node) {
        if(!node.isIsPrefix()){
            visit(node.getExpr());
        }
        Type exprType = node.getExpr().getType();
        ConstExpr ce = getConstX(exprType, node.isIsDesc() ? -1 : 1);
        BinaryExpr be = new MathExpr(node.getExpr(),ce, "+");
        AssignExpr addOne = new AssignExpr(node.getExpr(),be);
        visit(addOne);
        pop(exprType);
        if(node.isIsPrefix()){
            visit(node.getExpr());
        }        
        return null;
    }
    
    private ConstExpr getConstX(Type type, int i) {
        Object obj;
        int t = getT(type);
        switch (t) {
            case T_I:
                obj = new Integer(i);
                break;
            case T_L:
                obj = new Long(i);
                break;
            case T_F:
                obj = new Float(i);
                break;
            case T_D:
                obj = new Double(i);
                break;
            default:
                throw new UnsupportedOperationException("unsupported type:" + type);
        }
        return new ConstExpr(obj);
    }
    private void constX(Object x){
        md.visitLdcInsn(x);
    }

    private void constX(Type type,int i) {
        constX(getConstX(type, i).getValue());
    }

    @Override
    public Object visit(AstNode node) {
        int lineNum = node.offset.startLine;
        if(lineNum>0 && (node instanceof Statement || node instanceof ExprNode) &&  !lineLabels.containsKey(lineNum)){
            Label lb = new Label();
            md.visitLabel(lb);
            md.visitLineNumber(lineNum, lb);
            lineLabels.put(lineNum, lb);
        }
        return super.visit(node);
    }

    @Override
    public Object visitArrayLengthExpr(ArrayLengthExpr node) {
        visit(node.getArrayExpr());
        md.visitInsn(ARRAYLENGTH);
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
        md.visitVarInsn(ALOAD, 0);
        return null;
    }

    @Override
    public Object visitErrorousExpr(ErrorousExpr node) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitInstanceOfExpr(InstanceOfExpr node) {
        visit(node.getExpr());
        md.visitTypeInsn(INSTANCEOF, internalName(node.getTarget().getReferencedClassNode()));
        return null;
    }

    private void ifCompare(boolean jumpOnTrue,ExprNode expr1, ExprNode expr2, String op, Label label) {
        Type type = expr1.getType();
        visit(expr1);
        visit(expr2);
        int t = getT(type);
        if(T_I == t){
            int opc = -1;
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
                    opc = jumpOnTrue ? IF_ICMPNE : IF_ACMPEQ;
                    break;
                default:
                    throw  new UnsupportedOperationException("Unsupported operation:" + op);
            }
            md.visitJumpInsn(opc, label);
        }else if(T_A==t){//object type
             if(op.equals("==")){
                md.visitJumpInsn(jumpOnTrue ? IF_ACMPEQ : IF_ACMPNE,label);
            }else if(op.equals("!=")){
                md.visitJumpInsn(jumpOnTrue ? IF_ACMPNE:IF_ACMPEQ,label);
            }else{
                throw new UnsupportedOperationException("It is unsupported to compare object type:" + type);
            }
        }else{//type is not int,not object            
            if(T_L==t){
                md.visitInsn(LCMP);
            }else if(T_F==t){
                md.visitInsn(FCMPL);
            }else if(T_D==t){
                md.visitInsn(DCMPL);
            }else{
               throw new UnsupportedOperationException("It is unsupported to compare object type:" + type);
            }
            int opc = -1;
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
            md.visitJumpInsn(opc, label);
        }
    }

    @Override
    public Object visitMultiStmt(MultiStmt node) {
        visitAll(node.statements);
        return null;
    }

    @Override
    public Object visitStoreArrayElementExpr(StoreArrayElementExpr node) {
        md.visitVarInsn(ALOAD, this.getVarId(node.getArray()));
        visit(node.getIndex());
        astore(node.getValueExpr());
        return null;
    }

}
