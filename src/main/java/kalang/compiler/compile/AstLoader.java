package kalang.compiler.compile;

import kalang.compiler.ast.ClassNode;
import kalang.compiler.compile.jvm.JvmAstLoader;
import kalang.compiler.util.AstUtil;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;

public class AstLoader {
    
    public static final AstLoader BASE_AST_LOADER = new JvmAstLoader();

    @Nonnull
    private final HashMap<String, ClassNode> cachedAsts = new HashMap();

    @Nullable
    private AstLoader parent = null;

    public AstLoader() {

    }

    public AstLoader(@Nullable AstLoader parent) {
        this.parent = parent;
    }

    public void add(@Nonnull ClassNode clazz) {
        cachedAsts.put(clazz.name, clazz);
    }

    @Nonnull
    protected ClassNode findAst(@Nonnull String className) throws AstNotFoundException {
        throw new AstNotFoundException(className);
    }

    @Nonnull
    public ClassNode loadAst(@Nonnull String className) throws AstNotFoundException {
        ClassNode ast = cachedAsts.get(className);
        if(ast!=null) return ast;
        try{
            if(parent!=null) {
                return parent.loadAst(className);
            }else if (this!=BASE_AST_LOADER) {
                return BASE_AST_LOADER.loadAst(className);
            }
        } catch (AstNotFoundException ex){
            //Do nothing
        }
        if(className.endsWith("[]")){
            String name = className;
            name = name.substring(0,name.length()-2);
            ast = AstUtil.createArrayAst(loadAst(name).name);
        }else{
            ast = findAst(className);
        }
        cachedAsts.put(className, ast);
        return ast;
    }

    @Nullable
    public ClassNode getAst(@Nonnull String className) {
        try {
            return loadAst(className);
        } catch (AstNotFoundException e) {
            return null;
        }
    }


}
