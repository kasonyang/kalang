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
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import kalang.ast.ExprStmt;
import kalang.ast.FieldNode;
import kalang.ast.InvocationExpr;
import kalang.ast.KeyExpr;
import kalang.ast.ParameterExpr;
import kalang.ast.ParameterNode;
import kalang.ast.VarExpr;
import kalang.core.ClassType;
import kalang.core.Type;
import kalang.core.Types;

public class AstUtil {


   public static String getMethodDescriptor(String name, Type[] types, String className) {
       List<String> typeStrList = new ArrayList<>(types.length);
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

    public static FieldNode getField(ClassNode ast, String name) {
        for (FieldNode f : ast.fields) {
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
    public static Type[] getParameterTypes(MethodNode mn) {
        if (mn.parameters == null) {
            return new Type[0];
        }
        Type[] types = new Type[mn.parameters.size()];
        for(int i=0;i<types.length;i++){
            types[i] = mn.parameters.get(i).type;
        }
        return types;
    }

    @Nonnull
    public static List<MethodNode> getUnimplementedMethod(ClassNode theClass, ClassNode theInterface) {
        List<MethodNode> list = new LinkedList();
        for (MethodNode m : theInterface.getMethodNodes()) {
            String name = m.name;
            Type[] types = getParameterTypes(m);
            //MethodNode[] methods = getMethodsByName(theClass, name);
            MethodNode matches = getMethod(theClass,name, types);
            if (matches == null) {
                list.add(m);
            }
        }
        return list;
    }
    
    public static void createEmptyConstructor(ClassNode clazzNode){
       ClassNode parent = clazzNode.parent;
       MethodNode[] methods = parent.getMethodNodes();
       for(MethodNode m:methods){
           if(m.name.equals("<init>")){
               MethodNode mm = clazzNode.createMethodNode();
               mm.name = m.name;
               mm.exceptionTypes = m.exceptionTypes;
               mm.modifier = m.modifier;
               mm.parameters = m.parameters;
               mm.type = m.type;
               BlockStmt body = new BlockStmt();
               mm.body = body;
               ExprNode[] params = new ExprNode[mm.parameters.size()];
               for(int i=0;i<params.length;i++){
                   params[i] = new ParameterExpr(mm.parameters.get(i));
               }
               body.statements.add(
                       new ExprStmt(
                               new InvocationExpr(
                                       new KeyExpr("super",Types.getClassType(clazzNode.parent))
                                       , "<init>"
                                       ,        params
                               )
                       )
               );
           }
       }
//        MethodNode initMethod = clazzNode.createMethodNode();
//        initMethod.modifier = Modifier.PUBLIC;
//        initMethod.name = "<init>";
//        initMethod.type = Types.VOID_TYPE;// Types.getClassType(clazzNode);
//       BlockStmt body = BlockStmt.create();
//       //body.statements.add(new )
//       initMethod.body = body;
    }
    
    @Nonnull
    public static String[] getParameterNames(@Nonnull ParameterNode[] parameterNodes){
        String[] names = new String[parameterNodes.length];
        for(int i=0;i<names.length;i++){
            names[i] = parameterNodes[i].name;
        }
        return names;
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

    public static MethodNode getMethod(ClassNode cls, String methodName, @Nullable Type[] types) {
       MethodNode[] methods = getMethodsByName(cls, methodName);
        for(MethodNode m:methods){
           Type[] mdTypes = getParameterTypes(m);
           if(Arrays.equals(mdTypes, types)) return m;
        }
        return null;
    }

    public static Type[] getExprTypes(ExprNode[] exprs) {
        if(exprs==null) return null;
        Type[] types = new Type[exprs.length];
        for(int i=0;i<types.length;i++){
            types[i] = exprs[i].getType();
        }
        return types;
    }
    
    public static boolean isStatic(int modifier){
            return Modifier.isStatic(modifier);
    }

    public static boolean isSpecialMethod(String methodName) {
        //TODO is it a special method?
        return methodName.startsWith("<");
    }
    
}
