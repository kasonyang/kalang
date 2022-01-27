package kalang.compiler.util;

import kalang.compiler.ast.MethodNode;
import kalang.compiler.ast.ParameterNode;
import kalang.compiler.core.MethodDescriptor;
import kalang.compiler.core.Type;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Kason Yang
 */
public class MethodUtil {

    public static Type getExpectedReturnType(MethodNode method) {
        return method.isGenerator() ? GeneratorUtil.getGeneratorResultType(method) : method.getType();
    }

    public static String getDeclarationKey(String name, String... paramTypes) {
        return name + "(" + String.join(",", paramTypes) + ")";
    }

    public static String getDeclarationKey(String name, Type[] types) {
        List<String> typeStrList = new ArrayList<>(types.length);
        for (Type t : types) {
            typeStrList.add(TypeUtil.getTypeDescriptor(t));
        }
        return MethodUtil.getDeclarationKey(name, typeStrList.toArray(new String[0]));
    }
    
    public static String getDeclarationKey(MethodNode node) {
        return MethodUtil.getDeclarationKey(node.getName(), getParameterTypes(node));
    }

    public static String getParametersDescription(Type[] types) {
        List<String> tys = new ArrayList<>(types.length);
        for (Type t : types) {
            tys.add(t.getName());
        }
        return String.join(",", tys);
    }

    public static String toString(String className, String name, Type[] types) {
        return String.format("%s.%s(%s)", className, name, getParametersDescription(types));
    }

    public static String toString(MethodNode node) {
        String className = "";
        if (node.getClassNode() != null) {
            className = node.getClassNode().getName();
        }
        return String.format("%s.%s(%s)", className, node.getName(), getParametersDescription(getParameterTypes(node)));
    }

    public static String toString(MethodNode node, String className) {
        return String.format("%s.%s(%s)", className, node.getName(), getParametersDescription(getParameterTypes(node)));
    }

    public static String toString(MethodNode[] methods, String delimiter) {
        List<String> list = new ArrayList<>(methods.length);
        for (MethodNode m : methods) {
            list.add(MethodUtil.toString(m));
        }
        return String.join(delimiter, list);
    }

    public static Type[] getParameterTypes(MethodNode mn) {
        ParameterNode[] parameters = mn.getParameters();
        Type[] types = new Type[parameters.length];
        for (int i = 0; i < types.length; i++) {
            types[i] = parameters[i].getType();
        }
        return types;
    }

    public static Type[] getReturnAndParamTypes(Type returnType, Type[] paramTypes) {
        Type[] types = new Type[paramTypes.length + 1];
        types[0] = returnType;
        System.arraycopy(paramTypes, 0, types, 1, paramTypes.length);
        return types;
    }

    public static Type[] getReturnAndParamTypes(MethodDescriptor md) {
        return getReturnAndParamTypes(md.getReturnType(), md.getParameterTypes());
    }
    
    @Nullable
    public static MethodDescriptor getMethodDescriptor(MethodDescriptor[] methods,String name,@Nullable Type[] parameterTypes){
        if(parameterTypes==null){
            parameterTypes = new Type[0];
        }
        for(MethodDescriptor m:methods){
            if(!m.getName().equals(name)) continue;
            Type[] mParams = m.getParameterTypes();
            if(!Arrays.equals(mParams, parameterTypes)) continue;
            return m;
        }
        return null;
    }
    
    @Nullable
    public static MethodDescriptor getMethodDescriptor(MethodDescriptor[] methods,String declarationkey) {
        for (MethodDescriptor m:methods) {
            if (declarationkey.equals(m.getDeclarationKey())) {
                return m;
            }
        }
        return null;
    }

}
