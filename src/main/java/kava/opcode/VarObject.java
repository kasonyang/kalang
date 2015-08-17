package kava.opcode;

public class VarObject {
	//public static final int INT = 0,LONG=1,FLOAT = 2,DOUBLE = 3,CHAR=4,STRING=5,NULL=6,BOOLEAN=7,REFERENCE=8,BYTE=9,AUTO=10;
	Integer id;
	public String className;
	String name;
	public boolean callable = false;
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return id;
	}
	public String toString(){
		return String.format("%s(%d,%s)",name,id,className);
	}
}
