package com.kasonyang.kava.ast.opcode;

public class VarObject {
	public static final int INT = 0,LONG=1,FLOAT = 2,DOUBLE = 3,CHAR=4,STRING=5,NULL=6,BOOLEAN=7,REFERENCE=8,BYTE=9;
	Integer id;
	Integer type;
	String className;
	String name;
	//Boolean isConst
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
	
	public void setType(Integer type){
		this.type = type;
	}
	public Integer getType(){
		return this.type;
	}
	
	
	
	public String toString(){
		return this.id.toString();
		//return "${id}:${name}:${type}"
	}
}
