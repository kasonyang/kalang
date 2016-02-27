
package kalang.compiler;
import kalang.ast.AbstractAstVisitor;
import kalang.ast.AssignExpr;
import kalang.ast.AstVisitor;
import kalang.ast.BinaryExpr;
import kalang.ast.BlockStmt;
import kalang.ast.BreakStmt;
import kalang.ast.CastExpr;
import kalang.ast.CatchStmt;
import kalang.ast.ClassExpr;
import kalang.ast.ClassNode;
import kalang.ast.ConstExpr;
import kalang.ast.ContinueStmt;
import kalang.ast.ElementExpr;
import kalang.ast.ExprStmt;
import kalang.ast.FieldExpr;
import kalang.ast.IfStmt;
import kalang.ast.InvocationExpr;
import kalang.ast.KeyExpr;
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
import java.nio.*;
import java.net.*;
import java.util.*;
import javax.annotation.Nonnull;
import kalang.ast.ArrayLengthExpr;
import kalang.ast.AssignableExpr;
import kalang.ast.ExprNode;
import kalang.ast.FieldNode;
import kalang.ast.IncrementExpr;
import kalang.ast.LocalVarNode;
import kalang.ast.NewObjectExpr;
import kalang.ast.ParameterNode;
import kalang.ast.PrimitiveCastExpr;
import kalang.ast.VarDeclStmt;
import kalang.core.ArrayType;
import kalang.core.PrimitiveType;
import kalang.core.Type;
import kalang.core.Types;
import static kalang.core.Types.*;
import kalang.util.AstUtil;
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
public class Ast2Class extends AbstractAstVisitor<Object>{

    private ClassWriter classWriter;
    private MethodVisitor md;
    
    private Map<VarObject,Integer> varIds = new HashMap<>();
    
    private int varIdCounter = 0;
    
    private Stack<Label> breakLabels = new Stack<>();
    private Stack<Label> continueLabels = new Stack<>();
    
    private final static int 
            T_I = 0,
            T_L = 1,
            T_F = 2,
            T_D = 3,
            T_A = 4;
    
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
    
    private void newVar(VarObject vo){
        int vid = varIdCounter;
        int vSize = asmType(vo.type).getSize();
        varIdCounter+= vSize;
        varIds.put(vo, vid);
        if(vo.initExpr!=null){
            assignVarObject(vo, vo.initExpr);
        }
    }

    private String internalName(String name){
        return name.replace(".", "/");
    }
    
    private String[] internalNames(String[] names){
        String[] inames = new String[names.length];
        for(int i=0;i<names.length;i++){
            inames[i] = internalName(names[i]);
        }
        return inames;
    }
    
    @Override
    public Object visitClassNode(ClassNode node) {        
        classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        int access = node.modifier;
        String sign = null;
        String parentName = "java.lang.Object";
        if(node.parent!=null){
            parentName = node.parent.name;
        }
        String[] interfaces = null;
        if(node.interfaces!=null){
            interfaces = internalName(node.interfaces.toArray(new ClassNode[0]));
        }
        classWriter.visit(V1_5, access,internalName(node.name), sign, internalName(parentName),interfaces);
        visitChildren(node);
        classWriter.visitEnd();
        return null;
    }

    @Override
    public Object visitMethodNode(MethodNode node) {
        int access = node.modifier;
        md = classWriter.visitMethod(access, internalName(node.name),getMethodDescriptor(node), null,internalName(node.exceptionTypes.toArray(new Type[0])) );
        if(AstUtil.isStatic(node.modifier)){
            varIdCounter = 0;
        }else{
            varIdCounter = 1;
        }
        visitChildren(node);
        if(node.type.equals(VOID_TYPE)){
            md.visitInsn(RETURN);
        }
        try{
            md.visitMaxs(0, 0);
        }catch(Exception ex){
            System.err.println("exception when visit method:" + node.name);
            //throw ex;
        }
        md.visitEnd();
        return null;
    }

    @Override
    public Object visitBlockStmt(BlockStmt node) {
        visitChildren(node);
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
        if(!(node.getExpr() instanceof AssignExpr)){
            if(node.getExpr().getType() !=null &&
                    !Types.VOID_TYPE.equals(node.getExpr().getType())
                    ){
                pop(node.getExpr().getType());
            }
        }
        return null;
    }

    @Override
    public Object visitIfStmt(IfStmt node) {
        Label stopLabel = new Label();
        Label falseLabel = new Label();
        visit(node.getConditionExpr());
        md.visitJumpInsn(IFEQ, falseLabel);
        if(node.getTrueBody()!=null){
            visit(node.getTrueBody());
        }
        md.visitJumpInsn(GOTO, stopLabel);
        md.visitLabel(falseLabel);
        if(node.getFalseBody()!=null){
            visit(node.getFalseBody());
        }
        md.visitLabel(stopLabel);
        return null;
    }

    @Override
    public Object visitLoopStmt(LoopStmt node) {
        visitAll(node.initStmts);
        Label startLabel = new Label();
        Label stopLabel = new Label();
        continueLabels.push(startLabel);
        breakLabels.push(stopLabel);
        md.visitLabel(startLabel);
        if(node.preConditionExpr!=null){
            visit(node.preConditionExpr);
            md.visitJumpInsn(IFEQ, stopLabel);
        }
        visit(node.loopBody);
        if(node.postConditionExpr!=null){
            visit(node.postConditionExpr);
            md.visitJumpInsn(IFEQ, stopLabel);
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
        return null;
        //TODO to impl try stmt
    }

    @Override
    public Object visitCatchStmt(CatchStmt node) {
        //TODO to impl catch
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
    
    private void assign(ExprNode to,ExprNode from){
        org.objectweb.asm.Type type = asmType(from.getType());
        if(to instanceof FieldExpr){
            FieldExpr toField = (FieldExpr) to;
            int opc = PUTFIELD;
            if(toField.getTarget() instanceof ClassExpr){
                opc = PUTSTATIC;
            }else{
                visit(toField.getTarget());
            }
            visit(from);
            md.visitFieldInsn(opc, 
                    asmType(toField.getTarget().getType()).getInternalName()
                    , toField.getFieldName()
            , getTypeDescriptor(toField.getTarget().getType()));
        }else if(to instanceof VarExpr){
            assignVarObject(((VarExpr) to).getVar(), from);
        }else if(to instanceof ElementExpr){
            ElementExpr elementExpr = (ElementExpr) to;
            visit(elementExpr.getArrayExpr());
            visit(elementExpr.getIndex());
            visit(from);
            md.visitInsn(type.getOpcode(IASTORE));
        }else{
            throw new UnknownError("unknown expression:" + to);
        }
    }

    @Override
    public Object visitAssignExpr(AssignExpr node) {
        assign(node.getTo(), node.getFrom());
        return null;
    }

    @Override
    public Object visitBinaryExpr(BinaryExpr node) {
        int op = 0;
        org.objectweb.asm.Type at = asmType(node.getExpr1().getType());
        switch(node.getOperation()){
            case "+": op = IADD;break;
            case "-" : op = ISUB;break;
            case "*" : op = IMUL;break;
            case "/" : op = IDIV;break;
            case "%":op = IREM;break;
            case "&&":
            case "||":
                doLogicOperation(node.getExpr1(), node.getExpr2(), node.getOperation());
                break;
            default:
                compare(node.getExpr1(), node.getExpr2(), node.getOperation());
                return null;
        }
        visit(node.getExpr1());
        visit(node.getExpr2());
        md.visitInsn(at.getOpcode(op));
        return null;
    }

    @Override
    public Object visitConstExpr(ConstExpr node) {
        md.visitLdcInsn(node.getValue());
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
        visit(node.getTarget());
        if(node.getTarget().getType().isArray()){
            if(node.getFieldName().equals("length")){
                md.visitInsn(ARRAYLENGTH);
            }else{
                throw new UnsupportedOperationException("unknown field:" + node.getFieldName());
            }
            return null;
        }
        int opc = GETFIELD;
        if(node.getTarget() instanceof ClassExpr){
            opc = GETSTATIC;
        }
        md.visitFieldInsn(opc
                ,asmType(node.getTarget().getType()).getInternalName()
                , node.getFieldName(), getTypeDescriptor(node.getType()));
        return null;
    }

    @Override
    public Object visitInvocationExpr(InvocationExpr node) {
        int opc = INVOKEVIRTUAL;
        if(node.getTarget() instanceof ClassExpr){
            opc = INVOKESTATIC;
        }else{
            visit(node.getTarget());
        }
        if(AstUtil.isSpecialMethod(node.getMethodName())){
            opc = INVOKESPECIAL;
        }
        visitAll(node.getArguments());
        md.visitMethodInsn(opc
                , internalName(node.getTarget().getType())
                ,node.getMethodName()
//                , getTypeDescriptor(
//                        AstUtil.getExprTypes(node.arguments.toArray(new ExprNode[0])) )
                , getMethodDescriptor(node.getType(), node.getMethodName(), AstUtil.getExprTypes(node.getArguments())), false);
        return null;
    }

    @Override
    public Object visitUnaryExpr(UnaryExpr node) {
        org.objectweb.asm.Type t = asmType(node.getExpr().getType());
        switch(node.getOperation()){
            case UnaryExpr.OPERATION_POS:
                break;
            case UnaryExpr.OPERATION_NEG:
                visit(node.getExpr());
                md.visitInsn(t.getOpcode(INEG));
                break;
            //case UnaryExpr.OPERATION_INC:
                //md.visitIincInsn(getVarId(var), 0);
        }
        //TODO impl unary expr
        return null;
    }

    @Override
    public Object visitVarExpr(VarExpr node) {
        visitVarObject(node.getVar());
        return null;
    }

    @Override
    public Object visitClassExpr(ClassExpr node) {
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
        //org.objectweb.asm.Type t = asmType(node.componentType);
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
    public Object visitKeyExpr(KeyExpr node) {
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
        //TODO check why null
        if(t==null || t.equals(VOID_TYPE)){
            return "V";
        }
        if(t instanceof ArrayType){
            return "[" + getTypeDescriptor(((ArrayType)t).getComponentType());
        }
        if(t.equals(BOOLEAN_TYPE)){
            return "Z";
        }else if(t.equals(LONG_TYPE)){
            return "J";
        }
        if(t instanceof PrimitiveType){
            return t.getName().substring(0,1).toUpperCase();
        }
        return "L" + internalName(t.getName()) + ";";
            //default:throw new IllegalArgumentException("unknown type:" + t.getName());
    }
    private String getSingleTypeDescriptor(String type){
        switch(type){
            case "int":return "I";
            case "long":return "L";
            case "float":return "F";
            case "double":return "D";
            case "boolean":return "Z";
            default:return "L" + internalName(type) + ";";
        }
    }
    
    private String getMethodDescriptor(Type returnType,String methodName,Type[] parameterTypes){
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
        return getMethodDescriptor(node.type, node.name, AstUtil.getParameterTypes(node));
    }
    
    private org.objectweb.asm.Type asmType(Type type){
        return org.objectweb.asm.Type.getType(getTypeDescriptor(type));
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
        return asmType(t).getInternalName();
    }
    
    private String[] internalName(Type[] types){
        String[] ts = new String[types.length];
        for(int i=0;i<types.length;i++){
            ts[i] = internalName(types[i]);
        }
        return ts;
    }
    
    public void generate(ClassNode classNode){
        visitClassNode(classNode);
    }
    
    public byte [] getClassBytes(){
        return classWriter.toByteArray();
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
        }
        throw new UnsupportedOperationException("It is unable to cast " + fromType + " to " + toType);
    }

    @Override
    public Object visitPrimitiveCastExpr(PrimitiveCastExpr node) {
        visit(node.getExpr());
        int opc;
        Type ft = node.getExpr().getType();
        Type tt = node.getToType();
        opc = getPrimitiveCastOpc(ft, tt);
        md.visitInsn(opc);
        return null;
    }

    @Override
    public Object visitLocalVarNode(LocalVarNode localVarNode) {
        //md.visitLocalVariable(localVarNode.name, getTypeDescriptor(localVarNode.componentType), null, start, end, 0);
        newVar(localVarNode);
        return null;
    }

    @Override
    public Object visitParameterNode(ParameterNode parameterNode) {
        //TODO mdf -> access,init parameter
        md.visitParameter(parameterNode.name, parameterNode.modifier);
        newVar(parameterNode);
        return null;
    }

    @Override
    public Object visitFieldNode(FieldNode fieldNode) {
        classWriter.visitField(0, fieldNode.name, getTypeDescriptor(fieldNode.type), null, null);
        //TODO init field
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
                ,getMethodDescriptor(node.getConstructor().getType(), node.getConstructor().getMethodName(), node.getConstructor().getArgumentTypes())
                //,getTypeDescriptor(
                //        AstUtil.getExprTypes(node.constructor.arguments))
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
        BinaryExpr be = new BinaryExpr(node.getExpr(),ce, "+");
        AssignExpr addOne = new AssignExpr(node.getExpr(),be);
        visit(addOne);
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
        return new ConstExpr(obj, type);
    }
    private void constX(Object x){
        md.visitLdcInsn(x);
    }

    private void constX(Type type,int i) {
        constX(getConstX(type, i).getValue());
    }

    private void compare(ExprNode expr1, ExprNode expr2,String op) {
        Type type = expr1.getType();
        //org.objectweb.asm.Type t = asmType(expr1.type);
        visit(expr1);
        visit(expr2);
        int t = getT(type);
        if(T_L==t){
            md.visitInsn(LCMP);
        }else if(T_F==t){
            md.visitInsn(FCMPL);
        }else if(T_D==t){
            md.visitInsn(DCMPL);
        }else if(T_I == t){
            //do nothing
        }else{
            throw new UnsupportedOperationException("It is unsupported to compare object type:" + type);
        }
        Label trueLabel = new Label();
        Label stopLabel = new Label();
        int opc = -1;
        switch(op){
            case "==" : opc =IF_ICMPEQ;break;
            case ">"    : opc = IF_ICMPGT;break;
            case ">=" : opc = IF_ICMPGE;break;
            case "<"   : opc = IF_ICMPLT;break;
            case "<=" : opc = IF_ICMPLE;break;
            case "!=" : opc = IF_ICMPNE;break;
            default:
                throw  new UnsupportedOperationException("Unsupported operation:" + op);
        }
        md.visitJumpInsn(opc, trueLabel);
        constX(type, 0);
        md.visitJumpInsn(GOTO, stopLabel);
        md.visitLabel(trueLabel);
        constX(type, 1);
        md.visitLabel(stopLabel);
    }

    @Override
    public Object visitArrayLengthExpr(ArrayLengthExpr node) {
        //TODO support needed
        //throw new UnsupportedOperationException("Not supported yet.");
        visit(node.getArrayExpr());
        md.visitInsn(ARRAYLENGTH);
        return null;
    }
    
    private void constTrue(){
        constX(new Integer(1));
    }
    
    private void constFalse(){
        constX(new Integer(0));
    }

    private void doLogicOperation(ExprNode expr1, ExprNode expr2, String op) {
        Label stopLabel = new Label();
        if(op.equals("&&")){
            Label falseLabel = new Label();
            visit(expr1);
            md.visitJumpInsn(IFEQ, falseLabel);
            visit(expr2);
            md.visitJumpInsn(IFEQ, falseLabel);
            constTrue();
            md.visitJumpInsn(GOTO, stopLabel);
            md.visitLabel(falseLabel);
            constFalse();
        }else if(op.equals("||")){
            Label trueLable = new Label();
            visit(expr1);
            md.visitJumpInsn(IFNE,trueLable);
            visit(expr2);
            md.visitJumpInsn(IFNE, trueLable);
            constFalse();
            md.visitJumpInsn(GOTO, stopLabel);
            md.visitLabel(trueLable);
            constTrue();
        }else{
            throw new UnsupportedOperationException(op);
        }
        md.visitLabel(stopLabel);
    }

}
