package kava.opcode.op;
import kava.opcode.Op;

public class PARAM extends Op {
        public kava.opcode.VarObject result;
    public PARAM(kava.opcode.VarObject result){
            this.result = result;
    
    }
    public Object getParameter(String key){
        if(key == "result") return this.result;
        return null;
    }
    public void setParameter(String key,Object value){
        if(key == "result"){this.result = (kava.opcode.VarObject)value;return;}
    }
}