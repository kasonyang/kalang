import com.kasonyang.kava.ast.opcode.Op
import com.kasonyang.kava.model.VarObject
import com.kasonyang.kava.runtime.*


class TheKavaRunner {
	VarObject v0,v1,v2
	Stack paramList = new Stack();
	
	static void execute(List<Op> ops,VarTable vtb){
		def runner = new TheKavaRunner();
		for(o in ops){
			String opStr = o.op.toString().toLowerCase();
			runner.v0 = vtb.get(o.result)
			runner.v1 = vtb.get(o.v1)
			runner.v2 = vtb.get(o.v2)
			runner."${opStr}"()
		}
	}
	
	def add(){
		v0.setValue(v1.value+v2.value)
	}
	def sub(){
		v0.setValue(v1.value-v2.value)
	}
	def mul(){
		v0.setValue(v1.value*v2.value)
	}
	def div(){
		v0.setValue(v1.value/v2.value)
	}
	def mod(){
		v0.setValue(v1.value % v2.value)
	}
	def assign(){
		v0.setValue(v1.value)
	}
	def param(){
		paramList.push(v1.value)
	}
	def invoke(){
		def name = v1.value
		def pSize = v2.value
		def params = []
		for(int i=0;i<pSize;i++){
			params.add paramList.pop()
		}
		println("invoking ${name} with params ${params}")
	}
}
