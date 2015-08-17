package kava.vm
import java.util.HashMap;

import kava.opcode.Constant;
import kava.opcode.Op
import kava.opcode.VarObject;
import kava.opcode.op.OpVisitor;


public class TheKavaExecutor implements OpVisitor {

	private HashMap<String,Object> vars = new HashMap();
	
	private opOffset = 0;
	private aoffset = 0;
	
	private Stack<Object> params = new Stack();
	
	public Object getVar(String key){
		return vars.get(key);
	}
	
	private void set(VarObject key,Object val){
		vars.put(key.getName(), val);
	}
	
	private Object get(VarObject key){
		return vars.get(key.getName());
	}
	
	private void GOTO(Integer i){
		this.opOffset = i-1
	}
	
	public execute(List<Op> ops){
		while(this.opOffset<ops.size()){
			def o = ops.get(this.opOffset)
			def name = "visit" + o.class.getSimpleName();
			def params = []
			if(o.getParameter('result')!=null) params.add(o.result)
			if(o.getParameter('v1')!=null) params.add(o.v1)
			if(o.getParameter('v2')!=null) params.add(o.v2)
			def method = this.&"${name}"
			method.call(params.toArray())
			this.opOffset++
		}
	}
	
	@Override
	public void visitNOOP() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitADD(VarObject result, VarObject v1, VarObject v2) {
		// TODO Auto-generated method stub
		set(result,get(v1)+get(v2));
	}

	@Override
	public void visitSUB(VarObject result, VarObject v1, VarObject v2) {
		set(result,get(v1)-get(v2));
	}

	@Override
	public void visitMUL(VarObject result, VarObject v1, VarObject v2) {
		set(result,get(v1)*get(v2));
	}

	@Override
	public void visitDIV(VarObject result, VarObject v1, VarObject v2) {
		set(result,get(v1)/get(v2));
	}

	@Override
	public void visitMOD(VarObject result, VarObject v1, VarObject v2) {
		set(result,get(v1)%get(v2));
	}

	
	@Override
	public void visitCMP(VarObject result, VarObject v1, VarObject v2) {
		// TODO Auto-generated method stub
		def i1 = get(v1)
		def i2 = get(v2)
		def r = 0;
		if(i1>i2) r = 1;
		if(i1<i2) r = -1;
		set(result,r)
	}

	@Override
	public void visitASSIGN(VarObject result, VarObject v1) {
		// TODO Auto-generated method stub
		set(result,get(v1))
	}

	@Override
	public void visitIFFALSE(VarObject v1, Integer v2) {
		// TODO Auto-generated method stub
		if(!get(v1)) GOTO(v2)
	}

	@Override
	public void visitIFTRUE(VarObject v1, Integer v2) {
		// TODO Auto-generated method stub
		if(get(v1)) GOTO(v2)
	}

	@Override
	public void visitIFEQ(VarObject v1, Integer v2) {
		// TODO Auto-generated method stub
		if(get(v1)==0) GOTO(v2)
	}

	@Override
	public void visitIFNE(VarObject v1, Integer v2) {
		// TODO Auto-generated method stub
		if(get(v1)==0) GOTO(v2)
	}

	@Override
	public void visitIFLT(VarObject v1, Integer v2) {
		// TODO Auto-generated method stub
		if(get(v1)<0) GOTO(v2)
	}

	@Override
	public void visitIFGT(VarObject v1, Integer v2) {
		// TODO Auto-generated method stub
		if(get(v1)>0) GOTO(v2)
	}

	@Override
	public void visitIFLE(VarObject v1, Integer v2) {
		// TODO Auto-generated method stub
		if(get(v1)<=0) GOTO(v2)
	}

	@Override
	public void visitIFGE(VarObject v1, Integer v2) {
		// TODO Auto-generated method stub
		if(get(v1)>=0) GOTO(v2)
	}

	@Override
	public void visitGOTO(Integer v1) {
		// TODO Auto-generated method stub
		GOTO(v1)
	}

	@Override
	public void visitIINC(VarObject v1, Integer v2) {
		// TODO Auto-generated method stub
		set(v1,get(v1)+v2)
	}

	@Override
	public void visitICONST(VarObject result, Integer v1) {
		// TODO Auto-generated method stub
		set(result,v1)
	}

	@Override
	public void visitLDC(VarObject result, Constant v1) {
		// TODO Auto-generated method stub
		set(result,v1.getValue())
	}

	@Override
	public void visitANEW(VarObject result, Constant v1, Integer v2) {
		//TODO set type
		def arr = []
		arr[0] = v2
		set(result,arr)
	}

	@Override
	public void visitAGET(VarObject result, VarObject v1) {
		def arr = get(v1)
		def val = arr.getAt(aoffset+1)
		set(result,val)
		aoffset = 0;
	}

	@Override
	public void visitAPUT(VarObject v1, VarObject v2) {
		def arr = get(v1)
		arr[aoffset+1] = get(v2)
		aoffset = 0;
	}

	@Override
	public void visitAOFFSET(VarObject v1) {
		aoffset = get(v1)
	}

	@Override
	public void visitLOGIC_NOT(VarObject result, VarObject v1) {
		Object val = get(v1)
		set(result,val?0:1)
	}

	@Override
	public void visitLOGIC_AND(VarObject result, VarObject v1, VarObject v2) {
		set(result,get(v1)&&get(v2))
	}

	@Override
	public void visitLOGIC_OR(VarObject result, VarObject v1, VarObject v2) {
		set(result,get(v1)||get(v2))
	}

	@Override
	public void visitNEW(VarObject result, Constant v1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitINVOKE_VIRTUAL(VarObject result, Constant v1, Integer v2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitINVOKE_SPECIAL(VarObject result, Constant v1, Integer v2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitINVOKE_STATIC(VarObject result, Constant v1, Integer v2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitINVOKE_DYNAMIC(VarObject result, Constant v1, Integer v2) {
		Integer pc = v2
		String methodName = v1.getValue()
		def ps = new Stack()
		for(int i=0;i<pc;i++){
			ps.push(params.pop());
		}
		def instance = ps.pop();
		def psize = ps.size();
		def psArr = []
		for(Integer j=0;j<psize;j++){
			psArr.add(ps.pop())
		}
		def md = instance.&"${methodName}"
		md.call(psArr.toArray())
	}

	@Override
	public void visitPARAM(VarObject v1) {
		params.push(get(v1))
	}

	private String getClassName(String interalName){
		return interalName.replace("/",".")
	}
	
	@Override
	public void visitGET_STATIC(VarObject result, Constant v1) {
		def fields = v1.getValue().toString().split("\\.")
		String cls = getClassName(fields[0])
		String f = fields[1]
		set(result,Class.forName(cls)."${f}")
	}

	@Override
	public void visitGET_FIELD(VarObject result, VarObject v1, Constant v2) {
		// TODO Auto-generated method stub
		
	}

}
