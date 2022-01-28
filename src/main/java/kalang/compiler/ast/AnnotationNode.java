
package kalang.compiler.ast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kason Yang 
 */
public class AnnotationNode extends AstNode{
    
    protected ClassNode annotationType;
    
    public final Map<String,ConstExpr> values = new HashMap<>();

    public AnnotationNode(ClassNode annotationType) {
        this.annotationType = annotationType;
    }

    public ClassNode getAnnotationType() {
        return annotationType;
    }

    @Override
    public List<AstNode> getChildren() {
        return noChildren();
    }

    @Override
    public void updateChildren(ChildUpdater childUpdater) {

    }
}
