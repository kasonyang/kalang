package kalang.compiler.compile;

import kalang.compiler.AstNotFoundException;
import kalang.compiler.ast.ClassNode;
import kalang.compiler.util.AstUtil;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;

public class AstLoader {
    
    public static final AstLoader BASE_AST_LOADER = new JavaAstLoader();

    @Nonnull
    private final HashMap<String, ClassNode> cachedAsts = new HashMap();

    @Nullable
    private AstLoader parent = null;

    public AstLoader() {

    }

    public AstLoader(@Nonnull AstLoader astLoader) {
        parent = astLoader;
    }

    public void add(@Nonnull ClassNode clazz) {
        cachedAsts.put(clazz.name, clazz);
    }

    @Nonnull
    protected ClassNode findAst(@Nonnull String className) throws AstNotFoundException {
        ClassNode ast = null;
        if(this!=BASE_AST_LOADER){
            ast = BASE_AST_LOADER.findAst(className);
        }
        if (ast == null) {
            throw new AstNotFoundException(className);
        }
        return ast;
    }

    @Nonnull
    public ClassNode loadAst(@Nonnull String className) throws AstNotFoundException {
        ClassNode ast = cachedAsts.get(className);
        if(ast!=null) return ast;
        if(parent!=null){
            try{
                return parent.loadAst(className);
            }catch(AstNotFoundException ex){
                
            }
        }
        if(className.endsWith("[]")){
            String name = className;
            name = name.substring(0,name.length()-2);
            ast = AstUtil.createArrayAst(loadAst(name).name);
        }else{
            ast = findAst(className);
            if(ast==null) throw new AstNotFoundException(className);
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
