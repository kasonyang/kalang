package kalang.compiler;

import java.util.HashMap;

import jast.ast.ClassNode;
import jast.ast.VarObject;
import java.lang.reflect.Modifier;
import kalang.core.Types;

public class AstLoader {
    
    public static final AstLoader BASE_AST_LOADER = new JavaAstLoader();

    HashMap<String, ClassNode> asts = new HashMap();

    private AstLoader parent;

    public AstLoader() {

    }

    public AstLoader(AstLoader astLoader) {
        parent = astLoader;
    }

    public void add(ClassNode clazz) {
        asts.put(clazz.name, clazz);
    }

    protected ClassNode findAst(String className) throws AstNotFoundException {
        ClassNode ast = asts.get(className);
        if(ast==null && this!=BASE_AST_LOADER){
            ast = BASE_AST_LOADER.findAst(className);
        }
        if (ast == null) {
            if (parent != null) {
                return parent.findAst(className);
            } else {
                throw new AstNotFoundException(className);
            }
        }
        return ast;
    }

    public ClassNode loadAst(String className) throws AstNotFoundException {
        boolean isArray = false;
        String name = className;
        if(name.endsWith("[]")){
            isArray = true;
            name = name.substring(0,name.length()-2);
        }
        ClassNode ast = findAst(name);
        if(ast==null) throw new AstNotFoundException(className);
        if(isArray){
            return createArrayAst(ast);
        }
        return ast;
    }

    public ClassNode getAst(String className) {
        try {
            return loadAst(className);
        } catch (AstNotFoundException e) {
            return null;
        }
    }

    private ClassNode createArrayAst(ClassNode ast) {
        ClassNode clazz = ClassNode.create();
        clazz.fields.add(new VarObject(Modifier.PUBLIC,Types.INT_TYPE, "length", null));
        clazz.name = ast.name + "[]";
        clazz.isArray = true;
        if(ast.parent!=null){
            clazz.parent = createArrayAst(ast.parent);
        }
        return clazz;
    }

}
