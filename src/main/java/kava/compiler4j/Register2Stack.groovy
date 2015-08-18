package kava.compiler4j;
import java.lang.reflect.Field
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
import kava.opcode.ClassObject


import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor;





import org.objectweb.asm.Type;

import static org.objectweb.asm.Opcodes.*;

import org.objectweb.asm.Opcodes as Ops;

//@groovy.transform
public class Register2Stack implements OpVisitor {
	
	private List<Op> ops;
	private varIdx = []
	private VarObject aoffset;
	private HashMap<Integer,Label> labs = new HashMap();
	private ArrayList<VarObject> params = new ArrayList();
	private HashMap<VarObject,String> varType = new HashMap();
	
	ClassObject cls;
	
	MethodVisitor md;
	ClassWriter cw;
	
	private void transform(List<Op> ops){
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
	
	public Register2Stack(ClassObject cls){
		this.cls = cls
	}
	
	public byte[] compile(){
		String name = cls.getName();
		def cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
		cw.visit(V1_5, ACC_PUBLIC, name, null, "java/lang/Object", (String[])[].toArray());
		def mds = cls.getMethods()
		for(m in mds){
			def mdesc = JavaType.getMethodDescriptor(m.getReturnType(),m.getParamTypes())
			md = cw.visitMethod(ACC_PUBLIC + ACC_STATIC ,m.getName(), mdesc, null, null);
			md.visitCode();
			transform(m.getOpcodes())
			md.visitMaxs(0,0)
			md.visitEnd();
			md = null;
		}
		cw.visitEnd();
		return cw.toByteArray();
	}
	
	public Register2Stack(String name,TheKavaVisitor kv){
		this.ops = kv.getCompiledClass().getMethods()[0].getOpcodes();
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
		//nothing to do
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
		//TODO 待优化
		return v.getId()*2;
	}
	
	private void _load(VarObject v){
		String t = getVarTypePre(v)
		md.visitVarInsn(Ops."${t}LOAD",getVarId(v))

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
	private void _cmp(String typePre){
		//TODO int的cmp有点瑕疵
		String op = "";
		switch(typePre){
			case 'F':op = "FCMPL";break;
			case 'D':op = "DCMPL";break;
			case 'I':op = "ISUB";break;
			case 'L':op = "LCMP";break;
			default:throw new CompilerException("Unable to cmp");
		}
		md.visitInsn(Ops."${op}")


	}
	
	private void _store(VarObject v){
		String cls = getVarType(v)
		_store v,cls
	}
	
	private void _store(VarObject v,String fromCls){
		this.setVarTypeIfNoType(v,fromCls)
		String fromClsPre = this.getTypePre(fromCls)
		String t = getVarTypePre(v)
		if(!t.equals(fromClsPre)){
			this._2Type(fromClsPre,t)
		}
		md.visitVarInsn(Ops."${t}STORE",getVarId(v))

	}
	
	private void _ldc(Integer v){
		md.visitLdcInsn(v)

	}
	
	private void _ldc(Constant v){
		md.visitLdcInsn(v.getValue())

	}
	
	private String getVarTypePre(VarObject v){
		String type =this.getVarType(v)
		return this.getTypePre(type)
	}
	
	private String getTypeByPre(String pre){
		def type = ['I':'int','L':'long','F':'float','D':'double','A':'Object']
		return type.get(pre)
	}
	
	private void _2Type(String fromTypePre,String toTypePre){
		md.visitInsn(Ops."${fromTypePre}2${toTypePre}")


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
		_store(result,this.getTypeByPre(typePre))
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
		this._cmp(gt)
		_store result,this.getTypeByPre(gt)
	}

	private boolean isNumber(String className){
		Map nType = ['double','float','int','long']
		return nType.containsKey(className)
	}
	
	private void assignTypeIfNoType(VarObject target,VarObject src){
		def t = this.getVarType(target)
		if(!t){
			this.setVarType(target,getVarType(src))
		}
	}
	
	@Override
	public void visitASSIGN(VarObject result, VarObject v1) {
		_load v1
		this.assignTypeIfNoType(result,v1)
		_store(result,getVarType(v1))
	}

	@Override
	public void visitPARAM(VarObject v) {
		params.push(v)
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
		md.visitJumpInsn(Ops.IFEQ,labs[v2])

	}

	@Override
	public void visitIFNE(VarObject v1, Integer v2) {
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
		_load v1
		md.visitJumpInsn(Ops.IFGT,labs[v2])

	}

	@Override
	public void visitIFLE(VarObject v1, Integer v2) {
		_load v1
		md.visitJumpInsn(Ops.IFLE,labs[v2])

	}

	@Override
	public void visitIFGE(VarObject v1, Integer v2) {
		_load v1
		md.visitJumpInsn(Ops.IFGE,labs[v2])

	}

	@Override
	public void visitGOTO(Integer v1) {
		md.visitJumpInsn(Ops.GOTO,labs[v1])
	}

	@Override
	public void visitIINC(VarObject v1, Integer v2) {
		md.visitIincInsn(this.getVarId(v1),v2)
	}

	@Override
	public void visitICONST(VarObject result, Integer v1) {
		md.visitInsn(Ops."ICONST_${v1}");

		_store(result,'int')
	}

	@Override
	public void visitLDC(VarObject result, Constant v1) {
		_ldc(v1)
		_store result,v1.className//,getTypePre(v1.className),getTypePre(result.className)
	}
	
	@Override
	public void visitANEW(VarObject result, Constant v1, Integer v2) {
		String atype = v1.getValue().toString().toUpperCase()
		Integer typeIdx = getArrayType(atype)
		_ldc(v2)
		md.visitIntInsn(NEWARRAY,typeIdx)
		_store result,'Array'
	}

	@Override
	public void visitAGET(VarObject result, VarObject v1) {
		_load v1
		_load aoffset
		String aType = this.getArrayBaseType(v1)
		String aT= this.getTypePre(aType)
		md.visitInsn(Ops."${aT}ALOAD")


		_store result,aType
	}

	private String getArrayBaseType(VarObject v){
		return getVarType(v) - '[]'
	}
	
	private String getArrayBaseTypePre(VarObject v){
		return getTypePre(this.getArrayBaseType(v))
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
		aoffset = v1
	}

	@Override
	public void visitLOGIC_NOT(VarObject result, VarObject v1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitLOGIC_AND(VarObject result, VarObject v1, VarObject v2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitLOGIC_OR(VarObject result, VarObject v1, VarObject v2) {
		// TODO Auto-generated method stub
		
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
	
	private String getVarType(VarObject v){
		if(varType.containsKey(v)){
			return this.varType.get(v)
		}else if(v.className){
			setVarType(v,v.className)
			return v.className
		}else{
			return v.className
		}
	}
	private void setVarType(VarObject v,String type){
		this.varType.put(v,type)
	}
	
	private ArrayList<VarObject> popParam(Integer count){
		def arr = new ArrayList();
		int idx = params.size() - count;
		for(int i=0;i<count;i++){
			arr.push(params[idx])
			params.remove(idx)
		}
		return arr
	}
		
	static isInstanceOf(String type,Class cls){
		if(JavaType.isPrimitive((type))){
			return type.equals(cls.toString())
		}else{
			return cls.toString().equals("class "+type)
		}
	}
	
	static Method getMethod(String className,String name,ArrayList<String> paramTypes){
		def clsName = className.replace("/",".")
		for(Method m in Class.forName(clsName).methods){
			String mName = m.getName();
			if(!name.equals(mName)) continue
			Class[] pTypes = m.getParameterTypes();
			if(pTypes.length != paramTypes.size()) continue
			boolean pOk = true;
			for(int i=0;i<pTypes.length;i++){
				Class p = pTypes[i]
				String pt = paramTypes[i]
				if(!isInstanceOf(pt,p)){
					pOk = false;
					break;
				}
			}
			if(pOk) return m
		}
		return null
	}
	
	static Field getField(String clsName,String fname){
		Class.forName(clsName).getField(fname)
	}
	
	@Override
	public void visitINVOKE_DYNAMIC(VarObject result, Constant v1, Integer v2) {
		def ps = this.popParam(v2);
		def instance = ps.get(0);
		ps.remove(0);
		def clsName = this.getVarType(instance)
		String mName = v1.getValue().toString()
		ArrayList<String> psTypes = new ArrayList()
		for(VarObject p in ps){
			psTypes.add(this.getVarType(p))
		}
		Method method = getMethod(clsName,mName,psTypes);
		def desc = Type.getMethodDescriptor(method)
		_load instance
		for(p in ps){
			_load p
		}
		md.visitMethodInsn(INVOKEVIRTUAL,clsName,mName,desc,false)
		this.setVarTypeIfNoType(result,method.getReturnType().getName())
		String type = getReturnType(method)
		if(type!='void'){
			_store result,type
		}
	}
	
	private static getReturnType(Method method){
		String type = method.getReturnType().toString()
		if(type.startsWith("class ")){
			type = type.substring(6).replace('.','/')
		}
		return type
	}
	
	private String getStaticFieldDescriptor(String dotOwner,String fName){
		Field f = getField(dotOwner,fName)
		//def cls = Class.forName(dotOwner)
		//def fClass = cls."${fName}".class
		return Type.getDescriptor(f.getType())
	}
	
	
	public void setVarTypeIfNoType(VarObject v,String t){
		def tt = this.getVarType(v)
		if(!tt){
			this.setVarType(v,t)
		}
	}
	
	@Override
	public void visitGET_STATIC(VarObject result, Constant v1) {
		//def fieldDesc = this.getStaticFieldDescriptor(v1.getValue().toString())
		def fields = v1.getValue().toString().split("\\.")
		String owner = fields[0]
		String fName = fields[1]
		String dotOwner = owner.replace('/','.')
		Field f = getField(dotOwner,fName)
		def cCls = Type.getInternalName(f.getType());

		this.setVarTypeIfNoType(result,cCls)
		String fDesc = Type.getDescriptor(f.getType())
		md.visitFieldInsn(GETSTATIC,owner,fName,fDesc)
		_store result,cCls
	}

	@Override
	public void visitGET_FIELD(VarObject result, VarObject v1, Constant v2) {
		// TODO Auto-generated method stub
		
	}

	private _return(VarObject v){
		String rt = getVarTypePre(v)
		_load v
		md.visitInsn(Ops."${rt}RETURN")
	}
	
	private _return(){
		md.visitInsn(RETURN)
	}
	
	@Override
	public void visitRETURN(VarObject v1) {
		if(v1){
			_return(v1)
		}else{
			_return()
		}
	}
}
