package kalang.compiler;

import kalang.AstNotFoundException;
import kalang.ast.ClassNode;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * The class loads ast from java class
 *
 * @author Kason Yang
 */
public class JavaAstLoader extends AstLoader {

    static String ROOT_CLASS = "java.lang.Object";

    private ClassLoader javaClassLoader;

    private Map<String, ClassNode> loadedClasses = new HashMap<>();

    //TODO unused
    private final AstLoader parentAstLoader;

    /**
     * build ast from java class
     *
     * @param clz the java class
     * @return the ast built from java class
     * @throws AstNotFoundException
     */
    @Nonnull
    public ClassNode buildFromClass(@Nonnull Class clz) throws AstNotFoundException {
        ClassNode cn = new JvmClassNode(clz, this);
        loadedClasses.put(clz.getName(), cn);
        return cn;
    }

    public JavaAstLoader(@Nullable AstLoader parentAstLoader, @Nonnull ClassLoader javaClassLoader) {
        Objects.requireNonNull(javaClassLoader);
        this.javaClassLoader = javaClassLoader;
        this.parentAstLoader = parentAstLoader;
    }

    public JavaAstLoader() {
        this(null, JavaAstLoader.class.getClassLoader());
    }
    
    public ClassNode findAst(Class clazz) throws AstNotFoundException{
        String name = clazz.getName();
        ClassNode ast = loadedClasses.get(name);
        if (ast!=null) {
            return ast;
        }
        return buildFromClass(clazz);
    }

    @Override
    protected ClassNode findAst(String className) throws AstNotFoundException {
        if (className == null) {
            System.err.println("warning:trying to null class");
            throw new AstNotFoundException("null");
        }
        ClassNode ast = loadedClasses.get(className);
        if (ast != null) {
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

}
