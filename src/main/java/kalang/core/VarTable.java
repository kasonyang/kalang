package kalang.core;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

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

    public VarTable(@Nullable VarTable<T, V> parent) {
        this.parent = parent;
    }

    public void put(T key, V var) {
        vars.put(key, var);
    }

    public boolean exist(T key) {
        return exist(key, true);
    }

    public boolean exist(T key, boolean includeParent) {
        boolean e = vars.containsKey(key);
        if(!e && parent!=null){
            e =  parent.exist(key);
        }
        return e;
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
    
    public void remove(T key,boolean includeParent){
        vars.remove(key);
        if(includeParent && parent!=null) parent.remove(key, includeParent);
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
    
    public Set<T> keySet(){
        return vars.keySet();
    }

}
