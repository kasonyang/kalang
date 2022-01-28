
package kalang.compiler.ast;

import java.util.Objects;

/**
 *
 * @author Kason Yang 
 */
public class ClassReference extends AstNode{
    
    private ClassNode referencedClassNode;

    public ClassReference(ClassNode referencedClassNode) {
        this.referencedClassNode = referencedClassNode;
    }

    public ClassNode getReferencedClassNode() {
        return referencedClassNode;
    }

    @Override
    public String toString() {
        return Objects.toString(referencedClassNode);
    }

    @Override
    public void updateChildren(ChildUpdater childMapper) {

    }
}
