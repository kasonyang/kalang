package kalang.core;

import java.util.Arrays;
import java.util.HashMap;

/**
 * The class holds the declared local variables.
 *
 * @author Kason Yang <i@kasonyang.com>
 * @param <T> key type
 * @param <V> value type
 */
public class VarTable<T, V> {

    private HashMap<T, V> vars = new HashMap<>();

    VarTable<T, V> parent;

    public VarTable() {

    }

    public VarTable(VarTable<T, V> parent) {
        this.parent = parent;
    }

    public void put(T key, V var) {
        vars.put(key, var);
    }

    public boolean exist(T key) {
        return exist(key, true);
    }

    public boolean exist(T key, boolean includeParent) {
        return get(key, includeParent) != null;
    }

    public V get(T key) {
        return get(key, true);
    }

    public V get(T key, boolean includeParent) {
        V est = vars.get(key);
        if (est == null && includeParent && parent != null) {
            est = parent.get(key, includeParent);
        }
        return est;
    }

    public V[] toArray() {
        return (V[]) vars.values().toArray();
    }

    @Override
    public String toString() {
        V[] vos = toArray();
        return Arrays.toString(vos);
    }

    public VarTable<T, V> getParent() {
        return parent;
    }

    public void setParent(VarTable<T, V> parent) {
        this.parent = parent;
    }

}
