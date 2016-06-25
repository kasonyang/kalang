package kalang.core;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import kalang.ast.MethodNode;
import kalang.util.AstUtil;
import kalang.util.MethodUtil;

/**
 *
 * @author Kason Yang
 */
public abstract class ExecutableDescriptor {
    protected final Type[] parameterTypes;
    protected final int modifier;
    protected final MethodNode methodNode;
    protected final ParameterDescriptor[] parameterDescriptors;
    protected final Type returnType;
    
    protected final String name;
    
    protected final Type[] exceptionTypes;

    public ExecutableDescriptor(MethodNode method, ParameterDescriptor[] parameterDescriptors,Type returnType,Type[] exceptionTypes) {
        this.modifier = method.modifier;
        this.methodNode = method;
        this.name = method.name;
        this.parameterDescriptors = parameterDescriptors;
        Type[] ptypes = new Type[parameterDescriptors.length];
        for(int i=0;i<this.parameterDescriptors.length;i++){
            ptypes[i] = parameterDescriptors[i].getType();
        }
        parameterTypes = ptypes;
        this.returnType = returnType;
        this.exceptionTypes = exceptionTypes;
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
    
    public String getDeclarationKey(){
        return MethodUtil.getDeclarationKey(name, parameterTypes);
    }
    
    @Override
    public String toString() {
        List<String> params = new ArrayList();
        for(ParameterDescriptor p:getParameterDescriptors()){
            params.add(String.format("%s %s", p.getType(),p.getName()));
        }
        return String.format("%s %s(%s)", Modifier.toString(modifier),name,String.join(",", params));
    }
    
    public Type getReturnType() {
        return returnType;
    }

    //TODO exception type should be object type
    public Type[] getExceptionTypes() {
        return exceptionTypes;
    }
    
    
}
