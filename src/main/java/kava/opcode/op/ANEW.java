package kava.opcode.op;
import kava.opcode.Op;

public class ANEW extends Op {
        public kava.opcode.VarObject result;
        public kava.opcode.Constant v1;
        public Integer v2;
    public ANEW(kava.opcode.VarObject result,kava.opcode.Constant v1,Integer v2){
            this.result = result;
            this.v1 = v1;
            this.v2 = v2;
    
    }
    public Object getParameter(String key){
        if(key == "result") return this.result;
        if(key == "v1") return this.v1;
        if(key == "v2") return this.v2;
        return null;
    }
    public void setParameter(String key,Object value){
        if(key == "result"){this.result = (kava.opcode.VarObject)value;return;}
        if(key == "v1"){this.v1 = (kava.opcode.Constant)value;return;}
        if(key == "v2"){this.v2 = (Integer)value;return;}
    }
}