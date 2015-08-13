package kava.opcode;

public abstract class Op {
	/*
	public Object v1;
	public Object v2;
	public Object result;
	*/
	public Op(){
		
	}
	
	
	/*
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
	*/
	abstract public Object getParameter(String key);
	abstract public void setParameter(String key,Object value);

}
