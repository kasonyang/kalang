
package kalang.core;
import kalang.ast.ClassNode;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class ParameteredType extends ClassType {
    
    Type[] parameterTypes;
    
    public ParameteredType(ClassType clazz,Type... parameterTypes ) {
        super(clazz.getClassNode());
        this.parameterTypes = parameterTypes;
    }

    public Type[] getParameterTypes() {
        return parameterTypes;
    }

}
