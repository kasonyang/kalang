package kava.opcode.op;
import kava.opcode.Op;

public class GOTO extends Op {
        public Integer v1;
    public GOTO(Integer v1){
            this.v1 = v1;
    
    }
    public Object getParameter(String key){
        if(key == "v1") return this.v1;
        return null;
    }
    public void setParameter(String key,Object value){
        if(key == "v1"){this.v1 = (Integer)value;return;}
    }
}