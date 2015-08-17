package kava.opcode.op;
import kava.opcode.Op;

public class PARAM extends Op {
        public kava.opcode.VarObject v1;
    public PARAM(kava.opcode.VarObject v1){
            this.v1 = v1;
    
    }
    public Object getParameter(String key){
        if(key == "v1") return this.v1;
        return null;
    }
    public void setParameter(String key,Object value){
        if(key == "v1"){this.v1 = (kava.opcode.VarObject)value;return;}
    }
}