package kalang.mixin;

import kalang.annotation.MixinMethod;
import kalang.type.Function1;

/**
 * @author KasonYang
 */
public class ObjectMixin {

    @MixinMethod
    public static <T,R> R cast(T obj, Function1<R,T> handler) {
        return handler.call(obj);
    }

}
