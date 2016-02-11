package kalang.compiler;

import jast.ast.*;

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
import kalang.core.Type;
import kalang.core.Types;

@groovy.transform.TypeChecked
public class JavaAstLoader extends AstLoader {

    static String ROOT_CLASS = "java.lang.Object";
    
    private ClassLoader javaClassLoader;
    
    private Map<String,ClassNode> loadedClasses  =new HashMap<>();

    public ClassNode buildFromClass(Class clz) throws AstNotFoundException {
        ClassNode cn = ClassNode.create();
        cn.name = clz.getName();
        loadedClasses.put(clz.getName(), cn);
        Class superClass = clz.getSuperclass();
        if (superClass != null) {
            cn.parent = findAst(superClass.getName());
        } else if (!cn.name.equals(ROOT_CLASS)) {
            cn.parent = findAst(ROOT_CLASS);
        }
        List<Executable> methods = new LinkedList();
        methods.addAll(Arrays.asList(clz.getMethods()));
        methods.addAll(Arrays.asList(clz.getConstructors()));
        for (Executable m : methods) {
            MethodNode methodNode = MethodNode.create();
            for (Parameter p : m.getParameters()) {
                VarObject param = new VarObject();
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
                methodNode.type = getType(clz);
                methodNode.modifier = m.getModifiers() | Modifier.STATIC;
            }
            cn.methods.add(methodNode);
            methodNode.body = null;
            for (Class e : m.getExceptionTypes()) {
                methodNode.exceptionTypes.add(getType(e));
            }
        }
        for (Field f : clz.getFields()) {
            VarObject fn = new VarObject();
            fn.name = f.getName();
            fn.type =getType(f.getType());
            fn.modifier = f.getModifiers();
            cn.fields.add(fn);
        }
        return cn;
    }

    public JavaAstLoader(ClassLoader javaClassLoader) {
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
