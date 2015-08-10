package com.kasonyang.kava.runtime;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.kasonyang.kava.model.VarObject;

public class VarTable {
	
	//private varNames = []
	private HashMap<Integer,VarObject> vars = new HashMap(); //id => var
	private HashMap<String,Integer> ids = new HashMap();//name -> id
	private int tmpIdx = 0;
	private int varIdx = 0;
	
	/*
	public List<VarObject> getVarObjects(){
		List list = new ArrayList()
		for(en in vars.entrySet()){
			list.add(en.value)
		}
		return list
	}
	*/
	
	public VarObject get(Integer idx){
		return vars.get(idx);
	}
	
	public boolean contains(String name){
		return ids.containsKey(name);
	}
	
	public int getId(String name){
		return ids.get(name);
	}
	
	public int create(){
		VarObject vo = new VarObject();
		return create(vo);
	}
	
	public int create(String name){
		return create(name,new VarObject());
	}
	
	public int create(VarObject vo){
		return create("@"+(tmpIdx++),vo);
	}
	public int create(String name,VarObject vo){
		Integer id = varIdx++;
		vars.put(id,vo);
		ids.put(name,id);
		return id;
	}
		
	public String toString(){
		String str = "";
		for(Entry<String, Integer> e:this.ids.entrySet()){
			VarObject vo = vars.get(e.getValue());
			str += String.format("%s(%d):%s",e.getKey(),e.getValue(),vo) + "\n";
		}
		return str;
	}
}
