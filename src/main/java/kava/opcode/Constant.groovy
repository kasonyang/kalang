package kava.opcode;

public class Constant {
	//public static final int INT = 0,LONG=1,FLOAT = 2,DOUBLE = 3,CHAR=4,STRING=5,NULL=6;
	//int type;
	Object value;
	String className;
	public Constant(){
		//this.type = type;
	}
	public String toString(){
		return value.toString();
	}
}
