
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
import kalang.ast.NewExpr;
import kalang.ast.ParameterExpr;
import kalang.ast.ReturnStmt;
import kalang.ast.ThrowStmt;
import kalang.ast.TryStmt;
import kalang.ast.UnaryExpr;
import kalang.ast.VarDeclStmt;
import kalang.ast.VarExpr;
import kalang.ast.VarObject;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import static org.objectweb.asm.Opcodes.*;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class Ast2Class extends AstVisitor<Object>{

    private ClassWriter classWriter;
    private MethodVisitor md;

    private String interClassName(String name){
        return name.replace(".", "/");
    }
    
    private String[] interClassName(String[] names){
        String[] inames = new String[names.length];
        for(int i=0;i<names.length;i++){
            inames[i] = interClassName(names[i]);
        }
        return inames;
    }
    
    @Override
    public Object visitClassNode(ClassNode node) {        
        classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        //TODO modifier -> access
        int access = node.modifier;
        String sign = null;
        classWriter.visit(V1_5, access,interClassName(node.name), sign, node.parent.name,interClassName(node.interfaces.toArray(new String[0])));
        return super.visit(node);
    }

    @Override
    public Object visitMethodNode(MethodNode node) {
        //TODO mdf => access
        int access = node.modifier;
        md = classWriter.visitMethod(access, interClassName(node.name),getMethodDescriptor(node), null,interClassName(node.exceptionTypes.toArray(new String[0])));
        return super.visit(node);
    }

    @Override
    public Object visitBlockStmt(BlockStmt node) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitBreakStmt(BreakStmt node) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitContinueStmt(ContinueStmt node) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitExprStmt(ExprStmt node) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitIfStmt(IfStmt node) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitLoopStmt(LoopStmt node) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitReturnStmt(ReturnStmt node) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitVarDeclStmt(VarDeclStmt node) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitTryStmt(TryStmt node) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitCatchStmt(CatchStmt node) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitThrowStmt(ThrowStmt node) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitAssignExpr(AssignExpr node) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitBinaryExpr(BinaryExpr node) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitConstExpr(ConstExpr node) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitElementExpr(ElementExpr node) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitFieldExpr(FieldExpr node) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitInvocationExpr(InvocationExpr node) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitUnaryExpr(UnaryExpr node) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitVarExpr(VarExpr node) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitClassExpr(ClassExpr node) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitNewExpr(NewExpr node) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitParameterExpr(ParameterExpr node) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitCastExpr(CastExpr node) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitNewArrayExpr(NewArrayExpr node) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitKeyExpr(KeyExpr node) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitMultiStmtExpr(MultiStmtExpr node) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private String getTypeDescriptor(String type){
        String prefix = "";
        if(type.endsWith("[]")){
            prefix = "[";
            type = type.substring(0,type.length()-2);
        }
        return prefix + getSingleTypeDescriptor(type);
    }
    private String getSingleTypeDescriptor(String type){
        switch(type){
            case "int":return "I";
            case "long":return "L";
            case "float":return "F";
            case "double":return "D";
            case "boolean":return "Z";
            default:return "L" + interClassName(type) + ";";
        }
    }
    
    private String getMethodDescriptor(MethodNode node) {
//        String desc = "";
//        String retTyp = getTypeDescriptor(node.type);
//        for(VarObject p:node.parameters){
//            desc += getTypeDescriptor(p.type);
//        }
//        return "(" + desc + ")" + retTyp;
        return null;
    }

}
