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
import kalang.ast.ObjectInvokeExpr;
import kalang.ast.ThisExpr;
import kalang.ast.ParameterExpr;
import kalang.ast.ParameterNode;
import kalang.ast.Statement;
import kalang.ast.SuperExpr;
import kalang.ast.VarExpr;
import kalang.compiler.AmbiguousMethodException;
import kalang.compiler.MethodNotFoundException;
import kalang.core.ClassType;
import kalang.core.Type;
import kalang.core.Types;

public class AstUtil {


    public static String getMethodDescriptor(String name,String returnType,String... paramTypes){
        return String.format("%s(%s)%s", name,String.join(",", paramTypes),returnType);
    }
   public static String getMethodDescriptor(String name,Type returnType,Type[] types) {
        List<String> typeStrList = new ArrayList<>(types.length);
        if(types!=null){
             for(Type t:types){
                 typeStrList.add(t.getName());
             }
        }
        return  getMethodDescriptor(name, returnType.getName(),typeStrList.toArray(new String[0]));
    }
   
   public static String getParametersDescription(Type[] types){
       List<String> tys = new ArrayList<>(types.length);
       for(Type t:types){
           tys.add(t.getName());
       }
       return String.format("(%s)", String.join(",", tys));
   }
   
   public static MethodNode getMethodByDescriptor(MethodNode[] mds,String descriptor){
       for(MethodNode m:mds){
           if(getMethodDescriptor(m).equals(descriptor)){
               return m;
           }
       }
       return null;
   }
   
   public static String getMethodDescription(String className,String name,Type[] types) {
       return String.format("%s#%s(%s)", className,name,getParametersDescription(types));
   }
   
   public static String getMethodDescription(MethodNode node,String className){
       return String.format("%s#%s(%s)", className,node.name,getParametersDescription(getParameterTypes(node)));
   }

    public static String getMethodDescriptor(MethodNode node) {
        return getMethodDescriptor(node.name, node.type, getParameterTypes(node));
    }

    public static FieldNode getField(ClassNode ast, String name) {
        for (FieldNode f : ast.fields) {
            if (f.name.equals(name)) {
                return f;
            }
        }
        return null;
    }

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
        for (MethodNode m : theInterface.getMethods()) {
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
       MethodNode[] methods = parent.getDeclaredMethodNodes();
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
                               new ObjectInvokeExpr(
                                       new SuperExpr(clazzNode), 
                                       m,
                                       params)
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

    public static MethodNode[] getMethodsByName(MethodNode[] mds, String methodName) {
        List<MethodNode> methods = new LinkedList();
        for (MethodNode m : mds) {
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
        if(args==null) return null;
        if(from==null || from.length==0){
            if(target==null || target.length==0){
                return args;
            }
        }
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
       MethodNode[] methods = getMethodsByName(cls.getMethods(), methodName);
        for(MethodNode m:methods){
           Type[] mdTypes = getParameterTypes(m);
           if(Arrays.equals(mdTypes, types)) return m;
           if(mdTypes==null || mdTypes.length==0){
               if(types==null || types.length==0) return m;
           }
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
    
    public static boolean isConstructorCallStatement(Statement stmt){
        try{
            ExprStmt exprStmt = (ExprStmt) stmt;
            InvocationExpr invExpr = (InvocationExpr) exprStmt.getExpr();
            MethodNode method = invExpr.getMethod();
            return method.name.equals("<init>") && !Modifier.isStatic(method.modifier);
        }catch(ClassCastException ex){
            return false;
        }
    }

    public static boolean isConstructor(MethodNode m) {
        return !isStatic(m.modifier) && m.name.equals("<init>");
    }

    public static boolean hasConstructorCallStatement(List<Statement> statements) {
        for(Statement s:statements){
            if(isConstructorCallStatement(s)) return true;
        }
        return false;
    }
    
    public static Statement createDefaultSuperConstructorCall(ClassNode clazz) throws MethodNotFoundException, AmbiguousMethodException{
       ClassType clsType = Types.getClassType(clazz);
       SuperExpr thisExpr = new SuperExpr(clazz);
        return new ExprStmt(
                ObjectInvokeExpr.create(thisExpr, "<init>", null)
        );
    }
}
