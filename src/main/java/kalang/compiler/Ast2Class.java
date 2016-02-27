
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
        assignVarObject(vo, vo.initExpr);
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
        if(!(node.expr instanceof AssignExpr)){
            if(node.expr.getType() !=null &&
                    !Types.VOID_TYPE.equals(node.expr.getType())
                    ){
                pop(node.expr.getType());
            }
        }
        return null;
    }

    @Override
    public Object visitIfStmt(IfStmt node) {
        Label stopLabel = new Label();
        Label falseLabel = new Label();
        visit(node.conditionExpr);
        md.visitJumpInsn(IFEQ, falseLabel);
        if(node.trueBody!=null){
            visit(node.trueBody);
        }
        md.visitJumpInsn(GOTO, stopLabel);
        md.visitLabel(falseLabel);
        if(node.falseBody!=null){
            visit(node.falseBody);
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
            if(toField.target instanceof ClassExpr){
                opc = PUTSTATIC;
            }else{
                visit(toField.target);
            }
            visit(from);
            md.visitFieldInsn(
                    opc, 
                    asmType(toField.target.getType()).getInternalName()
                    , toField.fieldName
                    , getTypeDescriptor(toField.target.getType())
            );
        }else if(to instanceof VarExpr){
            assignVarObject(((VarExpr) to).var, from);
        }else if(to instanceof ElementExpr){
            ElementExpr elementExpr = (ElementExpr) to;
            visit(elementExpr.arrayExpr);
            visit(elementExpr.index);
            visit(from);
            md.visitInsn(type.getOpcode(IASTORE));
        }else{
            throw new UnknownError("unknown expression:" + to);
        }
    }

    @Override
    public Object visitAssignExpr(AssignExpr node) {
        assign(node.to, node.from);
        return null;
    }

    @Override
    public Object visitBinaryExpr(BinaryExpr node) {
        int op = 0;
        org.objectweb.asm.Type at = asmType(node.expr1.getType());
        switch(node.operation){
            case "+": op = IADD;break;
            case "-" : op = ISUB;break;
            case "*" : op = IMUL;break;
            case "/" : op = IDIV;break;
            case "%":op = IREM;break;
            default:
                compare(node.expr1,node.expr2,node.operation);
                return null;
        }
        visit(node.expr1);
        visit(node.expr2);
        md.visitInsn(at.getOpcode(op));
        return null;
    }

    @Override
    public Object visitConstExpr(ConstExpr node) {
        md.visitLdcInsn(node.value);
        return null;
    }

    @Override
    public Object visitElementExpr(ElementExpr node) {
        visit(node.arrayExpr);
        visit(node.index);
        org.objectweb.asm.Type t = asmType(node.getType());
        md.visitInsn(t.getOpcode(IALOAD));
        return null;
    }

    @Override
    public Object visitFieldExpr(FieldExpr node) {
        visit(node.target);
        if(node.target.getType().isArray()){
            if(node.fieldName.equals("length")){
                md.visitInsn(ARRAYLENGTH);
            }else{
                throw new UnsupportedOperationException("unknown field:" + node.fieldName);
            }
            return null;
        }
        int opc = GETFIELD;
        if(node.target instanceof ClassExpr){
            opc = GETSTATIC;
        }
        md.visitFieldInsn(
                opc
                ,asmType(node.target.getType()).getInternalName()
                ,node.fieldName
                , getTypeDescriptor(node.getType()));
        return null;
    }

    @Override
    public Object visitInvocationExpr(InvocationExpr node) {
        int opc = INVOKEVIRTUAL;
        if(node.target instanceof ClassExpr){
            opc = INVOKESTATIC;
        }else{
            visit(node.target);
        }
        if(AstUtil.isSpecialMethod(node.methodName)){
            opc = INVOKESPECIAL;
        }
        visitAll(node.arguments);
        md.visitMethodInsn(
                opc
                , internalName(node.target.getType())
                , node.methodName
                ,getMethodDescriptor(node.getType(), node.methodName
                        ,AstUtil.getExprTypes(node.arguments.toArray(new ExprNode[0])))
//                , getTypeDescriptor(
//                        AstUtil.getExprTypes(node.arguments.toArray(new ExprNode[0])) )
                , false);
        return null;
    }

    @Override
    public Object visitUnaryExpr(UnaryExpr node) {
        org.objectweb.asm.Type t = asmType(node.expr.getType());
        switch(node.operation){
            case UnaryExpr.OPERATION_POS:
                break;
            case UnaryExpr.OPERATION_NEG:
                visit(node.expr);
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
        visitVarObject(node.var);
        return null;
    }

    @Override
    public Object visitClassExpr(ClassExpr node) {
        return null;
    }

    @Override
    public Object visitParameterExpr(ParameterExpr node) {
        visitVarObject(node.parameter);
        return null;
    }

    @Override
    public Object visitCastExpr(CastExpr node) {
        visit(node.expr);
        md.visitTypeInsn(CHECKCAST, internalName(node.toType));
        return null;
    }

    @Override
    public Object visitNewArrayExpr(NewArrayExpr node) {
        visit(node.size);
        //org.objectweb.asm.Type t = asmType(node.componentType);
        Type t = node.componentType;
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
        for(Type t:parameterTypes){
            desc += getTypeDescriptor(t);
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
        visit(node.expr);
        int opc;
        Type ft = node.expr.getType();
        Type tt = node.toType;
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
        org.objectweb.asm.Type t = asmType(node.objectType);
        md.visitTypeInsn(NEW, t.getInternalName());
        //TODO init object
//        md.visitInsn(DUP);
//        md.visitMethodInsn(
//                INVOKESPECIAL
//                , t.getInternalName()
//                , "<init>"
//                ,getTypeDescriptor(
//                        AstUtil.getExprTypes(node.arguments))
//                , false);
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
        if(!node.isPrefix){
            visit(node.expr);
        }
        Type exprType = node.expr.getType();
        //TODO 1 maybe wrong if type is long
        //TODO -1 increment
        ConstExpr ce = new ConstExpr(1, exprType);
        //ce.setType(exprType);
        BinaryExpr be = new BinaryExpr(node.expr,ce, "+");
        //be.setType(exprType);
        AssignExpr addOne = new AssignExpr(node.expr,be);
        visit(addOne);
        if(node.isPrefix){
            visit(node.expr);
        }        
//        Type type = node.expr.type;
//        org.objectweb.asm.Type t = asmType(node.expr.type);
//        if(!node.isPrefix){
//            dupX(type);
//        }
//        const1(type);
//        md.visitInsn(t.getOpcode(IADD));
//        if(node.isPrefix){
//            dupX(type);
//        }
//        md.visitVarInsn(t.getOpcode(ISTORE),vi);
        return null;
    }
    
    private void constX(Object x){
        md.visitLdcInsn(x);
    }

    private void constX(Type type,int i) {
        int t = getT(type);
        Object obj;
        switch(t){
            case T_I:obj = new Integer(i);break;
            case T_L:obj = new Long(i);break;
            case T_F:obj = new Float(i);break;
            case T_D:obj = new Double(i);break;
            default:throw new UnsupportedOperationException("unsupported type:" + type);
        }
        constX(obj);
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
        visit(node.arrayExpr);
        md.visitInsn(ARRAYLENGTH);
        return null;
    }

}
