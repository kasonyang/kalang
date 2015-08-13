package kava.opcode.op;
import kava.opcode.Op;

public class ICONST extends Op {
        public kava.opcode.VarObject result;
        public Integer v1;
    public ICONST(kava.opcode.VarObject result,Integer v1){
            this.result = result;
            this.v1 = v1;
    
    }
    public Object getParameter(String key){
        if(key == "result") return this.result;
        if(key == "v1") return this.v1;
        return null;
    }
    public void setParameter(String key,Object value){
        if(key == "result"){this.result = (kava.opcode.VarObject)value;return;}
        if(key == "v1"){this.v1 = (Integer)value;return;}
    }
}