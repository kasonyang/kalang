package kalang.core

class VarTable<T,V> {
	
    private HashMap<T,V> vars = [:]
	
    VarTable<T,V> parent
	
    VarTable(){
		
    }
	
    VarTable(VarTable parent){
        this.parent = parent
    }
	
    boolean put(T key,V var){
        vars.put(key,var)
    }
	
    boolean exist(T key,boolean includeParent=true){
        return get(key,includeParent) !=null
    }
	
    V get(T key,boolean includeParent = true){
        V est = vars.get(key)
        if(est==null && includeParent && parent){
            est = parent.get(key,includeParent)
        }
        return est;
    }
	
    V[] toArray(){
        return vars.values().toArray()
    }
	
    String toString(){
        def vos = toArray()
        return vos.toString()
    }
	
}
