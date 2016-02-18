
package kalang.core;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class Method {
    private String name;
    private Type[] parameterTypes;
    private Type returnType;
    private int modifier;

    public Method(String name, Type[] parameterTypes, Type returnType, int modifier) {
        this.name = name;
        this.parameterTypes = parameterTypes;
        this.returnType = returnType;
        this.modifier = modifier;
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
    
}
