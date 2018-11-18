
package kalang.compiler.ast;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Kason Yang 
 */
public class AnnotationNode{
    
    protected ClassNode annotationType;
    
    public final Map<String,ConstExpr> values = new HashMap<>();

    public AnnotationNode(ClassNode annotationType) {
        this.annotationType = annotationType;
    }

    public ClassNode getAnnotationType() {
        return annotationType;
    }
    
    

}
