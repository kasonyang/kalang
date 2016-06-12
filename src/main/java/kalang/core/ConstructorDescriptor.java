package kalang.core;

import kalang.ast.MethodNode;

/**
 *
 * @author Kason Yang
 */
public class ConstructorDescriptor extends ExecutableDescriptor{

    public ConstructorDescriptor(MethodNode method,ParameterDescriptor[] parameterDescriptors) {
        super(method, parameterDescriptors);
    }

}
