package kalang.compiler.compile.jvm;

import kalang.compiler.compile.AstNotFoundException;
import kalang.compiler.ast.ClassNode;
import kalang.compiler.compile.AstLoader;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * The class loads ast from java class
 *
 * @author Kason Yang
 */
public class JvmAstLoader extends AstLoader {

    private ClassLoader javaClassLoader;

    private Map<String, ClassNode> loadedClasses = new HashMap<>();

    public JvmAstLoader(@Nullable AstLoader parentAstLoader, @Nonnull ClassLoader javaClassLoader) {
        super(parentAstLoader);
        Objects.requireNonNull(javaClassLoader);
        this.javaClassLoader = javaClassLoader;
    }

    public JvmAstLoader() {
        this(null, JvmAstLoader.class.getClassLoader());
    }

    @Nonnull
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
            Class clz = javaClassLoader.loadClass(className);
            ast = buildFromClass(clz);
            return ast;
        } catch (ClassNotFoundException ex) {
            throw new AstNotFoundException(className);
        }
    }
    
        /**
     * build ast from java class
     *
     * @param clz the java class
     * @return the ast built from java class
     * @throws AstNotFoundException
     */
    @Nonnull
    private ClassNode buildFromClass(@Nonnull Class clz) throws AstNotFoundException {
        ClassNode cn = new JvmClassNode(clz, this);
        loadedClasses.put(clz.getName(), cn);
        return cn;
    }

}
