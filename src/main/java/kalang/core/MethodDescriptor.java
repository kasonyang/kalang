
package kalang.core;
import kalang.ast.MethodNode;
/**
 *
 * @author Kason Yang
 */
public class MethodDescriptor extends ExecutableDescriptor {
    
    private final Type returnType;

    public MethodDescriptor(MethodNode method, ParameterDescriptor[] parameterDescriptors, Type returnType) {
        super(method, parameterDescriptors);
        this.returnType = returnType;
    }

    public Type getReturnType() {
        return returnType;
    }
    
}
