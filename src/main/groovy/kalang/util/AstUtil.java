package kalang.util;

import kalang.ast.ExprNode;
import kalang.ast.MethodNode;
import kalang.ast.ClassNode;
import kalang.ast.BlockStmt;
import kalang.ast.VarObject;
import java.util.LinkedList;
import java.util.List;

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
        for (MethodNode m : theInterface.getMethodNodes()) {
            String name = m.name;
            Type[] types = getParameterTypes(m).toArray(new Type[0]);
            //MethodNode[] methods = getMethodsByName(theClass, name);
            MethodNode matches = getMethod(theClass,name, types);
            if (matches == null) {
                list.add(m);
            }
        }
        return list;
    }
    
    public static void createEmptyConstructor(ClassNode clazzNode){
        MethodNode initMethod = clazzNode.createMethodNode();
        initMethod.modifier = Modifier.PUBLIC | Modifier.STATIC;
        initMethod.name = "<init>";
        initMethod.type = Types.getClassType(clazzNode);
        initMethod.body = BlockStmt.create();
    }

    public static MethodNode[] getMethodsByName(ClassNode cls, String methodName) {
        List<MethodNode> methods = new LinkedList();
        for (MethodNode m : cls.getMethodNodes()) {
            if (m.name.equals(methodName)) {
                methods.add(m);
            }
        }
        return methods.toArray(new MethodNode[0]);
    }

    public static ExprNode matchType(Type from, Type target, ExprNode expr) {
        if (from.equals(target)) {
            return expr;
        }
        return BoxUtil.assign(expr, from, target);
    }

    /**
     * 
     * @param args
     * @param from
     * @param target
     * @return array when matched,null when not
     */
    public static ExprNode[] matchTypes(ExprNode[] args,Type[] from, Type[] target) {
        if (from.length != target.length || from.length!=args.length) {
            return null;
        }
        if(from.length==0) return new ExprNode[0];
       ExprNode[] newParams = new ExprNode[from.length];
        for (int i = 0; i < from.length; i++) {
            Type f = from[i];
            Type t = target[i];
            newParams[i] = matchType(f, t, args[i]);
            if(newParams[i]==null) return null;
        }
        return newParams;
    }

    public static MethodNode getMethod(ClassNode cls, String methodName, Type[] types) {
       MethodNode[] methods = getMethodsByName(cls, methodName);
        for(MethodNode m:methods){
           Type[] mdTypes = getParameterTypes(m).toArray(new Type[0]);
           if(Arrays.equals(mdTypes, types)) return m;
        }
        return null;
    }
    
}
