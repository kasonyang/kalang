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
import java.util.Map;
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
import kalang.AmbiguousMethodException;
import kalang.MethodNotFoundException;
import kalang.ast.AssignExpr;
import kalang.ast.ClassReference;
import kalang.ast.FieldExpr;
import kalang.ast.ObjectFieldExpr;
import kalang.ast.ReturnStmt;
import kalang.ast.StaticFieldExpr;
import kalang.core.ClassType;
import kalang.core.GenericType;
import kalang.core.MethodDescriptor;
import kalang.core.ParameterizedType;
import kalang.core.Type;
import kalang.core.Types;

public class AstUtil {


    public static String getMethodDescriptor(String name,String returnType,String... paramTypes){
        return String.format("%s(%s)%s", name,String.join(",", paramTypes),returnType);
    }
   public static String getMethodDescriptor(String name,Type returnType,Type[] types) {
        List<String> typeStrList = new ArrayList<>(types.length);
        for(Type t:types){
            typeStrList.add(t.getName());
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
   
   public static String getMethodDescription(MethodNode node){
       String className = "";
       if(node.classNode!=null){
           className = node.classNode.name + "#";
       }
       return String.format("%s%s(%s)", className,node.name,getParametersDescription(getParameterTypes(node)));
   }
   
   public static String getMethodDescription(MethodNode node,String className){
       return String.format("%s#%s(%s)", className,node.name,getParametersDescription(getParameterTypes(node)));
   }
   
   public static String getMethodDescription(MethodNode[] methods,String delimiter){
       List<String> list = new ArrayList<>(methods.length);
       for(MethodNode m:methods){
           list.add(getMethodDescription(m));
       }
       return String.join(delimiter, list);
   }

    public static String getMethodDescriptor(MethodNode node) {
        return getMethodDescriptor(node.name, node.type, getParameterTypes(node));
    }

    /**
     * get an accessible field by name
     * @param ast
     * @param name
     * @param caller
     * @return 
     */
    @Nullable
    public static FieldNode getField(ClassNode ast, String name,@Nullable ClassNode caller) {
        for (FieldNode f : listAccessibleFields(ast, caller)) {
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
               BlockStmt body = new BlockStmt(null);
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
    
    public static boolean containsConstructor(ClassNode clazz){
        MethodNode[] dms = clazz.getDeclaredMethodNodes();
        for(MethodNode m:dms){
            if("<init>".equals(m.name)) return true;
        }
        return false;
    }

    public static MethodDescriptor[] getMethodsByName(MethodDescriptor[] mds, String methodName) {
        List<MethodDescriptor> methods = new LinkedList();
        for (MethodDescriptor m : mds) {
            if (m.getName().equals(methodName)) {
                methods.add(m);
            }
        }
        return methods.toArray(new MethodDescriptor[0]);
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
    @Nullable
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
    
    public static MethodNode getMethod(ClassNode cls, String methodName, @Nullable Type[] types){
        return getMethod(cls, methodName, types,true);
    }
    
    @Nullable
    public static MethodNode getAccessibleMethod(ClassNode cls, String methodName, @Nullable Type[] types,ClassNode caller) {
        MethodNode md = getMethod(cls, methodName, types);
        if(md==null) return null;
        if(!isAccessibleMethod(md,caller)) return null;
        return md;
    }
    
    @Nullable
    public static MethodDescriptor getExactedMethod(ClassType targetType,MethodDescriptor[] candidates,String methodName,@Nullable Type[] types){
        MethodDescriptor[] methods = getMethodsByName(candidates, methodName);
        for(MethodDescriptor m:methods){
           Type[] mdTypes = m.getParameterTypes();
           if(Arrays.equals(mdTypes, types)) return m;
           if(mdTypes==null || mdTypes.length==0){
               if(types==null || types.length==0) return m;
           }
        }
        return null;
    }

    //TODO should rename?
    @Nullable
    public static MethodNode getMethod(ClassNode cls, String methodName, @Nullable Type[] types,boolean recursive) {
        ClassType clazzType = Types.getClassType(cls);
        MethodDescriptor[] clsMethods = clazzType.getMethodDescriptors(null, recursive);
        MethodDescriptor md = getExactedMethod(clazzType, clsMethods, methodName, types);
        if(md!=null) return md.getMethodNode();
        return null;
    }

    @Nullable
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
       SuperExpr thisExpr = new SuperExpr(clazz);
        return new ExprStmt(
                ObjectInvokeExpr.create(thisExpr, "<init>", null,clazz)
        );
    }
    
    @Nullable
    public static String getPackageName(String name){
        int dotIdx = name.lastIndexOf('.');
        if (dotIdx > 0) {
            return name.substring(0, dotIdx);
        }else{
            return null;
        }
    }
    
    public static String getClassNameWithoutPackage(String name){
        int dotIdx = name.lastIndexOf('.');
        if (dotIdx > 0) {
            return name.substring(dotIdx + 1);
        }else{
            return name;
        }
    }
    
    public static boolean hasSetter(ClassNode clazz,FieldNode field){
        MethodNode method = getMethod(clazz, "set" + NameUtil.firstCharToUpperCase(field.name),new Type[]{ field.getType()});
        return method !=null;
    }
    
    public static boolean hasGetter(ClassNode clazz,FieldNode field){
        MethodNode method = getMethod(clazz, "get" + NameUtil.firstCharToUpperCase(field.name) , null);
        return method != null;
    }
    
    public static void createGetter(ClassNode clazz,FieldNode field,int accessModifier){
        String fn = field.name;
        String getterName = "get" + NameUtil.firstCharToUpperCase(fn);
        boolean isStatic = isStatic(field.modifier);
        MethodNode getter = clazz.createMethodNode();
        getter.offset = field.offset;
        getter.name = getterName;
        getter.modifier = accessModifier;
        getter.type = field.getType();
        BlockStmt body = new BlockStmt(null);
        FieldExpr fe;
        ClassReference cr = new ClassReference(clazz);
        if(isStatic){
            if(!isStatic(getter.modifier)){
                getter.modifier |= Modifier.STATIC;
            }
            fe = new StaticFieldExpr(cr, field);
        }else{
            fe = new ObjectFieldExpr(new ThisExpr(Types.getClassType(clazz)), field);
        }
        body.statements.add(new ReturnStmt(fe));
        getter.body = body;
    }
    
    public static void createSetter(ClassNode clazz,FieldNode field,int accessModifier){
        String fn = field.name;
        String setterName = "set" + NameUtil.firstCharToUpperCase(fn);
        boolean isStatic = isStatic(field.modifier);
        MethodNode setter = clazz.createMethodNode();
        setter.offset = field.offset;
        setter.name = setterName;
        setter.modifier = accessModifier;
        if(isStatic(accessModifier)){
            setter.type = Types.VOID_TYPE;
        }else{
            setter.type = Types.getClassType(clazz);
        }
        ParameterNode param = ParameterNode.create(setter);
        param.type = field.getType();
        param.name = field.name;
        setter.parameters.add(param);
        BlockStmt body = new BlockStmt(null);
        FieldExpr fe;
        ExprNode paramVal = new ParameterExpr(param);
        ClassReference cr = new ClassReference(clazz);
        if(isStatic){
            if(!isStatic(setter.modifier)){
                setter.modifier |= Modifier.STATIC;
            }
            fe = new StaticFieldExpr(cr, field);
        }else{
            fe = new ObjectFieldExpr(new ThisExpr(Types.getClassType(clazz)), field);
        }
        body.statements.add(new ExprStmt(new AssignExpr(fe,paramVal)));
        if(!isStatic(accessModifier)){
            body.statements.add(new ReturnStmt(new ThisExpr(Types.getClassType(clazz))));
        }
        setter.body = body;
    }
    
    public static boolean isAccessibleField(FieldNode field,@Nullable ClassNode caller){
        return isAccessible(field.modifier, field.classNode, caller);
    }
    
    public static FieldNode[] listAccessibleFields(ClassNode clazz,@Nullable ClassNode caller){
        List<FieldNode> list = new LinkedList<>();
        for(FieldNode f:listFields(clazz)){
            if(isAccessibleField(f, caller)){
                list.add(f);
            }
        }
        return list.toArray(new FieldNode[list.size()]);
    }
    
    public static FieldNode[] listFields(ClassNode clazz){
        List<FieldNode> list = new LinkedList<>();
        ClassNode clz = clazz;
        while(clz!=null){
            for(FieldNode f:clazz.fields){
                list.add(f);
            }
            clz = clz.parent;
        }
        return list.toArray(new FieldNode[list.size()]);
    }
    
    public static MethodNode[] listAccessibleMethods(ClassNode clazz,@Nullable ClassNode caller,boolean recursive){
        List<MethodNode> list = new LinkedList<>();
        for(MethodNode m: (recursive ? clazz.getMethods() : clazz.getDeclaredMethodNodes()) ){
            if(isAccessibleMethod(m, caller)){
                list.add(m);
            }
        }
        return list.toArray(new MethodNode[list.size()]);
    }
    
    public static boolean isAccessible(int modifier,ClassNode owner,@Nullable ClassNode caller){
        if(caller!=null){
            if(caller.equals(owner)){
                return true;
            }else if(caller.isSubclassOf(owner)){
                if(Modifier.isProtected(modifier) || Modifier.isPublic(modifier)){
                    return true;
                }
            }
        }
        return Modifier.isPublic(modifier);
    }

    public static boolean isAccessibleMethod(MethodNode m,@Nullable ClassNode caller) {
        return isAccessible(m.modifier, m.classNode, caller);
    }
    
}
