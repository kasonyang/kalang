package kalang.compiler.compile;

import kalang.compiler.ast.ClassNode;
import kalang.compiler.compile.jvm.JvmClassNodeLoader;
import kalang.compiler.util.AstUtil;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;

public class DefaultClassNodeLoader implements ClassNodeLoader {
    
    public static final ClassNodeLoader BASE_CLASS_NODE_LOADER = new JvmClassNodeLoader();

    @Nonnull
    private final HashMap<String, ClassNode> cachedAsts = new HashMap();

    @Nullable
    private ClassNodeLoader parent = null;

    public DefaultClassNodeLoader() {

    }

    public DefaultClassNodeLoader(@Nullable ClassNodeLoader parent) {
        this.parent = parent;
    }

    @Nonnull
    protected ClassNode findAst(@Nonnull String className) throws ClassNodeNotFoundException {
        throw new ClassNodeNotFoundException(className);
    }

    @Nonnull
    @Override
    public ClassNode loadClassNode(@Nonnull String className) throws ClassNodeNotFoundException {
        ClassNode ast = cachedAsts.get(className);
        if(ast!=null) return ast;
        try{
            if(parent!=null) {
                return parent.loadClassNode(className);
            }else if (this!= BASE_CLASS_NODE_LOADER) {
                return BASE_CLASS_NODE_LOADER.loadClassNode(className);
            }
        } catch (ClassNodeNotFoundException ex){
            //Do nothing
        }
        if(className.endsWith("[]")){
            String name = className;
            name = name.substring(0,name.length()-2);
            ast = AstUtil.createArrayAst(loadClassNode(name).getName());
        }else{
            ast = findAst(className);
        }
        cachedAsts.put(className, ast);
        return ast;
    }

    @Nullable
    @Override
    public ClassNode getClassNode(@Nonnull String className) {
        try {
            return loadClassNode(className);
        } catch (ClassNodeNotFoundException e) {
            return null;
        }
    }


}
