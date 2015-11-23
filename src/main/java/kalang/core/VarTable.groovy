package kalang.core

class VarTable {
	
	private HashMap<Object,VarObject> vars = [:]
	
	private VarTable parent
	
	VarTable(){
		
	}
	
	VarTable(VarTable parent){
		this.parent = parent
	}
	
	boolean put(Object key,VarObject var){
		vars.put(key,var)
	}
	
	VarObject get(Object key){
		VarObject est = vars.get(key)
		if(est==null && parent){
			est = parent.get(key)
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
