package kava.compiler;

import java.util.HashMap;

import kava.opcode.Constant;

public class ConstTable {
	private HashMap<Integer,Constant> tb = new HashMap();
	private Integer idx = 0;
	public Constant get(Integer key){
		return tb.get(key);
	}
	public Constant create(Constant value){
		Integer key = idx++;
		tb.put(key, value);
		//TODO 此处好像有点问题
		return value;
	}
}
