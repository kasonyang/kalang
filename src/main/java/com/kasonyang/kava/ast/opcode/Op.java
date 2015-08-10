package com.kasonyang.kava.ast.opcode;

public class Op {
	
	public OpType op;
	public Integer v1=null;
	public Integer v2=null;
	public Integer result=null;
	
	public Op(OpType op,Integer result,Integer v1,Integer v2){
		this.op = op;
		this.v1 = v1;
		this.v2 = v2;
		this.result = result;
	}
	
	public String toString(){
		return  String.format("%s %d %d %d",this.op,this.result,v1,v2);
	}
}
