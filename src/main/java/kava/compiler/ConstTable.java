package kava.compiler;

import java.util.HashMap;

import kava.opcode.Constant;

public class ConstTable {
	private HashMap<Integer,Constant> tb = new HashMap();
	private Integer idx = 0;
	public Constant get(Integer key){
		return tb.get(key);
	}
	public Constant createConst(Object value){
		Constant cst = createConst();
		cst.setValue(value);
		return cst;
	}
	public Constant createConst(){
		Integer key = idx++;
		Constant cst = new Constant();
		cst.setId(key);
		return cst;
	}
	
}
