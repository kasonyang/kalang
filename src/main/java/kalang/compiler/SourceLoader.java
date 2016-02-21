
package kalang.compiler;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public interface SourceLoader {
    
    @Nullable
    String loadSource(@Nonnull String className);
    
}
