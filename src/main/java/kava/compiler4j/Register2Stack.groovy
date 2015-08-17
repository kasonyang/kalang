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
import kava.opcode.Class as KC



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
	private Stack<VarObject> types = new Stack();
	
	private curClsPre = "";
	private curCls = "";
	private VarObject aoffset;
	private HashMap<Integer,Label> labs = new HashMap();
	private HashMap<VarObject,String> varTypePre = new HashMap();
	private ArrayList<VarObject> params = new ArrayList();
	private HashMap<VarObject,String> varType = new HashMap();
	
	MethodVisitor md;
	ClassWriter cw;
	public byte[] toByteArray(){
		md.visitIntInsn(ILOAD,0);
		md.visitInsn(IRETURN);
		md.visitMaxs(0,0);
		md.visitEnd();
		cw.visitEnd();
		return cw.toByteArray();
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
	
	private pushType(String t){
		this.curCls = t
		this.curClsPre = this.getTypePre(t)
		types.push(t)
	}
	
	private popType(){
		def v = types.pop()
		this.curCls = types.size()>0?types.peek():null
	}
	private popType(int count){
		for(int i=0;i<count;i++){
			popType()
		}
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
		return v.getId()*2;
	}
	
	private void _load(VarObject v){
		String t = getVarTypePre(v)
		md.visitVarInsn(Ops."${t}LOAD",getVarId(v))
		this.pushType(getVarType(v))
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
		popType(2)
		pushType("int")
	}
	private void _store(VarObject v){
		this.setVarTypeIfNoType(v,this.curCls)
		String t = getVarTypePre(v)
		if(!t.equals(this.curClsPre)){
			this._2Type(curClsPre,t)
		}
		md.visitVarInsn(Ops."${t}STORE",getVarId(v))
		this.popType();
	}
	
	private void _ldc(Integer v){
		md.visitLdcInsn(v)
		this.pushType("int")
	}
	
	private void _ldc(Constant v){
		md.visitLdcInsn(v.getValue())
		pushType(v.className)
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
	
	private String getTypeByPre(String pre){
		def type = ['I':'int','L':'long','F':'float','D':'double','A':'Object']
		return type.get(pre)
	}
	
	private void _2Type(String fromTypePre,String toTypePre){
		md.visitInsn(Ops."${fromTypePre}2${toTypePre}")
		popType()
		this.pushType(getTypeByPre(toTypePre))
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
		popType(2)
		pushType(getTypeByPre(typePre))
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
		_store(result)
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
		popType()
	}

	@Override
	public void visitIFTRUE(VarObject v1, Integer v2) {
		_load v1
		md.visitJumpInsn(Ops.IFNE,labs[v2])
		popType()
	}

	@Override
	public void visitIFEQ(VarObject v1, Integer v2) {
		_load v1
		md.visitJumpInsn(Ops.IFEQ,labs[v2])
		popType()
	}

	@Override
	public void visitIFNE(VarObject v1, Integer v2) {
		_load v1
		md.visitJumpInsn(Ops.IFNE,labs[v2])
		popType()
	}

	@Override
	public void visitIFLT(VarObject v1, Integer v2) {
		// TODO Auto-generated method stub
		_load v1
		md.visitJumpInsn(Ops.IFLT,labs[v2])
		popType()
	}

	@Override
	public void visitIFGT(VarObject v1, Integer v2) {
		_load v1
		md.visitJumpInsn(Ops.IFGT,labs[v2])
		popType()
	}

	@Override
	public void visitIFLE(VarObject v1, Integer v2) {
		_load v1
		md.visitJumpInsn(Ops.IFLE,labs[v2])
		popType()
	}

	@Override
	public void visitIFGE(VarObject v1, Integer v2) {
		_load v1
		md.visitJumpInsn(Ops.IFGE,labs[v2])
		popType()
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
		pushType('int')
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
		popType()
		pushType('Object[]')
		_store result
	}

	@Override
	public void visitAGET(VarObject result, VarObject v1) {
		_load v1
		_load aoffset
		String aType = this.getArrayBaseType(v1)
		String aT= this.getTypePre(aType)
		md.visitInsn(Ops."${aT}ALOAD")
		popType(2)
		pushType(aType)
		_store result
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
		popType(3)
	}

	@Override
	public void visitAOFFSET(VarObject v1) {
		//TODO maybe not int?
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

	private String getInteralName(String dotName){
		return dotName.replace('.','/')
	}
	
	private String getVarType(VarObject v){
		return this.varType.get(v)
	}
	private void setVarType(VarObject v,String type){
		this.varType.put(v,type)
	}
	
	private String getFullMethodName(VarObject v,String methodName){
		String iName = this.getInteralName(getVarType(v))
		return "${iName}:${methodName}"
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
	
	private String getTypeDesc(String type){
		//TODO 
	}
	
	private String getParamDesc(List<VarObject> ps){
		String str = ""
		for(p in ps){
			def clsname = this.getVarType(p)
			str += getTypeDesc(clsname)
		}
		return str
	}
	
	static boolean isPrimaryType(String type){
		//TODO 完善
		def pType = ['int','float','long','double']
		return pType.contains(type)
	}
	
	static isInstanceOf(String type,Class cls){
		if(isPrimaryType(type)){
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
		//TODO _store result
		popType(v2)
	}

	private String getInteralClassName(String qName){
		return "L${qName};"
	}
	
	private String getPathName(String dotName){
		return dotName.replace('.','/')
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
		pushType(cCls)
		this.setVarTypeIfNoType(result,cCls)
		String fDesc = Type.getDescriptor(f.getType())
		md.visitFieldInsn(GETSTATIC,owner,fName,fDesc)
		_store result
	}

	@Override
	public void visitGET_FIELD(VarObject result, VarObject v1, Constant v2) {
		// TODO Auto-generated method stub
		
	}
}
