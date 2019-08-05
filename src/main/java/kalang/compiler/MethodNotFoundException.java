
package kalang.compiler;
import kalang.compiler.core.ObjectType;
/**
 *
 * @author Kason Yang 
 */
public class MethodNotFoundException extends RuntimeException{

    public MethodNotFoundException(String message) {
        super(message);
    }

    public MethodNotFoundException(ObjectType type,String methodName) {
        super("method not found:" + type + "." + methodName);
    }
    
}
