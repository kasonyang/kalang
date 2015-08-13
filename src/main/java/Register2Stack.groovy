import java.lang.reflect.Method;
import java.util.List;

import kava.opcode.Constant;
import kava.opcode.VarObject;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor;

import com.kasonyang.kava.ast.opcode.Op;
import com.kasonyang.kava.ast.opcode.OpType as OT;
import com.kasonyang.kava.compiler.ConstTable;
import com.kasonyang.kava.compiler.TheKavaVisitor
import com.kasonyang.kava.compiler.VarTable;

import static org.objectweb.asm.Opcodes.*;

import org.objectweb.asm.Opcodes as Ops;

//@groovy.transform
public class Register2Stack {
	
	private List<Op> ops;
	private ConstTable ctb;
	private VarTable vtb;
	Integer v1,v2,r
	Op op;
	private varIdx = []
	private HashMap<Long,Label> labels = new HashMap();
	
	
	
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
		initVarIdx()
		/*
		Label start = new Label();
		Label end  = new Label();
		def vars = vtb.getVars();
		
		
		for(v in vars){
			md.visitLocalVariable(v.name,"I",null,start,end,v.id)
		}		
		md.visitLabel(start)
		*/
		//ClassLoader g;
		Long offset=0;
		for(Op o:ops){
			Long lbPos = null;
			switch(o.op){
				case OT.GOTO:
					lbPos = o.v1
					break;
				case OT.IFTRUE:
				case OT.IFFALSE:
				case OT.IFEQ:
				case OT.IFNE:
				case OT.IFLT:
				case OT.IFGT:
				case OT.IFLE:
				case OT.IFGE:
					lbPos = o.v2
					break;
			}
			if(lbPos!=null){
				Label lb = getLabel(lbPos)
				this.labels.put(lbPos,lb?:new Label())
			}
		}
		
		for(Op o:ops){
			Long nowPos = offset++;
			def label = this.labels.get(nowPos)
			if(label!=null){
				md.visitLabel(label)
				//md.visitFrame(F_SAME, 0, null, 0, null);
			}
			v1 =  o.v1;
			v2 =  o.v2;
			r =  o.result;
			op = o
			String method = o.op.toString()
			def magicMets = "CMP,ASSIGN,ADD,MOD,MUL,SUB,DIV,LOAD,STORE,2I,2F,2L,2D".split(",")
			String shortMet = method.substring(1);
		
			if(magicMets.contains(shortMet)){
				String p = method[0]
				this."__${shortMet}"(p)
			}else{
				this."_${method}"()
			}
		}
		//md.visitLabel(end)
	}
	
	public Register2Stack(String name,TheKavaVisitor kv){
		this.ops = kv.getOpcodes();
		this.ctb = ctb = kv.getConstTable();
		this.vtb = kv.getVarTable();
		cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
		cw.visit(V1_5, ACC_PUBLIC/* + ACC_ABSTRACT + ACC_INTERFACE*/, name, null, "java/lang/Object", (String[])[].toArray());
		md = cw.visitMethod(ACC_PUBLIC + ACC_STATIC /*+ ACC_ABSTRACT*/, "run", "()I", null, null);
		md.visitCode();
		/*
		md.visitIntInsn(BIPUSH, 100);
		//md.visitIntInsn(arg0, arg1);
		md.visitInsn(IRETURN);
		md.visitMaxs(1, 1);
		md.visitEnd();
		cw.visitEnd();
		*/
		transform()
	}
	
	def pop(){
		md.visitInsn(POP)
	}
	
	def iload(int v){
		__load 'I',v
	}
	
	def __load(p,int v){
		v = varIdx[v]
		md.visitVarInsn(Ops."${p}LOAD",v)
	}
	
	def __cast(p,p2){
		md.visitInsn(Ops."${p}2${p2}")
	}
	
	
	def __add(p){
		md.visitInsn(Ops."${p}ADD");
	}
	
	def __sub(p){
		insn(Ops."${p}SUB");
	}

	def __mul(p){
		insn(Ops."${p}MUL");
	}
	def __div(p){
		insn(Ops."${p}DIV")
	}
	def __mod(p){
		//insn(MOD)
	}
	def __store(p,int v){
		v = varIdx[v]
		var(Ops."${p}STORE",v)
	}
	def jump(int v){
		def label = getLabel(v)
		md.visitJumpInsn(GOTO,label)
	}
	
	def ifjump(int opcode,int to){
		def label = getLabel(to)
		md.visitJumpInsn(opcode,label)
	}
	
	private void insn(int insn){
		md.visitInsn(insn);
	}
	
	private void var(int op,int v){
		md.visitVarInsn(op, v);
	}
	
	def intInsn(int op,int v){
		md.visitIntInsn(op,v)
	}
	
	def ireturn(){
		md.visitInsn(IRETURN)
	}
	def lreturn(){
		md.visitInsn(LRETURN)
	}
	def freturn(){
		md.visitInsn(FRETURN)
	}
	def dreturn(){
		md.visitInsn(DRETURN)
	}
	
	def bipush(int v){
		intInsn(BIPUSH,v)
	}
	def ldc(Object v){
		md.visitLdcInsn(v)
	}
	def iconst(int v){
		md.visitLdcInsn(v)
		//intInsn(BIPUSH,v)
	}
	def iinc(int var,int inc){
		md.visitIincInsn(var,inc)
		//intInsn(IINC,v)
	}
	
	
	def __ADD(p){
		__load p,v1
		__load p,v2
		__add(p)
		__store p,r
	}
	def __SUB(p){
		__load p,v1
		__load p,v2
		__sub(p)
		__store p,r
	}
	def __MUL(p){
		__load p,v1
		__load p,v2
		__mul(p)
		__store p,r
	}
	def __DIV(p){
		__load p,v1
		__load p,v2
		__div(p)
		__store p,r
	}
	def __MOD(p){
		__load p,v1
		__load p,v2
		__mod(p)
		__store p,r
	}
	def _GOTO(){
		//int v = v1;
		jump(v1)
	}
	def _IFTRUE(){
		__load 'I',v1
		//bipush 0
		def label = getLabel(v2)
		md.visitJumpInsn(IFNE,label)
	}
	def _IFFALSE(){
		__load 'I',v1
		//bipush 0
		def label = getLabel(v2)
		md.visitJumpInsn(IFEQ,label)
	}
	def __ASSIGN(p){
		__load p,v1
		__store p,r
	}
	
	def _INVOKE(){
		
	}
	def _PARAM(){
		
	}
	def _LCONST(){
		v1 = ctb.get(v1)
		bipush v1
		__store 'I',r
	}
	def _LOGIC_NOT(){
		
	}
	
	def _NOOP(){
		//do thing
	}
	
	def _IFEQ(){
		iload v1
		ifjump(IFEQ,v2)
	}
	def _IFNE(){
		iload v1
		ifjump(IFNE,v2)
	}
	def _IFLT(){
		iload v1
		ifjump IFLT,v2
	}
	def _IFGT(){
		iload v1
		ifjump IFGT,v2
	}
	def _IFLE(){
		iload v1
		ifjump IFLE,v2
	}
	def _IFGE(){
		iload v1
		ifjump IFGE,v2
	}
	
	def _ICONST(){
		iconst v1
		__store 'I',r
	}
	def _IINC(){
		iinc v1,v2
	}
	def __2F(p){
		__load p,v1
		__cast p,'F'
		__store 'F',r
	}
	def __2I(p){
		__load p,v1
		__cast p,'I'
		__store 'I',r
	}
	def __2L(p){
		__load p,v1
		__cast p,'L'
		__store 'L',r
	}
	def __2D(p){
		__load p,v1
		__cast p,'D'
		__store 'D',r
	}
	
	def __CMP(p){
		__load p,v1
		__load p,v2
		if(p=="L"){
			insn(Ops."${p}CMP")
		}else{
			insn Ops."${p}CMPL"
		}
		__store "I",r
	}
	
	def _LDC(){
		Constant cst = this.ctb.get(v1)
		Object val = cst.getValue()
		ldc(val)
		
		switch(cst.getType()){
			case Constant.INT:
				__store 'I',r
				break;
			case Constant.FLOAT:
				__store 'F',r;
				break;
			case Constant.LONG:
				__store 'L',r;
				break;
			case Constant.DOUBLE:
				__store 'D', r
				break;
			default:
				__store 'A', r
		}
	}
}
