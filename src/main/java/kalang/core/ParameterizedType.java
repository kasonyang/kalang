
package kalang.core;
import kalang.ast.ClassNode;
/**
 *
 * @author Kason Yang
 */
public class ParameterizedType extends ClassType {
    
    Type[] parameterTypes;
    
    public ParameterizedType(ClassType clazz,Type... parameterTypes ) {
        super(clazz.getClassNode());
        this.parameterTypes = parameterTypes;
    }

    public Type[] getParameterTypes() {
        return parameterTypes;
    }

}
