package kalang.mixin;

import kalang.annotation.Nonnull;
import kalang.annotation.Nullable;
import kalang.annotation.MixinMethod;
import kalang.type.Function1;

import java.lang.reflect.Array;
import java.util.*;

public class CollectionMixin {

    @Nullable
    @MixinMethod
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
    @MixinMethod
    public static <T> T find(T[] list, Function1<Boolean, T> handler) {
        return find(Arrays.asList(list), handler);
    }

    @MixinMethod
    public static <T> int findIndex(Collection<T> list, Function1<Boolean,T> handler) {
        int index = 0;
        for (T it : list) {
            Boolean ret = handler.call(it);
            if (ret != null && ret) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @MixinMethod
    public static <T> int findIndex(T[] list, Function1<Boolean,T> handler) {
        return findIndex(Arrays.asList(list), handler);
    }

    @Nonnull
    @MixinMethod
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
    @MixinMethod
    public static <T> T[] findAll(T[] list, Function1<Boolean, T> handler) {
        return findAll(Arrays.asList(list), handler).toArray((T[])Array.newInstance(list.getClass().getComponentType(),0));
    }

    @Nonnull
    @MixinMethod
    public static <R, E> List<R> map(Collection<E> list, Function1<R, E> handler) {
        List<R> result = new LinkedList<>();
        for (E it : list) {
            result.add(handler.call(it));
        }
        return result;
    }

    @Nonnull
    @MixinMethod
    public static <R, E> List<R> map(E[] list, Function1<R, E> handler) {
        return map(Arrays.asList(list), handler);
    }

    @Nonnull
    @MixinMethod
    public static <K,E, M extends Map<K,List<E>>> M group(Collection<E> list,M map, Function1<K,E> keyGenerator) {
        for (E it: list) {
            K key = keyGenerator.call(it);
            List<E> eleList = map.computeIfAbsent(key, k -> new LinkedList<>());
            eleList.add(it);
        }
        return map;
    }

    @Nonnull
    @MixinMethod
    public static <K,E> Map<K,List<E>> group(Collection<E> list, Function1<K,E> keyGenerator) {
        return group(list, new HashMap<>(), keyGenerator);
    }

    @Nonnull
    @MixinMethod
    public static <K, E, M extends Map<K,E[]>> M group(E[] array, M map, Function1<K,E> keyGenerator) {
        Class<?> eleType = array.getClass().getComponentType();
        group(Arrays.asList(array), keyGenerator).forEach((k,e) -> {
            map.put(k, e.toArray((E[])Array.newInstance(eleType, e.size())));
        });
        return map;
    }

    @Nonnull
    @MixinMethod
    public static <K,E> Map<K,E[]> group(E[] array, Function1<K,E> keyGenerator) {
        return group(array, new HashMap<>(), keyGenerator);
    }

    @MixinMethod
    public static <T> T[] slice(T[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        int length = endIndex - beginIndex;
        T[] res = (T[]) Array.newInstance(array.getClass().getComponentType(), length);
        System.arraycopy(array, beginIndex, res, 0, length);
        return res;
    }

    @MixinMethod
    public static <T> T[] slice(T[] array, int offset) {
        return slice(array, offset, array.length);
    }

    @MixinMethod
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

    @MixinMethod
    public static <T> T[] reverse(T[] array) {
        int len = array.length;
        T[] res = (T[]) Array.newInstance(array.getClass().getComponentType(), len);
        for (int i = 0; i < len; i++) {
            res[i] = array[len - 1 - i];
        }
        return res;
    }

    @MixinMethod
    public static String join(Collection list, String delimiter) {
        return String.join(delimiter, list);
    }

    @MixinMethod
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

    @MixinMethod
    public static <T> List<T> asList(T[] array) {
        return Arrays.asList(array);
    }

}
