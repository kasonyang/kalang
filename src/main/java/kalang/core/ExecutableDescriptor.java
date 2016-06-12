package kalang.core;

import kalang.ast.MethodNode;

/**
 *
 * @author Kason Yang
 */
public abstract class ExecutableDescriptor {
    private final Type[] parameterTypes;
    private final int modifier;
    private final MethodNode methodNode;
    private final ParameterDescriptor[] parameterDescriptors;
    
    private final String name;

    public ExecutableDescriptor(MethodNode method, ParameterDescriptor[] parameterDescriptors) {
        this.modifier = method.modifier;
        this.methodNode = method;
        this.name = method.name;
        this.parameterDescriptors = parameterDescriptors;
        Type[] ptypes = new Type[parameterDescriptors.length];
        for(int i=0;i<this.parameterDescriptors.length;i++){
            ptypes[i] = parameterDescriptors[i].getType();
        }
        parameterTypes = ptypes;
    }

    public Type[] getParameterTypes() {
        return parameterTypes;
    }

    public int getModifier() {
        return modifier;
    }

    public MethodNode getMethodNode() {
        return methodNode;
    }

    public ParameterDescriptor[] getParameterDescriptors() {
        return parameterDescriptors;
    }

    public String getName() {
        return name;
    }
    
    
    
}
