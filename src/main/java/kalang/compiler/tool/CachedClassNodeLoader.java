package kalang.compiler.tool;

import kalang.compiler.ast.ClassNode;
import kalang.compiler.compile.ClassNodeLoader;
import kalang.lang.Ref;

import java.util.HashMap;
import java.util.Map;

/**
 * @author KasonYang
 */
public class CachedClassNodeLoader implements ClassNodeLoader {

    protected final ClassNodeLoader origin;

    protected final Map<String, Ref<ClassNode>> cache = new HashMap<>();

    public CachedClassNodeLoader(ClassNodeLoader origin) {
        this.origin = origin;
    }

    @Override
    public ClassNode getClassNode(String className) {
        Ref<ClassNode> ref = cache.computeIfAbsent(className, (k) -> new Ref<>(origin.getClassNode(className)));
        return ref.get();
    }

}
