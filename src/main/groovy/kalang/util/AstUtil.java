package kalang.util;

import java.util.LinkedList;
import java.util.List;

import jast.ast.*;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import kalang.core.ClassType;
import kalang.core.Type;
import kalang.core.Types;

public class AstUtil {


   public static String getMethodDescriptor(String name, List<Type> types, String className) {
       List<String> typeStrList = new ArrayList<>(types.size());
       for(Type t:types){
           typeStrList.add(t.getName());
       }
        String typeStr = String.join(",", typeStrList);
        String str = String.format("%s(%s)", name, typeStr);
        if (className != null) {
            str = String.format("%s#%s", className, str);
        }
        return str;
    }

    public static String getMethodDescriptor(MethodNode node, String className) {
        return getMethodDescriptor(node.name, getParameterTypes(node), className);
    }

    public static VarObject getField(ClassNode ast, String name) {
        for (VarObject f : ast.fields) {
            if (f.name.equals(name)) {
                return f;
            }
        }
        return null;
    }

    /*MethodNode getMethod(ClassNode ast,String name,String[] types){
		def methods = ast.methods
		for(def m in methods){
			if(m.name!=name) continue
			def ps = m.parameters
			def mtypes = []
			for(def p in ps){
				mtypes.add(p.type)
			}
			if(castSystem.isCastableTo(types,mtypes)){
				return m
			}
		}
		return null
	}*/
    public static List<Type> getParameterTypes(MethodNode mn) {
        List<Type> types = new LinkedList();
        if (mn.parameters == null) {
            return types;
        }
        for (VarObject p : mn.parameters) {
            types.add(p.type);
        }
        return types;
    }

    public static List<MethodNode> getUnimplementedMethod(ClassNode theClass, ClassNode theInterface) {
        List<MethodNode> list = new LinkedList();
        for (MethodNode m : theInterface.methods) {
            String name = m.name;
            Type[] types = getParameterTypes(m).toArray(new Type[0]);
            MethodNode[] methods = getMethodsByName(theClass, name);
            MethodNode[] matches = matchMethodsByType(methods, types);
            if (matches == null || matches.length == 0) {
                list.add(m);
            }
        }
        return list;
    }
    
    public static void createEmptyConstructor(ClassNode clazzNode){
        MethodNode initMethod = MethodNode.create();
        initMethod.modifier = Modifier.PUBLIC | Modifier.STATIC;
        initMethod.name = "<init>";
        initMethod.type = Types.getClassType(clazzNode);
        initMethod.body = BlockStmt.create();
        clazzNode.methods.add(initMethod);
    }

    public static MethodNode[] getMethodsByName(ClassNode cls, String methodName) {
        List<MethodNode> methods = new LinkedList();
        for (MethodNode m : cls.methods) {
            if (m.name.equals(methodName)) {
                methods.add(m);
            }
        }
        return methods.toArray(new MethodNode[0]);
    }

    public static boolean matchType(Type from, Type target, boolean matchSubclass, boolean autoCast) {
        if (from.equals(target)) {
            return true;
        }
            if (matchSubclass
                    && (from instanceof ClassType)
                    &&((ClassType)from).isSubclassTypeOf(target)
                    //&& typeSystem.isSubclass(from, target)
                    ) {
                return true;
            }
        return autoCast && from.isCastableTo(target);
    }

    public static boolean matchTypes(Type[] from, Type[] target, boolean matchSubclass, boolean autoCast) {
        if (from.length != target.length) {
            return false;
        }
        for (int i = 0; i < from.length; i++) {
            Type f = from[i];
            Type t = target[i];
            if (!matchType(f, t, matchSubclass, autoCast)) {
                return false;
            }
        }
        return true;
    }

    public static MethodNode[] matchMethodsByType(MethodNode[] methods, Type[] types) {
        return matchMethodsByType(methods, types, false, false);
    }

    public static MethodNode[] matchMethodsByType(MethodNode[] methods, Type[] types, boolean matchSubclass) {
        return matchMethodsByType(methods, types, matchSubclass, false);
    }

    public static MethodNode[] matchMethodsByType(MethodNode[] methods, Type[] types, boolean matchSubclass, boolean autoCast) {
        List<MethodNode> list = new LinkedList();
        for (MethodNode m : methods) {
            Type[] mTypes = getParameterTypes(m).toArray(new Type[0]);
            if (matchTypes(types, mTypes, matchSubclass, autoCast)) {
                list.add(m);
            }
        }
        return list.toArray(new MethodNode[0]);
    }    
    
    public static MethodNode[] selectMethod(ClassNode cls, String methodName, Type[] types) {
        MethodNode[] methods = getMethodsByName(cls, methodName);
        MethodNode[] matches;
        matches = matchMethodsByType(methods, types, false, false);
        if (matches == null || matches.length == 0) {
            matches = matchMethodsByType(methods, types, true, false);
        }
        if (matches == null || matches.length == 0) {
            matches = matchMethodsByType(methods, types, true, true);
        }
        return matches;
    }
    
}
