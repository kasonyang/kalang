package kalang.helper;

import kalang.annotation.Nonnull;
import kalang.annotation.Nullable;
import kalang.annotation.PluginMethod;
import kalang.type.Function1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class CollectionPlugin {

    @Nullable
    @PluginMethod
    public static <T> T find(Collection<T> list, Function1<Boolean, T> handler) {
        for (T it : list) {
            Boolean ret = handler.call(it);
            if (ret != null && ret) {
                return it;
            }
        }
        return null;
    }

    @Nullable
    @PluginMethod
    public static <T> T find(T[] list, Function1<Boolean, T> handler) {
        return find(Arrays.asList(list), handler);
    }

    @Nonnull
    @PluginMethod
    public static <T> List<T> findAll(Collection<T> list, Function1<Boolean, T> handler) {
        List<T> result = new LinkedList<>();
        for (T it : list) {
            Boolean ret = handler.call(it);
            if (ret != null && ret) {
                result.add(it);
            }
        }
        return result;
    }

    @Nonnull
    @PluginMethod
    public static <T> List<T> findAll(T[] list, Function1<Boolean, T> handler) {
        return findAll(Arrays.asList(list), handler);
    }

    @Nonnull
    @PluginMethod
    public static <R, E> List<R> map(Collection<E> list, Function1<R, E> handler) {
        List<R> result = new LinkedList<>();
        for (E it : list) {
            result.add(handler.call(it));
        }
        return result;
    }

    @Nonnull
    @PluginMethod
    public static <R, E> List<R> map(E[] list, Function1<R, E> handler) {
        return map(Arrays.asList(list), handler);
    }

    @PluginMethod
    public static <T> T[] slice(T[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        int length = endIndex - beginIndex;
        T[] res = (T[]) Array.newInstance(array.getClass().getComponentType(), length);
        System.arraycopy(array, beginIndex, res, 0, length);
        return res;
    }

    @PluginMethod
    public static <T> T[] slice(T[] array, int offset) {
        return slice(array, offset, array.length);
    }

    @PluginMethod
    public static <T> T[] concat(T[] array, T[] newEles) {
        int len = array.length + newEles.length;
        T[] res = (T[]) Array.newInstance(array.getClass().getComponentType(), len);
        if (array.length > 0) {
            System.arraycopy(array, 0, res, 0, array.length);
        }
        if (newEles.length > 0) {
            System.arraycopy(newEles, 0, res, array.length, newEles.length);
        }
        return res;
    }

    @PluginMethod
    public static <T> T[] reverse(T[] array) {
        int len = array.length;
        T[] res = (T[]) Array.newInstance(array.getClass().getComponentType(), len);
        for (int i = 0; i < len; i++) {
            res[i] = array[len - 1 - i];
        }
        return res;
    }

    @PluginMethod
    public static String join(Object[] list, String delimiter) {
        StringBuilder sb = new StringBuilder();
        int len = list.length;
        if (len<=0) {
            return "";
        }
        for(int i=0;i<len-1;i++) {
            sb.append(list[i]).append(delimiter);
        }
        sb.append(list[len-1]);
        return sb.toString();
    }

}
