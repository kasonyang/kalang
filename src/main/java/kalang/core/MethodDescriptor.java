
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
    private String name;
    private Type[] parameterTypes;
    private Type returnType;
    private int modifier;
    private final MethodNode method;

    public MethodDescriptor(MethodNode method, Type[] parameterTypes, Type returnType) {
        this.name = method.name;
        this.parameterTypes = parameterTypes;
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
    
}
