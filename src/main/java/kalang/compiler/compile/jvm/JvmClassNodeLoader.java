package kalang.compiler.compile.jvm;

import kalang.compiler.compile.DefaultClassNodeLoader;
import kalang.compiler.compile.ClassNodeNotFoundException;
import kalang.compiler.ast.ClassNode;
import kalang.compiler.compile.ClassNodeLoader;
import kalang.mixin.CollectionMixin;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * The class loads ast from java class
 *
 * @author Kason Yang
 */
public class JvmClassNodeLoader extends DefaultClassNodeLoader {

    private ClassLoader javaClassLoader;

    private Map<String, ClassNode> loadedClasses = new HashMap<>();

    public JvmClassNodeLoader(@Nullable ClassNodeLoader parent, @Nonnull ClassLoader javaClassLoader) {
        super(parent);
        Objects.requireNonNull(javaClassLoader);
        this.javaClassLoader = javaClassLoader;
    }

    public JvmClassNodeLoader() {
        this(null, JvmClassNodeLoader.class.getClassLoader());
    }

    @Nonnull
    @Override
    protected ClassNode findAst(String className) throws ClassNodeNotFoundException {
        if (className == null) {
            System.err.println("warning:trying to null class");
            throw new ClassNodeNotFoundException("null");
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
            throw new ClassNodeNotFoundException(className);
        }
    }
    
        /**
     * build ast from java class
     *
     * @param clz the java class
     * @return the ast built from java class
     * @throws ClassNodeNotFoundException
     */
    @Nonnull
    private ClassNode buildFromClass(@Nonnull Class<?> clz) throws ClassNodeNotFoundException {
        ClassNode cn = new JvmClassNode(clz, this);
        loadedClasses.put(clz.getName(), cn);
        cn.classes.addAll(Arrays.asList(
                CollectionMixin.map(
                        clz.getClasses(),
                        ClassNode.class,
                        it -> findAst(it.getName())
                )
        ));
        return cn;
    }

}
