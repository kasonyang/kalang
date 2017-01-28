package kalang.compiler;

import java.lang.annotation.Annotation;
import kalang.AstNotFoundException;
import kalang.ast.ClassNode;
import kalang.ast.VarObject;
import kalang.ast.MethodNode;

import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
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
import kalang.core.ArrayType;
import kalang.core.ObjectType;
import kalang.core.GenericType;
import kalang.core.NullableKind;
import kalang.core.ClassType;
import kalang.core.Type;
import kalang.core.Types;
import kalang.core.WildcardType;
import kalang.exception.Exceptions;
import kalang.util.AstUtil;
import kalang.util.MethodUtil;
import kalang.util.ModifierUtil;

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
    
    private ObjectType[] castToClassTypes(Type[] types){
        if(types==null) return null;
        ObjectType[] cts = new ObjectType[types.length];
        for(int i=0;i<types.length;i++){
            cts[i] = (ClassType) types[i];
        }
        return cts;
    }

    /**
     * build ast from java class
     * @param clz the java class
     * @return the ast built from java class
     * @throws AstNotFoundException 
     */
    @Nonnull
    public ClassNode buildFromClass(@Nonnull Class clz) throws AstNotFoundException {
        ClassNode cn = new ClassNode();
        cn.name = clz.getName();
        cn.modifier = clz.getModifiers();
        loadedClasses.put(clz.getName(), cn);
        Map<TypeVariable,GenericType> genericTypes = new HashMap();
        TypeVariable[] typeParameters = clz.getTypeParameters();
        if(typeParameters.length>0){
            for(TypeVariable pt:typeParameters){
                ObjectType[] bounds = castToClassTypes(transType(pt.getBounds(),genericTypes));
                ObjectType superType;
                ObjectType[] interfaces;
                if(bounds!=null && bounds.length>0){
                    if(ModifierUtil.isInterface(bounds[0].getModifier())){
                        superType = Types.getRootType();
                        interfaces = bounds;
                    }else{
                        superType = bounds[0];
                        interfaces = new ObjectType[bounds.length-1];
                        System.arraycopy(bounds,1, interfaces, 0, interfaces.length);
                    }
                }else{
                    superType = Types.getRootType();
                    interfaces = bounds;
                }
                GenericType gt = new GenericType(pt.getName(),superType,interfaces,NullableKind.NONNULL);
                genericTypes.put(pt, gt);
                cn.declareGenericType(gt);
            }
        }
        java.lang.reflect.Type superType = clz.getGenericSuperclass();
        Class superClazz = clz.getSuperclass();
        if (superType != null) {
            cn.superType = (ObjectType)getType(superType, genericTypes,superClazz,NullableKind.NONNULL);
        }
        java.lang.reflect.Type[] typeInterfaces = clz.getGenericInterfaces();
        Class[] clzInterfaces = clz.getInterfaces();
        if(clzInterfaces != null){
            for(int i=0;i<clzInterfaces.length;i++){
                cn.addInterface((ObjectType)getType(typeInterfaces[i], genericTypes,clzInterfaces[i],NullableKind.NONNULL));
            }
        }
        List<Executable> methods = new LinkedList();
        methods.addAll(Arrays.asList(clz.getDeclaredMethods()));
        methods.addAll(Arrays.asList(clz.getDeclaredConstructors()));
        for (Executable m : methods) {
            NullableKind nullable = getNullable(m.getAnnotations());
            Type mType;
            String mName;
            int mModifier;
            if (m instanceof Method) {
                mType =getType(((Method) m).getGenericReturnType(),genericTypes,((Method)m).getReturnType(),nullable);
                mName = m.getName();
                mModifier = m.getModifiers();
            } else if (m instanceof Constructor) {
                mName = "<init>";
                mType = Types.VOID_TYPE;// getType(clz);
                mModifier = m.getModifiers();// | Modifier.STATIC;
            }else{
                throw Exceptions.unexceptedValue(m);
            }
            MethodNode methodNode = cn.createMethodNode(mType,mName,mModifier);
            for (Parameter p : m.getParameters()) {
                NullableKind pnullable = getNullable(p.getAnnotations());
                methodNode.createParameter(getType(p.getParameterizedType(),genericTypes,p.getType(),pnullable) , p.getName());
            }
            for (Class e : m.getExceptionTypes()) {
                methodNode.addExceptionType(getType(e,genericTypes,e,NullableKind.NONNULL));
            }
        }
        for (Field f : clz.getFields()) {
            NullableKind nullable = getNullable(f.getAnnotations());
            FieldNode fn = cn.createField(getType(f.getGenericType(),genericTypes,f.getType(),nullable),f.getName(),f.getModifiers());
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
    
    //TODO why transType could be null?
    @Nullable
    private Type transType(java.lang.reflect.Type t,Map<TypeVariable,GenericType> genericTypes) throws AstNotFoundException{
        if(t instanceof TypeVariable){
            GenericType vt = genericTypes.get((TypeVariable)t);
            //FIXME it may be null if TypeVariable comes from method
            if(vt!=null) return vt;
            return null;
        }else if(t instanceof java.lang.reflect.ParameterizedType){
            java.lang.reflect.ParameterizedType pt = (java.lang.reflect.ParameterizedType) t;
            Type rawType = transType(pt.getRawType(),genericTypes);
            if(!(rawType instanceof ObjectType)) return null;
            java.lang.reflect.Type[] typeArgs = pt.getActualTypeArguments();
            Type[] gTypes = transType(typeArgs,genericTypes);
            if(gTypes==null) return null;
            return Types.getClassType(((ObjectType) rawType).getClassNode(), gTypes);
        }else if(t instanceof java.lang.reflect.WildcardType){
            java.lang.reflect.WildcardType wt = (java.lang.reflect.WildcardType) t;
            Type[] upperBounds = transType(wt.getUpperBounds(),genericTypes);
            if(upperBounds==null) return null;
            Type[] lowerBounds = transType(wt.getLowerBounds(),genericTypes);
            if(lowerBounds==null) return null;
            return new WildcardType(upperBounds,lowerBounds);
        }else if(t instanceof GenericArrayType){
            GenericArrayType gt = (GenericArrayType) t;
            Type ct = transType(gt.getGenericComponentType(),genericTypes);
            if(ct==null) return null;
            return Types.getArrayType(ct,NullableKind.NONNULL);
        }else if(t instanceof Class){
            Class type = (Class) t;
            if(type.isPrimitive()){
                return Types.getPrimitiveType(type.getTypeName());
            }else if(type.isArray()){
                Type ct = transType(type.getComponentType(),genericTypes);
                if(ct==null) return null;
                return Types.getArrayType(ct);
            }else{
                return Types.getClassType(findAst(type.getName()));
            }
        }else{
            return null;
        }
    }

    private Type getType(java.lang.reflect.Type t,Map<TypeVariable,GenericType> genericTypes,Class defaultClass,NullableKind nullable) throws AstNotFoundException {
        Type type = this.transType(t, genericTypes);
        if(type==null){
            type = transType(defaultClass,genericTypes);
        }
        //TODO support nullable for other type
        if(type instanceof ClassType){
            return Types.getClassType((ClassType)type, nullable);
        }else{
            return type;
        }
    }

    private NullableKind getNullable(Annotation[] annotations) {
        for(Annotation a:annotations){
            Class<? extends Annotation> at = a.annotationType();
            String simpleName = at.getSimpleName().toLowerCase();
            switch(simpleName){
                case "nullable":
                case "nullallowed":
                    return NullableKind.NULLABLE;
                case "nonnull":
                case "notnull":
                    return NullableKind.NONNULL;
            }
        }
        return NullableKind.UNKNOWN;
    }

}
