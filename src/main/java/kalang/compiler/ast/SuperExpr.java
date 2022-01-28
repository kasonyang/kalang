
package kalang.compiler.ast;
import kalang.compiler.core.Type;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author Kason Yang 
 */
public class SuperExpr extends ExprNode{
    
    private ClassNode classNode;

    public SuperExpr(ClassNode callerClassNode) {
        this.classNode = callerClassNode;
    }

    @Override
    public Type getType() {
        if(classNode.getSuperType()==null){
            return null;
        }
        return classNode.getSuperType();
    }

    public ClassNode getClassNode() {
        return classNode;
    }

    @Override
    public String toString() {
        return "super";
    }

    @Override
    public List<AstNode> getChildren() {
        return Collections.emptyList();
    }

    @Override
    public void updateChildren(ChildUpdater childUpdater) {

    }
}
