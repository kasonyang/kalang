import java.util.List;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor;

import com.kasonyang.kava.ast.opcode.Op;
import com.kasonyang.kava.runtime.ConstTable

import com.kasonyang.kava.ast.opcode.OpType as OT;
import static org.objectweb.asm.Opcodes.*;

public class Register2Stack {
	
	private List<Op> ops;
	private ConstTable ctb;
	Integer v1,v2,r
	Op op;
	private HashMap<Long,Label> labels = new HashMap();
	
	
	
	MethodVisitor md;
	ClassWriter cw;
	public byte[] toByteArray(){
		md.visitIntInsn(ILOAD,1);
		md.visitInsn(IRETURN);
		md.visitMaxs(1,1);
		md.visitEnd();
		cw.visitEnd();
		return cw.toByteArray();
	}
	
	private getLabel(Long position){
		return labels.get(position)
	}
	
	
	private void transform(){
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
			}
			v1 =  o.v1;
			v2 =  o.v2;
			r =  o.result;
			op = o
			String method = o.op.toString()
			this."_${method}"()
		}
	}
	
	public Register2Stack(String name,List<Op> ops,ConstTable ctb){
		this.ops = ops;
		this.ctb = ctb;
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
	
	def iload(int v){
		md.visitVarInsn(ILOAD,v);
	}
	
	def iadd(){
		md.visitInsn(IADD);
	}
	
	def isub(){
		insn(ISUB);
	}
	def imul(){
		insn(IMUL);
	}
	def idiv(){
		insn(IDIV)
	}
	def imod(){
		//insn(MOD)
	}
	def istore(int v){
		var(ISTORE,v)
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
	
	def bipush(int v){
		intInsn(BIPUSH,v)
	}
	def iconst(int v){
		md.visitLdcInsn(v)
		//intInsn(BIPUSH,v)
	}
	def iinc(int var,int inc){
		md.visitIincInsn(var,inc)
		//intInsn(IINC,v)
	}
	
	def _ADD(){
		iload v1
		iload v2
		iadd()
		istore r
	}
	def _SUB(){
		iload v1
		iload v2
		isub()
		istore r
	}
	def _MUL(){
		iload v1
		iload v2
		imul()
		istore r
	}
	def _DIV(){
		iload v1
		iload v2
		idiv()
		istore r
	}
	def _MOD(){
		iload v1
		iload v2
		imod()
		istore r
	}
	def _GOTO(){
		//int v = v1;
		jump(v1)
	}
	def _IFTRUE(){
		iload v1
		//bipush 0
		def label = getLabel(v2)
		md.visitJumpInsn(IFNE,label)
	}
	def _IFFALSE(){
		iload v1
		//bipush 0
		def label = getLabel(v2)
		md.visitJumpInsn(IFEQ,label)
	}
	def _ASSIGN(){
		iload v1
		istore r
	}
	def _INVOKE(){
		
	}
	def _PARAM(){
		
	}
	def _LCONST(){
		v1 = ctb.get(v1)
		bipush v1
		istore r
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
		istore r
	}
	def _IINC(){
		iinc v1,v2
	}
}
