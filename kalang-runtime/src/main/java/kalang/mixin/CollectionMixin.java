package kalang.mixin;

import kalang.annotation.MixinMethod;
import kalang.annotation.Nonnull;
import kalang.annotation.Nullable;
import kalang.type.Function1;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;

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
    public static <T> T at(List<T> list, int index, T defaultValue) {
        int offset = index >= 0 ? index : list.size() + index;
        if (offset >= 0 && offset < list.size()) {
            return list.get(offset);
        }
        return defaultValue;
    }

    @MixinMethod
    public static <T> T at(List<T> list, int index) {
        int offset = index >= 0 ? index : list.size() + index;
        return list.get(offset);
    }

    @MixinMethod
    public static <T> T at(T[] list, int index, T defaultValue) {
        return at(Arrays.asList(list), index, defaultValue);
    }

    @MixinMethod
    public static <T> T at(T[] list, int index) {
        return at(Arrays.asList(list), index);
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
    public static <R,E> R[] map(E[] list, Class<R> componentType ,Function1<R,E> handler) {
        R[] result = (R[]) Array.newInstance(componentType, list.length);
        for (int i = 0; i < result.length; i++) {
            result[i] = handler.call(list[i]);
        }
        return result;
    }

    @Nonnull
    @MixinMethod
    public static <K,E, M extends Map<K,List<E>>> Map<K,List<E>> group(Collection<E> list,M map, Function1<K,E> keyGenerator) {
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
    public static <K, E, M extends Map<K,E[]>> Map<K,E[]> group(E[] array, M map, Function1<K,E> keyGenerator) {
        Class<?> eleType = array.getClass().getComponentType();
        group(Arrays.asList(array), keyGenerator).forEach((k,e) -> map.put(k, e.toArray((E[])Array.newInstance(eleType, e.size()))));
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
    @SuppressWarnings("unchecked")
    public static <T> List<T> reverse(List<T> list) {
        Object[] data = list.toArray();
        return (List<T>) Arrays.asList(reverse(data));
    }

    @MixinMethod
    public static String join(Object[] list, String delimiter) {
        return join(Arrays.asList(list), delimiter);
    }

    @MixinMethod
    public static String join(Collection list, String delimiter) {
        if (list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator iter = list.iterator();
        boolean hasNext = iter.hasNext();
        while(hasNext) {
            sb.append(iter.next());
            hasNext = iter.hasNext();
            if (hasNext) {
                sb.append(delimiter);
            }
        }
        return sb.toString();
    }

    @MixinMethod
    public static <T> List<T> asList(T[] array) {
        return Arrays.asList(array);
    }

    @MixinMethod
    public static List<Byte> asList(byte... array) {
        List<Byte> list = new ArrayList<>(array.length);
        for (byte a : array) {
            list.add(a);
        }
        return list;
    }

    @MixinMethod
    public static List<Short> asList(short... array) {
        List<Short> list = new ArrayList<>(array.length);
        for (short a : array) {
            list.add(a);
        }
        return list;
    }

    @MixinMethod
    public static List<Integer> asList(int... array) {
        List<Integer> list = new ArrayList<>(array.length);
        for (int a : array) {
            list.add(a);
        }
        return list;
    }

    @MixinMethod
    public static List<Long> asList(long... array) {
        List<Long> list = new ArrayList<>(array.length);
        for (long a : array) {
            list.add(a);
        }
        return list;
    }

    @MixinMethod
    public static List<Float> asList(float... array) {
        List<Float> list = new ArrayList<>(array.length);
        for (float a : array) {
            list.add(a);
        }
        return list;
    }

    @MixinMethod
    public static List<Double> asList(double... array) {
        List<Double> list = new ArrayList<>(array.length);
        for (double a : array) {
            list.add(a);
        }
        return list;
    }

    @MixinMethod
    public static int sumInt(Iterable<Integer> intList) {
        int result = 0;
        for (Integer it : intList) {
            result += it;
        }
        return result;
    }

    @MixinMethod
    public static long sumLong(Iterable<Long> longList) {
        long result = 0L;
        for (Long it : longList) {
            result += it;
        }
        return result;
    }

    @MixinMethod
    public static float sumFloat(Iterable<Float> floatList) {
        float result = 0;
        for (Float it : floatList) {
            result += it;
        }
        return result;
    }

    @MixinMethod
    public static double sumDouble(Iterable<Double> doubleList) {
        double result = 0;
        for (Double it : doubleList) {
            result += it;
        }
        return result;
    }

    /**
     * Sorts list
     * @param list the original list to sort
     * @param comparator comparator for sorting
     * @param <T>
     * @return the new sorted list
     */
    @MixinMethod
    @SuppressWarnings("unchecked")
    public static <T> List<T> sort(List<T> list, @Nullable Comparator<? super T> comparator) {
        Object[] data =  list.toArray();
        Arrays.sort(data, (Comparator) comparator);
        return (List<T>) Arrays.asList(data);
    }

    /**
     * Sorts list
     * @param list the original list to sort
     * @param keyExtractor the sort key extractor
     * @param comparator comparator for sorting
     * @param <T>
     * @param <K>
     * @return the new sorted list
     */
    @MixinMethod
    @SuppressWarnings("unchecked")
    public static <T,K> List<T> sort(List<T> list, Function<T,K> keyExtractor, @Nullable Comparator<? super K> comparator) {
        Object[] data = list.toArray();
        if (comparator == null) {
            Arrays.sort(data,(e1, e2) -> ((Comparable) keyExtractor.apply((T)e1)).compareTo(keyExtractor.apply((T)e2)));
        } else {
            Arrays.sort(data,(Comparator) Comparator.comparing(keyExtractor, comparator));
        }
        return (List<T>) Arrays.asList(data);
    }

    @SuppressWarnings("unchecked")
    @SafeVarargs
    @MixinMethod
    public static <T> List<T> sort(List<T> list, Function<T,Comparable<?>> keyExtractor, Function<T,Comparable<?>>... otherKeyExtractors) {
        Object[] data = list.toArray();
        Function<T,Comparable<?>>[] keyExtractors = new Function[otherKeyExtractors.length + 1];
        keyExtractors[0] = keyExtractor;
        if (otherKeyExtractors.length > 0) {
            System.arraycopy(otherKeyExtractors, 0, keyExtractors,1, otherKeyExtractors.length);
        }
        Arrays.sort(data, (e1, e2) -> {
            for (Function<T, Comparable<?>> ke : keyExtractors) {
                Comparable k1 = ke.apply((T) e1);
                Comparable k2 = ke.apply((T) e2);
                int cmp = k1.compareTo(k2);
                if (cmp != 0) {
                    return cmp;
                }
            }
            return 0;
        });
        return (List<T>) Arrays.asList(data);
    }

    /**
     * Sorts list in reverse order
     * @param list the original list to sort
     * @param comparator the comparator for sorting
     * @param <T>
     * @return the new sorted list
     */
    @MixinMethod
    public static <T> List<T> reverseSort(List<T> list, @Nullable Comparator<? super T> comparator) {
        return sort(list, Collections.reverseOrder(comparator));
    }

    /**
     * Sorts list in reverse order
     * @param list the origin list to sort
     * @param keyExtractor the sort key extractor
     * @param comparator the comparator for sorting
     * @param <T>
     * @param <K>
     * @return the new sorted list
     */
    @MixinMethod
    public static <T,K> List<T> reverseSort(List<T> list, Function<T,K> keyExtractor, @Nullable Comparator<? super K> comparator) {
        return sort(list, keyExtractor, Collections.reverseOrder(comparator));
    }

}
