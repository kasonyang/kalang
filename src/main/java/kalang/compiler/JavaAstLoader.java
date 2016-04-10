package kalang.compiler;

import kalang.ast.ClassNode;
import kalang.ast.VarObject;
import kalang.ast.MethodNode;

import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import kalang.ast.FieldNode;
import kalang.ast.ParameterNode;
import kalang.core.Type;
import kalang.core.Types;
import kalang.util.AstUtil;

/**
 * The class loads ast from java class
 * 
 * @author Kason Yang <i@kasonyang.com>
 */
public class JavaAstLoader extends AstLoader {

    static String ROOT_CLASS = "java.lang.Object";
    
    private ClassLoader javaClassLoader;
    
    private Map<String,ClassNode> loadedClasses  =new HashMap<>();
    
    private static String getMethodDescriptor(Executable m){
        Class<?>[] pts = m.getParameterTypes();
        String[] types = new String[pts.length];
        for(int i=0;i<types.length;i++){
            types[i] = pts[i].getName();
        }
        String returnType = "V";
        if(m instanceof Method){
            returnType = ((Method)m).getReturnType().getName();
        }
        return AstUtil.getMethodDescriptor(m.getName(),returnType, types);
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
        loadedClasses.put(clz.getName(), cn);
        Class superClass = clz.getSuperclass();
        if (superClass != null) {
            cn.parent = findAst(superClass.getName());
        } else if (!cn.name.equals(ROOT_CLASS)) {
            cn.parent = findAst(ROOT_CLASS);
        }
        Class[] clzInterfaces = clz.getInterfaces();
        if(clzInterfaces != null){
            for(Class itf:clzInterfaces){
                cn.interfaces.add(findAst(itf.getName()));
            }
        }
        List<Executable> methods = new LinkedList();
        methods.addAll(Arrays.asList(clz.getDeclaredMethods()));
        methods.addAll(Arrays.asList(clz.getDeclaredConstructors()));
        Class[] itfs = clz.getInterfaces();
        //TODO should default method of  interface becomes a declared method
        //MethodNode[] mds = methods.toArray(new MethodNode[0]);
        List<String> declaredMethods = new LinkedList<>();
        for(Executable m:methods){
            declaredMethods.add(getMethodDescriptor(m));
        }
        if(itfs!=null){
            for(Class i:itfs){
                for(Method m:i.getMethods()){
                    if(
                            m.isDefault() 
                            && !declaredMethods.contains(getMethodDescriptor(m))){
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
                param.type = getType(p.getType());
                methodNode.parameters.add(param);
            }
            if (m instanceof Method) {
                methodNode.type =getType(((Method) m).getReturnType());
                methodNode.name = m.getName();
                methodNode.modifier = m.getModifiers();
            } else if (m instanceof Constructor) {
                methodNode.name = "<init>";
                methodNode.type = Types.VOID_TYPE;// getType(clz);
                methodNode.modifier = m.getModifiers();// | Modifier.STATIC;
            }
            methodNode.body = null;
            for (Class e : m.getExceptionTypes()) {
                methodNode.exceptionTypes.add(getType(e));
            }
        }
        for (Field f : clz.getFields()) {
            FieldNode fn = cn.createField();
            fn.name = f.getName();
            fn.type =getType(f.getType());
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

    private Type getType(Class<?> type) throws AstNotFoundException {
        if(type.isPrimitive()){
            return Types.getPrimitiveType(type.getTypeName());
        }else if(type.isArray()){
            return Types.getArrayType(getType(type.getComponentType()));
        }else{
            return Types.getClassType(findAst(type.getName()));
        }
    }

}
