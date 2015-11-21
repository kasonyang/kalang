package kalang.core

class VarObject {
	boolean isReadOnly
	String name
	String type
	VarObject(String name,String type,boolean readOnly = false){
		this.name = name
		this.type = type
		this.isReadOnly = readOnly
	}
	
	String toString(){
		return "${type} ${name}";
	}
	
}
