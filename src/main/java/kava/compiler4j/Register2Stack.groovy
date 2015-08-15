package kava.compiler4j;
import java.lang.reflect.Method;
import java.util.List;

import kava.compiler.CompilerException
import kava.compiler.ConstTable
import kava.compiler.TheKavaVisitor
import kava.compiler.VarTable
import kava.opcode.Constant;
import kava.opcode.Op
import kava.opcode.VarObject;
import kava.opcode.op.OpVisitor

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor;




import static org.objectweb.asm.Opcodes.*;

import org.objectweb.asm.Opcodes as Ops;

//@groovy.transform
public class Register2Stack implements OpVisitor {
	
	private List<Op> ops;
	//private ConstTable ctb;
	//private VarTable vtb;
	//Integer v1,v2,r
	//Op op;
	private varIdx = []
	//private HashMap<Long,Label> labels = new HashMap();
	
	private curClsPre = "";
	private VarObject aoffset;
	private HashMap<Integer,Label> labs = new HashMap();
	private HashMap<VarObject,String> varTypePre = new HashMap();
	
	MethodVisitor md;
	ClassWriter cw;
	public byte[] toByteArray(){
		md.visitIntInsn(ILOAD,0);
		md.visitInsn(IRETURN);
		md.visitMaxs(20,20);
		md.visitEnd();
		cw.visitEnd();
		return cw.toByteArray();
	}
	
	private getLabel(Long position){
		return labels.get(position)
	}
	
	private initVarIdx(){
		def vars = vtb.getVars()
		def offset=0
		for(v in vars){
			//new VarObject();
			varIdx[v.getId()] = offset
			switch(v.getType()){
				case VarObject.INT:
				case VarObject.FLOAT:
					offset++
					break;
				case VarObject.LONG:
				case VarObject.DOUBLE:
					offset+=2;
					break;
				default:
					offset++;
			}
		}
	}
	
	private void transform(){
		int size = ops.size();
		for(Integer i=0;i<size;i++){
			labs.put i,new Label()
		}
		for(Integer i=0;i<size;i++){
			Op o  = ops[i]
			md.visitLabel(labs[i])
			def ps = []
			def result = o.getParameter("result")
			def v1 = o.getParameter("v1")
			def v2 = o.getParameter("v2")
			if(result!=null) ps.add(result)
			if(v1!=null) ps.add(v1)
			if(v2!=null) ps.add(v2)
			def opName = o.getClass().getSimpleName()
			def method = this.&"visit${opName}"
			method.call(ps.toArray())
		}
	}
	
	public Register2Stack(String name,TheKavaVisitor kv){
		this.ops = kv.getOpcodes();
		cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
		cw.visit(V1_5, ACC_PUBLIC/* + ACC_ABSTRACT + ACC_INTERFACE*/, name, null, "java/lang/Object", (String[])[].toArray());
		md = cw.visitMethod(ACC_PUBLIC + ACC_STATIC /*+ ACC_ABSTRACT*/, "run", "()I", null, null);
		md.visitCode();
		transform()
	}
	
	private Integer getArrayType(String type){
		String t = type.toUpperCase()
		return Ops."T_${t}";
	}
	
	@Override
	public void visitNOOP() {
		// TODO Auto-generated method stub
		
	}

	private String getGreaterTypePre(VarObject v1,VarObject v2){
		def arr = [getVarTypePre(v1),getVarTypePre(v2)]
		if(arr.contains('D')) return 'D';
		if(arr.contains('F')) return 'F';
		if(arr.contains('L')) return 'L';
		if(arr.contains('I')) return 'I';
	}
	
	private boolean isFloatPointVar(VarObject v){
		String type = this.getVarTypePre(v)
		return type.equals('float') || type.equals('double')
	}
	
	private String getResultTypePre(String op,VarObject v1,VarObject v2){
		//String v1 = var1.className
		//String v2 = var2.className
		switch(op){
			case '+':
			case '-':
				return this.getGreaterTypePre(v1,v2)
			case '*':
				if(isFloatPointVar(v1)
					||isFloatPointVar(v2)){
					return 'D'
				}else{
					return 'L'
				}
				break;
			case '/':
				return 'D';
			default:
				return null;
		}
	}
	
	private String getTypePre(String type){
		if(type.equals("") || type ==null){
			throw new CompilerException("No type");
		}
		switch(type){
			case 'int':return 'I';
			case 'long':return 'L';
			case 'float':return 'F';
			case 'double':return 'D';
			default:return 'A';
		}
	}
	
	private Integer getVarId(VarObject v){
		return v.getId()*2;
	}
	
	private void _load(VarObject v){
		String t = getVarTypePre(v)
		md.visitVarInsn(Ops."${t}LOAD",getVarId(v))
		this.curClsPre = t
	}
	
	private void _load(VarObject v,String targetTypePre){
		_load v
		String typePre = getVarTypePre(v)
		if(!typePre.equals(targetTypePre)){
			this._2Type(typePre,targetTypePre)
		}
	}
	
	/**
	 * 
	 */
	private void _cmp(){
		//TODO int的cmp有点瑕疵
		String t = this.curClsPre;
		String op = "";
		switch(t){
			case 'F':op = "FCMPL";break;
			case 'D':op = "DCMPL";break;
			case 'I':op = "ISUB";break;
			case 'L':op = "LCMP";break;
			default:throw new CompilerException("Unable to cmp");
		}
		md.visitInsn(Ops."${op}")
		this.curClsPre = "I"
	}
	private void _store(VarObject v){
		String t = getVarTypePre(v)
		if(!t.equals(this.curClsPre)){
			this._2Type(curClsPre,t)
		}
		md.visitVarInsn(Ops."${t}STORE",getVarId(v))
	}
	
	private void _astore(){
		
	}
	
	private void _ldc(Integer v){
		md.visitLdcInsn(v)
		curClsPre = "I"
	}
	
	private void _ldc(Constant v){
		md.visitLdcInsn(v.getValue())
		curClsPre = getTypePre(v.className)
	}
	
	private String getVarTypePre(VarObject v){
		String t = this.varTypePre[v]
		if(t==null){
			if(v.className==null){
				t = this.curClsPre;
			}else{
				t = getTypePre(v.className)
			}
			varTypePre.put(v,t)
		}
		return t
	}
	
	private void _2Type(String fromTypePre,String toTypePre){
		md.visitInsn(Ops."${fromTypePre}2${toTypePre}")
		curClsPre = toTypePre
	}
	
	
	
	/**
	 * example + double
	 * @param op
	 * @param type
	 */
	private void _math(String op,String typePre){
		String t = typePre
		Map opMap = ['+':'ADD','-':'SUB','*':'MUL','/':'DIV','%':'REM']
		String opStr = opMap[op]
		md.visitInsn(Ops."${t}${opStr}")
		curClsPre = t
	}
	
	private void calculate(String op,VarObject result,VarObject v1,VarObject v2){
		String typePre = this.getResultTypePre(op,v1,v2)
		String t1 = getVarTypePre(v1)
		String t2 = getVarTypePre(v2)
		_load(v1)
		if(t1!=typePre){
			_2Type(t1,typePre)
		}
		_load(v2)
		if(t2!=typePre){
			_2Type(t2,typePre)
		}
		_math(op,typePre)
		_store(result)
	}
	
	@Override
	public void visitADD(VarObject result, VarObject v1, VarObject v2) {
		calculate '+',result,v1,v2
	}

	@Override
	public void visitSUB(VarObject result, VarObject v1, VarObject v2) {
		calculate '-',result,v1,v2
	}

	@Override
	public void visitMUL(VarObject result, VarObject v1, VarObject v2) {
		calculate '*',result,v1,v2
	}

	@Override
	public void visitDIV(VarObject result, VarObject v1, VarObject v2) {
		calculate '/',result,v1,v2
	}

	@Override
	public void visitMOD(VarObject result, VarObject v1, VarObject v2) {
		calculate '%',result,v1,v2
	}

	
	@Override
	public void visitCMP(VarObject result, VarObject v1, VarObject v2) {
		String gt = this.getGreaterTypePre(v1,v2)
		this._load(v1,gt)
		this._load(v2,gt)
		this._cmp()
		_store result
	}

	private boolean isNumber(String className){
		Map nType = ['double','float','int','long']
		return nType.containsKey(className)
	}
	
	@Override
	public void visitASSIGN(VarObject result, VarObject v1) {
		_load v1
		_store(result)
	}

	@Override
	public void visitPARAM(VarObject result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitIFFALSE(VarObject v1, Integer v2) {
		//TODO maybe not int
		_load v1
		md.visitJumpInsn(Ops.IFEQ,labs[v2])
	}

	@Override
	public void visitIFTRUE(VarObject v1, Integer v2) {
		_load v1
		md.visitJumpInsn(Ops.IFNE,labs[v2])
	}

	@Override
	public void visitIFEQ(VarObject v1, Integer v2) {
		_load v1
		// TODO Auto-generated method stub
		md.visitJumpInsn(Ops.IFEQ,labs[v2])
	}

	@Override
	public void visitIFNE(VarObject v1, Integer v2) {
		// TODO Auto-generated method stub
		_load v1
		md.visitJumpInsn(Ops.IFNE,labs[v2])
	}

	@Override
	public void visitIFLT(VarObject v1, Integer v2) {
		// TODO Auto-generated method stub
		_load v1
		md.visitJumpInsn(Ops.IFLT,labs[v2])
	}

	@Override
	public void visitIFGT(VarObject v1, Integer v2) {
		// TODO Auto-generated method stub
		_load v1
		md.visitJumpInsn(Ops.IFGT,labs[v2])
	}

	@Override
	public void visitIFLE(VarObject v1, Integer v2) {
		_load v1
		// TODO Auto-generated method stub
		md.visitJumpInsn(Ops.IFLE,labs[v2])
	}

	@Override
	public void visitIFGE(VarObject v1, Integer v2) {
		// TODO Auto-generated method stub
		_load v1
		md.visitJumpInsn(Ops.IFGE,labs[v2])
	}

	@Override
	public void visitGOTO(Integer v1) {
		// TODO Auto-generated method stub
		md.visitJumpInsn(Ops.GOTO,labs[v1])
	}

	@Override
	public void visitIINC(VarObject v1, Integer v2) {
		md.visitIincInsn(this.getVarId(v1),v2)
	}

	@Override
	public void visitICONST(VarObject result, Integer v1) {
		// TODO Auto-generated method stub
		md.visitInsn(Ops."ICONST_${v1}");
		this.curClsPre = "I"
		_store(result)
	}

	@Override
	public void visitLDC(VarObject result, Constant v1) {
		_ldc(v1)
		_store result//,getTypePre(v1.className),getTypePre(result.className)
	}
	
	@Override
	public void visitANEW(VarObject result, Constant v1, Integer v2) {
		String atype = v1.getValue().toString().toUpperCase()
		Integer typeIdx = getArrayType(atype)
		_ldc(v2)
		md.visitIntInsn(NEWARRAY,typeIdx)
		this.curClsPre = "A"
		_store result
	}

	@Override
	public void visitAGET(VarObject result, VarObject v1) {
		_load v1
		_load aoffset
		String aT = this.getArrayBaseTypePre(v1)
		md.visitInsn(Ops."${aT}ALOAD")
		curClsPre = aT
		_store result
	}

	private String getArrayBaseTypePre(VarObject v){
		return getTypePre(v.className - '[]')
	}
	
	@Override
	public void visitAPUT(VarObject v1, VarObject v2) {
		_load v1
		_load aoffset
		_load v2
		String aT = this.getArrayBaseTypePre(v1)
		String vT = this.getVarTypePre(v2)
		if(!aT.equals(vT)){
			this._2Type(vT,aT)
		}
		md.visitInsn(Ops."${aT}ASTORE")
	}

	@Override
	public void visitAOFFSET(VarObject v1) {
		//TODO maybe not int?
		aoffset = v1
	}
}
