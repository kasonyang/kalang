package kalang.compiler.util;

import kalang.compiler.ast.*;
import kalang.compiler.compile.semantic.AmbiguousMethodException;
import kalang.compiler.compile.semantic.InvocationResolver;
import kalang.compiler.compile.semantic.MethodNotFoundException;
import kalang.compiler.core.*;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AstUtil {

    @Nonnull
    public static List<MethodDescriptor> getUnimplementedMethod(ClassNode theClass){
        List<MethodDescriptor> list = new LinkedList();
        for(ObjectType i:theClass.getInterfaces()){
            list.addAll(getUnimplementedMethod(theClass,i));
        }
        return list;
    }
    
    @Nonnull
    public static List<MethodDescriptor> getUnimplementedMethod(ClassNode theClass, ObjectType theInterface) {
        ClassType theType = Types.getClassType(theClass);
        MethodDescriptor[] implementedMethods = theType.getMethodDescriptors(theClass, true, false);
        List<MethodDescriptor> list = new LinkedList();
        for (MethodDescriptor m : theInterface.getMethodDescriptors(theClass, false,true)) {
            if(ModifierUtil.isDefault(m.getModifier())) continue;
            String name = m.getName();
            Type[] types = m.getParameterTypes();
            MethodDescriptor overridingMd = MethodUtil.getMethodDescriptor(implementedMethods,name,types);
            if (overridingMd == null 
                    //TODO move check to where method declare
                    || !OverrideUtil.overridingCompatible(overridingMd.getModifier(), m.getModifier()) 
                    || !OverrideUtil.returnTypeCompatible(overridingMd.getReturnType(), m.getReturnType())
                    ) {
                list.add(m);
            }
        }
        return list;
    }
    
    public static boolean createEmptyConstructor(ClassNode clazzNode){
        ObjectType supType = clazzNode.getSuperType();
        if (supType == null) {
            throw new RuntimeException("super type is null:" + clazzNode.name);
        }
        MethodDescriptor[] constructors = supType.getConstructorDescriptors(clazzNode);
        MethodDescriptor m = MethodUtil.getMethodDescriptor(constructors, "<init>", null);
        if (m != null) {
            MethodNode mm = clazzNode.createMethodNode(Types.VOID_TYPE, m.getName(), m.getModifier());
            for (Type e : m.getExceptionTypes()) mm.addExceptionType(e);
            ParameterDescriptor[] pds = m.getParameterDescriptors();
            for (ParameterDescriptor pd : pds) {
                mm.createParameter(pd.getType(), pd.getName(), pd.getModifier());
            }
            BlockStmt body = mm.getBody();
            ParameterNode[] parameters = mm.getParameters();
            ExprNode[] params = new ExprNode[parameters.length];
            for (int i = 0; i < params.length; i++) {
                params[i] = new ParameterExpr(parameters[i]);
            }
            body.statements.add(
                    new ExprStmt(
                            new ObjectInvokeExpr(
                                    new SuperExpr(clazzNode),
                                    m,
                                    params)
                    )
            );
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean containsConstructor(ClassNode clazz){
        MethodNode[] dms = clazz.getDeclaredMethodNodes();
        for(MethodNode m:dms){
            if("<init>".equals(m.getName())) return true;
        }
        return false;
    }

    public static MethodDescriptor[] filterMethodByName(MethodDescriptor[] mds, String methodName) {
        List<MethodDescriptor> methods = new ArrayList(mds.length);
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
            }else{
                return null;
            }
        }
        if (from.length != target.length || from.length!=args.length) {
            return null;
        }
        ExprNode[] newParams = new ExprNode[from.length];
        for (int i = 0; i < from.length; i++) {
            Type f = from[i];
            Type t = target[i];
            newParams[i] = matchType(f, t, args[i]);
            if(newParams[i]==null) return null;
        }
        return newParams;
    }
    
    @Nullable
    public static MethodDescriptor getExactedMethod(ObjectType targetType,MethodDescriptor[] candidates,String methodName,@Nullable Type[] types){
        MethodDescriptor[] methods = filterMethodByName(candidates, methodName);
        for(MethodDescriptor m:methods){
           Type[] mdTypes = m.getParameterTypes();
           if(Arrays.equals(mdTypes, types)) return m;
           if(mdTypes==null || mdTypes.length==0){
               if(types==null || types.length==0) return m;
           }
        }
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
            MethodDescriptor method = invExpr.getMethod();
            return method.getName().equals("<init>") && !Modifier.isStatic(method.getModifier());
        }catch(ClassCastException ex){
            return false;
        }
    }

    public static boolean isConstructor(MethodNode m) {
        return !isStatic(m.getModifier()) && m.getName().equals("<init>");
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
    
    
    public static boolean hasSetter(ClassNode clazz,FieldNode field){
        ClassType type = Types.getClassType(clazz);
        MethodDescriptor md = MethodUtil.getMethodDescriptor(type.getMethodDescriptors(clazz, true, true), "set" + NameUtil.firstCharToUpperCase(field.getName()),new Type[]{ field.getType()});
        return md !=null;
    }
    
    public static boolean hasGetter(ClassNode clazz,FieldNode field){
        ClassType type = Types.getClassType(clazz);
        MethodDescriptor md = MethodUtil.getMethodDescriptor(type.getMethodDescriptors(clazz, true, true), "get" + NameUtil.firstCharToUpperCase(field.getName()) , null);
        return md != null;
    }

    @Nullable
    public static MethodDescriptor findGetterByPropertyName(ClassType clazz, String propName, ClassNode caller) {
        InvocationResolver methodResolver = new InvocationResolver();
        List<String> nameList = new LinkedList<>();
        nameList.add(propName);
        String ucName = NameUtil.firstCharToUpperCase(propName);
        if (!propName.startsWith("get")) {
            nameList.add("get" + ucName);
        }
        if (!propName.startsWith("is")) {
            nameList.add("is" + ucName);
        }
        MethodDescriptor[] methods = clazz.getMethodDescriptors(caller, true, true);
        for (String name : nameList) {
            List<InvocationResolver.Resolution> res = methodResolver.resolve(methods, name);
            if (res.isEmpty()) {
                continue;
            }
            assert  res.size() == 1;
            return res.get(0).method;
        }
        return null;
    }
    
    public static void createGetter(ClassNode clazz,FieldDescriptor field,int accessModifier){
        String fn = field.getName();
        String getterName = "get" + NameUtil.firstCharToUpperCase(fn);
        boolean isStatic = isStatic(field.getModifier());
        if(isStatic){
            accessModifier |= Modifier.STATIC;
        }
        MethodNode getter = clazz.createMethodNode(field.getType(),getterName,accessModifier);
        //getter.offset = field.offset;
        BlockStmt body = getter.getBody();
        FieldExpr fe;
        ClassReference cr = new ClassReference(clazz);
        if(isStatic){
            fe = new StaticFieldExpr(cr, field);
        }else{
            fe = new ObjectFieldExpr(new ThisExpr(Types.getClassType(clazz)), field);
        }
        body.statements.add(new ReturnStmt(fe));
    }
    
    public static void createSetter(ClassNode clazz,FieldDescriptor field,int accessModifier){
        String fn = field.getName();
        String setterName = "set" + NameUtil.firstCharToUpperCase(fn);
        boolean isStatic = isStatic(field.getModifier());
        if(isStatic){
            accessModifier |= Modifier.STATIC;
        }
        MethodNode setter = clazz.createMethodNode(Types.VOID_TYPE,setterName,accessModifier);
        //setter.offset = field.offset;
        ParameterNode param = setter.createParameter(field.getType(), field.getName());
        BlockStmt body = setter.getBody();
        FieldExpr fe;
        ExprNode paramVal = new ParameterExpr(param);
        ClassReference cr = new ClassReference(clazz);
        if(isStatic){
            fe = new StaticFieldExpr(cr, field);
        }else{
            fe = new ObjectFieldExpr(new ThisExpr(Types.getClassType(clazz)), field);
        }
        body.statements.add(new ExprStmt(new AssignExpr(fe,paramVal)));
    }

    public static ClassNode createClassNodeWithInterfaces(String name,@Nullable ObjectType superType,@Nullable ObjectType... interfaces) {
        ClassNode cn = new ClassNode();
        cn.name = name;
        cn.setSuperType(superType==null ? Types.getRootType() : superType);
        if(interfaces!=null){
            for(ObjectType itf:interfaces) cn.addInterface(itf);
        }
        return cn;
    }
    
    public static ClassNode createArrayAst(String component) {
        ClassNode clazz = new ClassNode();
        clazz.name = component + "[]";
        clazz.setSuperType(Types.getRootType());
        return clazz;
    }
    
    public static ClassNode[] listInnerClasses(ClassNode classNode,boolean recursive){
        List<ClassNode> classes = new LinkedList();
        for(ClassNode ic:classNode.classes){
            classes.add(ic);
            if(recursive){
                classes.addAll(Arrays.asList(listInnerClasses(ic,true)));
            }
        }
        return classes.toArray(new ClassNode[0]);
    }
    
    public static String[] listInnerClassesNames(ClassNode clazz,boolean recursive){
        ClassNode[] classes = listInnerClasses(clazz, recursive);
        String[] names = new String[classes.length];
        for(int i=0;i<classes.length;i++){
            names[i] = classes[i].name;
        }
        return names;
    }
    
    public static void createScriptMainMethodIfNotExists(ClassNode clazz){
        ClassType clazzType = Types.getClassType(clazz);
        MethodDescriptor[] methods = clazzType.getMethodDescriptors(null, false,false);
        Type[] argTypes = new Type[]{Types.getArrayType(Types.getStringClassType())};
        MethodDescriptor mainMethod = MethodUtil.getMethodDescriptor(methods, "main", argTypes);
        if (mainMethod==null) {
            MethodNode m = clazz.createMethodNode(Types.VOID_TYPE, "main", Modifier.PUBLIC + Modifier.STATIC);
            ParameterNode p = m.createParameter(argTypes[0], "arg");
            BlockStmt body = m.getBody();
            try{
                NewObjectExpr newScriptExpr = new NewObjectExpr(clazzType);
                ObjectInvokeExpr invokeExpr = ObjectInvokeExpr.create(newScriptExpr, "run", new ExprNode[]{new ParameterExpr(p)});
                body.statements.add(new ExprStmt(invokeExpr));
            } catch (MethodNotFoundException | AmbiguousMethodException ex) {
                throw Exceptions.unexpectedException(ex);
            }
        }
    }

    public static ExprNode createInitializedArray(Type componentType,ExprNode[] exprs){
        NewArrayExpr ae = new NewArrayExpr(componentType,new ConstExpr(exprs.length));
        if(exprs.length>0){
            Statement[] initStmts = new Statement[exprs.length+2];
            LocalVarNode local = new LocalVarNode(ae.getType(), null);
            initStmts[0] = new VarDeclStmt(local);
            VarExpr arrVar = new VarExpr(local);
            initStmts[1] = new ExprStmt(new AssignExpr(arrVar,ae));
            for(int i=0;i<exprs.length;i++){
                initStmts[i+2] =new ExprStmt(
                        new AssignExpr(
                                new ElementExpr(arrVar, new ConstExpr(i))
                                , exprs[i]
                        )
                );
            }
            return new MultiStmtExpr(Arrays.asList(initStmts), arrVar);
        }else{
            return ae;
        }
    }
    
}
