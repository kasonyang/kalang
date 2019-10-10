package kalang.compiler.util;

import kalang.compiler.ast.ClassNode;

import javax.annotation.Nullable;
import java.lang.reflect.Modifier;
import java.util.Objects;

/**
 *
 * @author Kason Yang
 */
public class AccessUtil {

    public static boolean isAccessible(int targetModifier, ClassNode targetOwner, @Nullable ClassNode caller) {
        Objects.requireNonNull(targetOwner);
        if (Modifier.isPublic(targetModifier)) {
            return true;
        }
        if (caller == null) {
            return false;
        }
        if (targetOwner.equals(caller)) {
            return true;
        }
        if (!Modifier.isPrivate(targetModifier)) {
            return InheritanceUtil.isInSamePackage(caller, targetOwner) || InheritanceUtil.isSubclassOf(caller, targetOwner);
        }
        return false;
    }

}
