package kalang.compiler.util;

import kalang.compiler.ast.*;
import kalang.compiler.compile.OffsetRange;
import kalang.compiler.compile.semantic.AmbiguousMethodException;
import kalang.compiler.compile.semantic.InvocationResolver;
import kalang.compiler.compile.semantic.MethodNotFoundException;
import kalang.compiler.core.*;
import kalang.mixin.CollectionMixin;

import javax.annotation.Nullable;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AstUtil {

    public static boolean isNonStaticInnerClass(ClassNode clazz) {
        return clazz.enclosingClass != null && !Modifier.isStatic(clazz.getModifier()) && !Modifier.isInterface(clazz.getModifier());
    }
    
    public static boolean createEmptyConstructor(ClassNode clazzNode){
        ObjectType supType = clazzNode.getSuperType();
        if (supType == null) {
            throw new RuntimeException("super type is null:" + clazzNode.getName());
        }
        MethodDescriptor[] constructors = supType.getConstructorDescriptors(clazzNode);
        MethodDescriptor m = MethodUtil.getMethodDescriptor(constructors, "<init>", null);
        if (m != null) {
            BlockStmt body = new BlockStmt();
            MethodNode mm = clazzNode.createMethodNode(Types.VOID_TYPE, m.getName(), m.getModifier(), body);
            for (Type e : m.getExceptionTypes()) mm.addExceptionType(e);
            ParameterDescriptor[] pds = m.getParameterDescriptors();
            for (ParameterDescriptor pd : pds) {
                mm.createParameter(pd.getType(), pd.getName(), pd.getModifier());
            }
            ParameterNode[] parameters = mm.getParameters();
            ExprNode[] params = new ExprNode[parameters.length];
            for (int i = 0; i < params.length; i++) {
                params[i] = new VarExpr(parameters[i]);
            }
            body.statements.add(
                    new ExprStmt(
                            new ObjectInvokeExpr(
                                    new SuperExpr(clazzNode),
                                    m,
                                    params)
                    )
            );
            mapOffset(mm, OffsetRange.NONE, true);
            return true;
        } else {
            return false;
        }
    }

    public static <T extends AstNode> T mapOffset(T node,OffsetRange offsetRange, boolean recursive) {
        if (node.offset == null) {
            node.offset = offsetRange;
        }
        if (recursive) {
            List<AstNode> children = node.getChildren();
            for (AstNode c: children) {
                mapOffset(c, offsetRange, true);
            }
        }
        return node;
    }
    
    public static boolean containsConstructor(ClassNode clazz){
        MethodNode[] dms = clazz.getDeclaredMethodNodes();
        for(MethodNode m:dms){
            if("<init>".equals(m.getName())) return true;
        }
        return false;
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
        ExprStmt stmt = new ExprStmt(
                ObjectInvokeExpr.create(thisExpr, "<init>", null, clazz)
        );
        AstUtil.mapOffset(stmt, OffsetRange.NONE, true);
        return stmt;
    }

    public static boolean hasSetter(ClassNode clazz,FieldNode field){
        ClassType type = Types.getClassType(clazz);
        return !findSetterByPropertyName(type, field.getName(), field.getType(), clazz).isEmpty();
    }
    
    public static boolean hasGetter(ClassNode clazz,FieldNode field){
        ClassType type = Types.getClassType(clazz);
        return findGetterByPropertyName(type, field.getName(), clazz) != null;
    }

    public static List<MethodDescriptor> findSetterByPropertyName(ClassType clazz, String propName,Type type, ClassNode caller) {
        InvocationResolver methodResolver = new InvocationResolver();
        String setterName = "set" + NameUtil.firstCharToUpperCase(propName);
        MethodDescriptor[] methods = CollectionMixin.findAll(
                clazz.getMethodDescriptors(caller, setterName, true, true),
                m -> !ModifierUtil.isStatic(m.getModifier())
        );
        VarExpr setterArg = new VarExpr(new LocalVarNode(type, null));
        List<InvocationResolver.Resolution> res = methodResolver.resolveArgs(methods, setterArg);
        return CollectionMixin.map(res, r -> r.method);
    }

    @Nullable
    public static MethodDescriptor findGetterByPropertyName(ClassType clazz, String propName, ClassNode caller) {
        List<String> nameList = new LinkedList<>();
        nameList.add(propName);
        String ucName = NameUtil.firstCharToUpperCase(propName);
        if (!propName.startsWith("get")) {
            nameList.add("get" + ucName);
        }
        if (!propName.startsWith("is")) {
            nameList.add("is" + ucName);
        }
        for (String name : nameList) {
            MethodDescriptor[] methods = CollectionMixin.findAll(
                    clazz.getMethodDescriptors(caller, name,true, true),
                    m -> !ModifierUtil.isStatic(m.getModifier()) && m.getParameterDescriptors().length == 0
            );
            if (methods.length == 0) {
                continue;
            }
            assert methods.length == 1;
            return methods[0];
        }
        return null;
    }
    
    public static void createGetter(ClassNode clazz,FieldNode field,int accessModifier){
        String fn = field.getName();
        Type fieldType = field.getType();
        String getterPrefix = Types.BOOLEAN_TYPE.equals(fieldType) ? "is" : "get";
        String getterName = getterPrefix + NameUtil.firstCharToUpperCase(fn);
        boolean isStatic = isStatic(field.getModifier());
        if(isStatic){
            accessModifier |= Modifier.STATIC;
        }
        BlockStmt body = new BlockStmt();
        MethodNode getter = clazz.createMethodNode(field.getType(), getterName, accessModifier, body);
        FieldExpr fe;
        ClassReference cr = new ClassReference(clazz);
        if(isStatic){
            fe = new StaticFieldExpr(cr, field);
        }else{
            fe = new ObjectFieldExpr(new ThisExpr(Types.getClassType(clazz)), field);
        }
        body.statements.add(new ReturnStmt(fe));
        AstUtil.mapOffset(getter, field.offset, true);
    }
    
    public static void createSetter(ClassNode clazz,FieldNode field,int accessModifier){
        String fn = field.getName();
        String setterName = "set" + NameUtil.firstCharToUpperCase(fn);
        boolean isStatic = isStatic(field.getModifier());
        if(isStatic){
            accessModifier |= Modifier.STATIC;
        }
        BlockStmt body = new BlockStmt();
        MethodNode setter = clazz.createMethodNode(Types.VOID_TYPE,setterName,accessModifier, body);
        ParameterNode param = setter.createParameter(field.getType(), field.getName());
        FieldExpr fe;
        ExprNode paramVal = new VarExpr(param);
        ClassReference cr = new ClassReference(clazz);
        if(isStatic){
            fe = new StaticFieldExpr(cr, field);
        }else{
            fe = new ObjectFieldExpr(new ThisExpr(Types.getClassType(clazz)), field);
        }
        body.statements.add(new ExprStmt(new AssignExpr(fe,paramVal)));
        AstUtil.mapOffset(setter, field.offset, true);
    }

    public static ClassNode createClassNodeWithInterfaces(String name,@Nullable ObjectType superType,@Nullable ObjectType... interfaces) {
        ClassNode cn = new ClassNode();
        cn.setName(name);
        cn.setSuperType(superType==null ? Types.getRootType() : superType);
        if(interfaces!=null){
            for(ObjectType itf:interfaces) cn.addInterface(itf);
        }
        return cn;
    }
    
    public static ClassNode createArrayAst(String component) {
        ClassNode clazz = new ClassNode();
        clazz.setName(component + "[]");
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
            names[i] = classes[i].getName();
        }
        return names;
    }
    
    public static void createScriptMainMethodIfNotExists(ClassNode clazz){
        ClassType clazzType = Types.getClassType(clazz);
        MethodDescriptor[] methods = clazzType.getMethodDescriptors(null, false,false);
        Type[] argTypes = new Type[]{Types.getArrayType(Types.getStringClassType())};
        MethodDescriptor mainMethod = MethodUtil.getMethodDescriptor(methods, "main", argTypes);
        if (mainMethod==null) {
            BlockStmt body = new BlockStmt();
            MethodNode m = clazz.createMethodNode(Types.VOID_TYPE, "main", Modifier.PUBLIC + Modifier.STATIC, body);
            ParameterNode p = m.createParameter(argTypes[0], "arg");
            try{
                NewObjectExpr newScriptExpr = new NewObjectExpr(clazzType);
                ObjectInvokeExpr invokeExpr = ObjectInvokeExpr.create(newScriptExpr, "run", new ExprNode[]{new VarExpr(p)});
                body.statements.add(new ExprStmt(invokeExpr));
            } catch (MethodNotFoundException | AmbiguousMethodException ex) {
                throw Exceptions.unexpectedException(ex);
            }
            AstUtil.mapOffset(m, OffsetRange.NONE, true);
        }
    }

    public static ExprNode createInitializedArray(Type componentType,ExprNode[] exprs){
        NewArrayExpr ae = new NewArrayExpr(componentType,new ConstExpr(exprs.length));
        if(exprs.length>0){
            Statement[] initStmts = new Statement[exprs.length+2];
            LocalVarNode local = new LocalVarNode(ae.getType(), null);
            initStmts[0] = new VarDeclStmt(local);
            initStmts[1] = new ExprStmt(new AssignExpr(new VarExpr(local),ae));
            for(int i=0;i<exprs.length;i++){
                initStmts[i+2] =new ExprStmt(
                        new AssignExpr(
                                new ElementExpr(new VarExpr(local), new ConstExpr(i))
                                , exprs[i]
                        )
                );
            }
            return new MultiStmtExpr(Arrays.asList(initStmts), new VarExpr(local));
        }else{
            return ae;
        }
    }
    
}
