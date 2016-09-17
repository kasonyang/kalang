package kalang.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import kalang.ast.MethodNode;
import kalang.ast.ParameterNode;
import kalang.core.ConstructorDescriptor;
import kalang.core.ExecutableDescriptor;
import kalang.core.MethodDescriptor;
import kalang.core.Type;

/**
 *
 * @author Kason Yang
 */
public class MethodUtil {

    @Nonnull
    public static String[] getParameterNames(@Nonnull ParameterNode[] parameterNodes) {
        String[] names = new String[parameterNodes.length];
        for (int i = 0; i < names.length; i++) {
            names[i] = parameterNodes[i].getName();
        }
        return names;
    }
    
    public static String getDeclarationKey(String name,ParameterNode[] params){
        Type[] types = new Type[params.length];
        for(int i=0;i<types.length; i++){
            types[i] = params[i].getType();
        }
        return getDeclarationKey(name, types);
    }

    public static String getDeclarationKey(String name, String... paramTypes) {
        return String.format("%s(%s)", name, String.join(",", paramTypes));
    }

    public static String getDeclarationKey(String name, Type[] types) {
        List<String> typeStrList = new ArrayList<>(types.length);
        for (Type t : types) {
            typeStrList.add(t.getDeclarationKey());
        }
        return MethodUtil.getDeclarationKey(name, typeStrList.toArray(new String[typeStrList.size()]));
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
            className = node.getClassNode().name + "#";
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
    
    @Nullable
    private static ExecutableDescriptor getExecutableDescriptor(ExecutableDescriptor[] methods,String name,@Nullable Type[] parameterTypes){
        if(parameterTypes==null){
            parameterTypes = new Type[0];
        }
        for(ExecutableDescriptor m:methods){
            if(!m.getName().equals(name)) continue;
            Type[] mParams = m.getParameterTypes();
            if(!Arrays.equals(mParams, parameterTypes)) continue;
            return m;
        }
        return null;
    }
    
    @Nullable
    public static ConstructorDescriptor getConstructorDescriptor(ConstructorDescriptor[] constructors,@Nullable Type[] paramTypes){
        return (ConstructorDescriptor) getExecutableDescriptor(constructors,"<init>", paramTypes);
    }
    
    @Nullable
    public static MethodDescriptor getMethodDescriptor(MethodDescriptor[] methods, String name,@Nullable Type[] paramTypes){
        return (MethodDescriptor) getExecutableDescriptor(methods, name, paramTypes);
    }

}
