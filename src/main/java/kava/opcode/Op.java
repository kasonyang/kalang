package kava.opcode;

public abstract class Op {
	public Op(){
		
	}	
	abstract public Object getParameter(String key);
	abstract public void setParameter(String key,Object value);

}
