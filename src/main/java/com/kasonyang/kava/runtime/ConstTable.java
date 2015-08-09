package com.kasonyang.kava.runtime;

import java.util.HashMap;

public class ConstTable {
	private HashMap<Long,Object> tb = new HashMap();
	private Long idx = (long) 0;
	public Object get(Long key){
		return tb.get(key);
	}
	public Long create(Object value){
		Long key = idx++;
		tb.put(key, value);
		return key;
	}
}
