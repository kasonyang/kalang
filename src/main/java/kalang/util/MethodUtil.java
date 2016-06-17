package kalang.util;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;
import kalang.ast.MethodNode;
import kalang.ast.ParameterNode;
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
            names[i] = parameterNodes[i].name;
        }
        return names;
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
        return MethodUtil.getDeclarationKey(node.name, getParameterTypes(node));
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
        if (node.classNode != null) {
            className = node.classNode.name + "#";
        }
        return String.format("%s.%s(%s)", className, node.name, getParametersDescription(getParameterTypes(node)));
    }

    public static String toString(MethodNode node, String className) {
        return String.format("%s.%s(%s)", className, node.name, getParametersDescription(getParameterTypes(node)));
    }

    public static String toString(MethodNode[] methods, String delimiter) {
        List<String> list = new ArrayList<>(methods.length);
        for (MethodNode m : methods) {
            list.add(MethodUtil.toString(m));
        }
        return String.join(delimiter, list);
    }

    public static Type[] getParameterTypes(MethodNode mn) {
        if (mn.parameters == null) {
            return new Type[0];
        }
        Type[] types = new Type[mn.parameters.size()];
        for (int i = 0; i < types.length; i++) {
            types[i] = mn.parameters.get(i).type;
        }
        return types;
    }

}
