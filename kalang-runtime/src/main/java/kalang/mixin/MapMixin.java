package kalang.mixin;

import java.util.*;

/**
 * @author KasonYang
 */
public class MapMixin {


    public static <K, V> Map<K, V> union(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V>... others) {
        int size = map.size();
        for (Map o : others) {
            size += o.size();
        }
        HashMap<K, V> result = new HashMap<>(size);
        result.putAll(map);
        for (Map<? extends K, ? extends V> o : others) {
            result.putAll(o);
        }
        return result;
    }

    public static <K, V> Map<K, V> exclude(Map<? extends K, ? extends V> map, K... keys) {
        return filterByKey(map, false, keys);
    }

    public static <K, V> Map<K, V> only(Map<? extends K, ? extends V> map, K... keys) {
        return filterByKey(map, true, keys);
    }

    private static <K, V> Map<K, V> filterByKey(Map<? extends K, ? extends V> map, boolean contains, K... keys) {
        HashMap<K, V> result = new HashMap<>(map.size());
        List<K> keyList = Arrays.asList(keys);
        for (Map.Entry<? extends K, ? extends V> e : map.entrySet()) {
            if (keyList.contains(e.getKey()) == contains) {
                result.put(e.getKey(), e.getValue());
            }
        }
        return result;
    }


}
