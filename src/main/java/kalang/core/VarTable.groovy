package kalang.core

class VarTable<T> {
	
	private HashMap<T,VarObject> vars = [:]
	
	VarTable parent
	
	VarTable(){
		
	}
	
	VarTable(VarTable parent){
		this.parent = parent
	}
	
	boolean put(T key,VarObject var){
		vars.put(key,var)
	}
	
	boolean exist(T key,boolean includeParent=true){
		return get(key,includeParent) !=null
	}
	
	VarObject get(T key,boolean includeParent = true){
		VarObject est = vars.get(key)
		if(est==null && includeParent && parent){
			est = parent.get(key,includeParent)
		}
		return est;
	}
	
	VarObject[] toArray(){
		return vars.values().toArray()
	}
	
	String toString(){
		def vos = toArray()
		return vos.toString()
	}
	
}
