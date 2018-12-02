package kalang.lang;

import kalang.annotation.Nonnull;
import kalang.annotation.Nullable;
import kalang.annotation.PluginMethod;
import kalang.type.Function1;

import java.util.*;

public class DefaultStaticMembers {

    public static void println(Object msg) {
        System.out.println(msg);
    }

    public static void print(Object msg) {
        System.out.print(msg);
    }

    public static void printf(String format, Object... args) {
        System.out.printf(format, args);
    }

    @Nullable
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
    public static <R,E> List<R> map(Collection<E> list,Function1<R,E> handler) {
        List<R> result = new LinkedList<>();
        for(E it : list) {
            result.add(handler.call(it));
        }
        return result;
    }

    @Nonnull
    @PluginMethod
    public static <R,E> List<R> map(E[] list,Function1<R,E> handler) {
        return map(Arrays.asList(list),handler);
    }



}
