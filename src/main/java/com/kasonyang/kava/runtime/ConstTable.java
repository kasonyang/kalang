package com.kasonyang.kava.runtime;

import java.util.HashMap;

public class ConstTable {
	private HashMap<Integer,Object> tb = new HashMap();
	private Integer idx = 0;
	public Object get(Integer key){
		return tb.get(key);
	}
	public Integer create(Object value){
		Integer key = idx++;
		tb.put(key, value);
		return key;
	}
}
