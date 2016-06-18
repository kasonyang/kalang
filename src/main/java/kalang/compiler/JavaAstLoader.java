package kalang.compiler;

import kalang.AstNotFoundException;
import kalang.ast.ClassNode;
import kalang.ast.VarObject;
import kalang.ast.MethodNode;

import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import kalang.ast.FieldNode;
import kalang.ast.ParameterNode;
import kalang.core.ClassType;
import kalang.core.GenericType;
import kalang.core.ParameterizedType;
import kalang.core.Type;
import kalang.core.Types;
import kalang.exception.Exceptions;
import kalang.util.AstUtil;
import kalang.util.MethodUtil;

/**
 * The class loads ast from java class
 * 
 * @author Kason Yang
 */
public class JavaAstLoader extends AstLoader {

    static String ROOT_CLASS = "java.lang.Object";
    
    private ClassLoader javaClassLoader;
    
    private Map<String,ClassNode> loadedClasses  =new HashMap<>();
    
    private static String getMethodDeclarationKey(Executable m){
        Class<?>[] pts = m.getParameterTypes();
        String[] types = new String[pts.length];
        for(int i=0;i<types.length;i++){
            types[i] = pts[i].getName();
        }
        return MethodUtil.getDeclarationKey(m.getName(), types);
    }

    /**
     * build ast from java class
     * @param clz the java class
     * @return the ast built from java class
     * @throws AstNotFoundException 
     */
    @Nonnull
    public ClassNode buildFromClass(@Nonnull Class clz) throws AstNotFoundException {
        ClassNode cn = ClassNode.create();
        cn.name = clz.getName();
        cn.isInterface = clz.isInterface();
        loadedClasses.put(clz.getName(), cn);
        Map<TypeVariable,GenericType> genericTypes = new HashMap();
        TypeVariable[] typeParameters = clz.getTypeParameters();
        if(typeParameters.length>0){
            for(TypeVariable pt:typeParameters){
                GenericType gt = new GenericType(pt.getName());
                genericTypes.put(pt, gt);
                cn.declareGenericType(gt);
            }
        }
        java.lang.reflect.Type superType = clz.getGenericSuperclass();
        Class superClazz = clz.getSuperclass();
        if (superType != null) {
            cn.superType = (ClassType)getType(superType, genericTypes,superClazz);
        }
        java.lang.reflect.Type[] typeInterfaces = clz.getGenericInterfaces();
        Class[] clzInterfaces = clz.getInterfaces();
        if(clzInterfaces != null){
            for(int i=0;i<clzInterfaces.length;i++){
                cn.interfaces.add((ClassType)getType(typeInterfaces[i], genericTypes,clzInterfaces[i]));
            }
        }
        List<Executable> methods = new LinkedList();
        methods.addAll(Arrays.asList(clz.getDeclaredMethods()));
        methods.addAll(Arrays.asList(clz.getDeclaredConstructors()));
        Class[] itfs = clz.getInterfaces();
        //TODO should default method of  interface becomes a declared method
        List<String> declaredMethods = new LinkedList<>();
        for(Executable m:methods){
            declaredMethods.add(getMethodDeclarationKey(m));
        }
        if(itfs!=null){
            for(Class i:itfs){
                for(Method m:i.getMethods()){
                    if(
                            m.isDefault() 
                            && !declaredMethods.contains(getMethodDeclarationKey(m))){
                        methods.add(m);
                    }
                }
            }
        }
        for (Executable m : methods) {
            MethodNode methodNode = cn.createMethodNode();
            for (Parameter p : m.getParameters()) {
                ParameterNode param = ParameterNode.create(methodNode);
                param.name = p.getName();
                param.type = getType(p.getParameterizedType(),genericTypes,p.getType());
                methodNode.parameters.add(param);
            }
            if (m instanceof Method) {
                methodNode.type =getType(((Method) m).getGenericReturnType(),genericTypes,((Method)m).getReturnType());
                methodNode.name = m.getName();
                methodNode.modifier = m.getModifiers();
            } else if (m instanceof Constructor) {
                methodNode.name = "<init>";
                methodNode.type = Types.VOID_TYPE;// getType(clz);
                methodNode.modifier = m.getModifiers();// | Modifier.STATIC;
            }
            methodNode.body = null;
            for (Class e : m.getExceptionTypes()) {
                methodNode.exceptionTypes.add(getType(e,genericTypes,e));
            }
        }
        for (Field f : clz.getFields()) {
            FieldNode fn = cn.createField();
            fn.name = f.getName();
            fn.type =getType(f.getGenericType(),genericTypes,f.getType());
            fn.modifier = f.getModifiers();
        }
        return cn;
    }

    public JavaAstLoader(@Nonnull ClassLoader javaClassLoader) {
        this.javaClassLoader = javaClassLoader;
    }

    public JavaAstLoader() {
        javaClassLoader = this.getClass().getClassLoader();
    }
    
    

    @Override
    protected ClassNode findAst(String className) throws AstNotFoundException {
        if(className==null){
            System.err.println("warning:trying to null class");
            throw new AstNotFoundException("null");
        }
        ClassNode ast = loadedClasses.get(className);
        if(ast!=null){
            return ast;
        }
        try {
            return super.findAst(className);
        } catch (AstNotFoundException e) {
            try {
                Class clz = javaClassLoader.loadClass(className);
                ast = buildFromClass(clz);
                return ast;
            } catch (ClassNotFoundException ex) {
                throw e;
            }
        }
    }
    
    @Nullable
    private Type[] transType(java.lang.reflect.Type[] ts,Map<TypeVariable,GenericType> genericTypes) throws AstNotFoundException{
        Type[] ret = new Type[ts.length];
        for(int i=0;i<ret.length;i++){
            ret[i] = transType(ts[i],genericTypes);
            if(ret[i]==null) return null;
        }
        return ret;
    }
    
    @Nullable
    private Type transType(java.lang.reflect.Type t,Map<TypeVariable,GenericType> genericTypes) throws AstNotFoundException{
        if(t instanceof TypeVariable){
            GenericType vt = genericTypes.get((TypeVariable)t);
            //FIXME why it maybe null?
            if(vt!=null) return vt;
            return null;
        }else if(t instanceof java.lang.reflect.ParameterizedType){
            java.lang.reflect.ParameterizedType pt = (java.lang.reflect.ParameterizedType) t;
            Type rawType = transType(pt.getRawType(),genericTypes);
            if(!(rawType instanceof ClassType)) return null;
            java.lang.reflect.Type[] typeArgs = pt.getActualTypeArguments();
            Type[] gTypes = transType(typeArgs,genericTypes);
            if(gTypes==null) return null;
            return new ParameterizedType((ClassType) rawType, gTypes);
        }else if(t instanceof java.lang.reflect.WildcardType){
            java.lang.reflect.WildcardType wt = (java.lang.reflect.WildcardType) t;
            Type[] upperBounds = transType(wt.getUpperBounds(),genericTypes);
            if(upperBounds==null) return null;
            Type[] lowerBounds = transType(wt.getLowerBounds(),genericTypes);
            if(lowerBounds==null) return null;
            return Types.getWildcartType(upperBounds,lowerBounds);
        }else if(t instanceof Class){
            Class type = (Class) t;
            if(type.isPrimitive()){
                return Types.getPrimitiveType(type.getTypeName());
            }else if(type.isArray()){
                return Types.getArrayType(getType(type.getComponentType(),genericTypes,type.getComponentType()));
            }else{
                return Types.getClassType(findAst(type.getName()));
            }
        }else{
            return null;
        }
    }

    private Type getType(java.lang.reflect.Type t,Map<TypeVariable,GenericType> genericTypes,Class defaultClass) throws AstNotFoundException {
        Type type = this.transType(t, genericTypes);
        return type==null ? transType(defaultClass,genericTypes) : type;
    }

}
