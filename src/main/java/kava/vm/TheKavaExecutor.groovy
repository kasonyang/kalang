package kava.vm
import java.util.HashMap;

import kava.opcode.Constant;
import kava.opcode.Op
import kava.opcode.VarObject;
import kava.opcode.op.OpVisitor;


public class TheKavaExecutor implements OpVisitor {

	private HashMap<String,Object> vars = new HashMap();
	
	private opOffset = 0;
	
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
	public void visitI2F(VarObject result, VarObject v1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitI2L(VarObject result, VarObject v1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitI2D(VarObject result, VarObject v1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitL2I(VarObject result, VarObject v1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitL2F(VarObject result, VarObject v1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitL2D(VarObject result, VarObject v1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitF2D(VarObject result, VarObject v1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitF2I(VarObject result, VarObject v1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitF2L(VarObject result, VarObject v1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitD2I(VarObject result, VarObject v1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitD2L(VarObject result, VarObject v1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitD2F(VarObject result, VarObject v1) {
		// TODO Auto-generated method stub
		
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
	public void visitPARAM(VarObject result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitLCONST(VarObject result, Constant v1) {
		// TODO Auto-generated method stub
		set(result,v1.getValue())
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

}
