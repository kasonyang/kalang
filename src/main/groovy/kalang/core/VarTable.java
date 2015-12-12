package kalang.core;

import java.util.HashMap;

public class VarTable<T,V> {
	
    private HashMap<T,V> vars = new HashMap<T, V>();
	
    VarTable<T,V> parent;
	
    public VarTable(){
		
    }
	
    public VarTable(VarTable<T, V> parent){
        this.parent = parent;
    }
	
    public void put(T key,V var){
        vars.put(key,var);
    }
    
    public boolean exist(T key){
    	return exist(key,true);
    }
	
    public boolean exist(T key,boolean includeParent){
        return get(key,includeParent) !=null;
    }
    
    public V get(T key){
    	return get(key,true);
    }
	
    public V get(T key,boolean includeParent){
        V est = vars.get(key);
        if(est==null && includeParent && parent!=null){
            est = parent.get(key,includeParent);
        }
        return est;
    }
	
    public V[] toArray(){
        return (V[]) vars.values().toArray();
    }
	
    public String toString(){
        V[] vos = toArray();
        return vos.toString();
    }

	public VarTable<T, V> getParent() {
		return parent;
	}

	public void setParent(VarTable<T, V> parent) {
		this.parent = parent;
	}
	
}
