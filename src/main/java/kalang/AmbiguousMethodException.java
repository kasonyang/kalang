
package kalang;

import java.util.Collection;
import kalang.ast.MethodNode;
import kalang.util.AstUtil;

/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class AmbiguousMethodException extends Exception{

    public AmbiguousMethodException(Collection<? extends MethodNode> methods){
        this(methods.toArray(new MethodNode[methods.size()]));
    }
    
    public AmbiguousMethodException(MethodNode... methods){
        this("the method is ambiguous:\n" +  AstUtil.getMethodDescription(methods,"\n"));
    }
    
    public AmbiguousMethodException(String message) {
        super(message);
    }

    public AmbiguousMethodException() {
    }

}
