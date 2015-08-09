package com.kasonyang.kava.runtime;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.kasonyang.kava.model.VarObject;

public class VarTable {
	
	//private varNames = []
	private HashMap<Long,VarObject> vars = new HashMap(); //id => var
	private HashMap<String,Long> ids = new HashMap();//name -> id
	private long tmpIdx = 0;
	private long varIdx = 0;
	
	/*
	public List<VarObject> getVarObjects(){
		List list = new ArrayList()
		for(en in vars.entrySet()){
			list.add(en.value)
		}
		return list
	}
	*/
	
	public VarObject get(Long idx){
		return vars.get(idx);
	}
	
	public boolean contains(String name){
		return ids.containsKey(name);
	}
	
	public long getId(String name){
		return ids.get(name);
	}
	
	public long create(){
		VarObject vo = new VarObject();
		return create(vo);
	}
	
	public long create(String name){
		return create(name,new VarObject());
	}
	
	public long create(VarObject vo){
		return create("@"+(tmpIdx++),vo);
	}
	public long create(String name,VarObject vo){
		Long id = varIdx++;
		vars.put(id,vo);
		ids.put(name,id);
		return id;
	}
		
	public String toString(){
		String str = "";
		for(Entry<String, Long> e:this.ids.entrySet()){
			VarObject vo = vars.get(e.getValue());
			str += String.format("%s(%d):%s",e.getKey(),e.getValue(),vo) + "\n";
		}
		return str;
	}
}
