package kalang.compiler.tool;

import kalang.compiler.compile.KalangSource;
import kalang.compiler.compile.SourceLoader;
import kalang.lang.Ref;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author KasonYang
 */
public class CachedSourceLoader implements SourceLoader {

    protected final Map<String, Ref<KalangSource>> cache = new HashMap<>();

    protected final SourceLoader origin;

    public CachedSourceLoader(SourceLoader origin) {
        this.origin = origin;
    }


    @Nullable
    @Override
    public KalangSource loadSource(@Nonnull String className) {
        Ref<KalangSource> ref = cache.computeIfAbsent(className, k -> new Ref<>(origin.loadSource(className)));
        return ref.get();
    }
}
