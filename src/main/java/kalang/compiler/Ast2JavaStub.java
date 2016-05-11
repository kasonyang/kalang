package kalang.compiler;

import java.lang.reflect.Modifier;
import kalang.ast.AbstractAstVisitor;
import kalang.ast.AstVisitor;
import kalang.ast.ClassNode;
import kalang.ast.FieldNode;
import kalang.ast.MethodNode;
import kalang.ast.ParameterNode;
import kalang.util.AstUtil;

/**
 *
 * @author Kason Yang <im@kasonyang.com>
 */
public class Ast2JavaStub extends AstVisitor<Void> implements CodeGenerator{
    
    protected StringBuilder sb;

    @Override
    public Void visitFieldNode(FieldNode fieldNode) {
        sb.append(Modifier.toString(fieldNode.modifier))
                .append(" ")
                .append(fieldNode.type)
                .append(" ")
                .append(fieldNode.name)
                .append(";\n");
        return super.visitFieldNode(fieldNode);
    }

    @Override
    public Void visitMethodNode(MethodNode node) {
        sb.append(Modifier.toString(node.modifier))
                .append(" native ")
                .append(node.type)
                .append(" ")
                .append(node.name)
                .append("(");
         super.visitMethodNode(node);
         sb.append(");\n");
         return null;
    }

    @Override
    public Void visitParameterNode(ParameterNode parameterNode) {
        char last = sb.charAt(sb.length()-1);
        if(last!='('){
            sb.append(",");
        }
        sb.append(parameterNode.type)
                .append(" ")
                .append(parameterNode.name);
        return super.visitParameterNode(parameterNode);
    }
    
    

    @Override
    public Void visitClassNode(ClassNode node) {
        String clsName = node.name;
        String pkgName = AstUtil.getPackageName(clsName);
        if(pkgName!=null){
            sb.append("package ").append(pkgName).append(";\n");
        }
        sb.append(Modifier.toString(node.modifier))
                .append(" class ")
                .append(AstUtil.getClassNameWithoutPackage(clsName))
                .append("{\n");
        super.visitClassNode(node);
        sb.append("\n}");
        return null;
    }
    
    public String getJavaStubCode(){
        return sb.toString();
    }

    @Override
    public void generate(ClassNode classNode) {
        sb = new StringBuilder();
        visit(classNode);
    }
    
}
