package kava.compiler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import kava.opcode.Op;
import kava.opcode.VarObject;
import kava.opcode.op.*;


public class Optimizer {
	HashMap<VarObject,List<Op>> refs = new HashMap();
	HashMap<VarObject,List<Op>> retRefs = new HashMap();
	
	private List<Op> list;
	
	public Optimizer(List<Op> list){
		this.list = list;
	}
	
	void incRef(VarObject o,Op position){
		
	}
	
	void checkAndUpdateRef(Object o,Op pos,HashMap<VarObject,List<Op>> refs){
		if(o==null) return;
		if (o.getClass() == VarObject.class){
			//this.incRef((VarObject) o,pos);
			List<Op> list;
			VarObject key = (VarObject) o;
			if(refs.containsKey(key)){
				list = refs.get(key);
			}else{
				list = new ArrayList();
			}
			list.add(pos);
			refs.put(key, list);
		}
	}
	public List<Op> optimize(){
		for(int i=0;i<list.size();i++){
			Op op = list.get(i);
			Object v1 = op.getParameter("v1");
			Object v2 = op.getParameter("v2");
			Object ret = op.getParameter("result");
			this.checkAndUpdateRef(v1,op,refs);
			this.checkAndUpdateRef(v2,op,refs);
			this.checkAndUpdateRef(ret,op,retRefs);
		}
		for(Entry<VarObject, List<Op>> e:this.refs.entrySet()){
			List<Op> poslist = e.getValue();
			VarObject key = e.getKey();
			
			if(poslist.size()==1){
				Op op = poslist.get(0);
				Op opPrev = list.get(list.indexOf(op)-1);
				VarObject opPrevResult = (VarObject) opPrev.getParameter("result");
				if(op.getClass()==ASSIGN.class
					&& opPrevResult == key
					&& this.retRefs.get(key).size()==1){
					opPrev.setParameter("result",op.getParameter("result"));
					safeDeleteOp(list,op);
				}
			}
		}
		return list;
	}
	
	void safeDeleteOp(List<Op> list,Op o){
		int pos = list.indexOf(o);
		list.remove(o);
		for(int i=0;i<list.size();i++){
			Op op = list.get(i);
			if(op instanceof GOTO){
				GOTO opGoto = ((GOTO) op);
				if(opGoto.v1>pos){
					opGoto.v1 -= 1;
				}
			}else if (op instanceof IF){
				IF opIF = (IF) op;
				if(opIF.v2>pos){
					opIF.v2 -= 1;
				}
			}
		}
	}
}
