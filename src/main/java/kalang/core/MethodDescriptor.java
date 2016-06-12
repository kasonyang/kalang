
package kalang.core;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import kalang.ast.MethodNode;
/**
 *
 * @author Kason Yang
 */
public class MethodDescriptor {
    private final String name;
    private final Type[] parameterTypes;
    private final Type returnType;
    private final int modifier;
    private final MethodNode method;
    private final ParameterDescriptor[] parameterDescriptors;

    public MethodDescriptor(MethodNode method, ParameterDescriptor[] parameterDescriptors, Type returnType) {
        this.name = method.name;
        this.parameterDescriptors = parameterDescriptors;
        Type[] ptypes = new Type[parameterDescriptors.length];
        for(int i=0;i<this.parameterDescriptors.length;i++){
            ptypes[i] = parameterDescriptors[i].getType();
        }
        parameterTypes = ptypes;
        this.returnType = returnType;
        this.modifier = method.modifier;
        this.method = method;
    }

    public String getName() {
        return name;
    }

    public Type[] getParameterTypes() {
        return parameterTypes;
    }

    public Type getReturnType() {
        return returnType;
    }

    public int getModifier() {
        return modifier;
    }

    public MethodNode getMethodNode() {
        return method;
    }
    
    public ParameterDescriptor[] getParameterDescriptors(){
        return parameterDescriptors;
    }
    
}
