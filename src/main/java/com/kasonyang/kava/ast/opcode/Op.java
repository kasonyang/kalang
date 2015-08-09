package com.kasonyang.kava.ast.opcode;

public class Op {
	
	private OpType op;
	public long v1=-1;
	public long v2=-1;
	public long result=-1;
	
	public Op(OpType op,long result,long v1,long v2){
		this.op = op;
		this.v1 = v1;
		this.v2 = v2;
		this.result = result;
	}
	
	public String toString(){
		return  String.format("%s %d %d %d",this.op,this.result,v1,v2);
	}
}
