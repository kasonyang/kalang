import kava.antlr.*
import kava.compiler.Optimizer;
import kava.compiler.TheKavaVisitor;
import kava.compiler4j.Register2Stack

import kava.opcode.Op
import kava.opcode.ClassObject
import kava.vm.TheKavaExecutor

import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream

class Application {
	static void main(args) {
		def input = '''class  kava { int run(){int a=0;System.out.println(1);return a;} int test(int a,int b){return a;}}''';
		def lnIdx = 0;
		def opsList = [];
		def ip = new StringReader(input);
		ip.eachLine {ln ->
			lnIdx++;
			if(ln.startsWith('//')){
				return
			}
			String name = "Test${lnIdx}"
			def lexer = new KavaLexer(new ANTLRInputStream(ln));
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			def parser = new KavaParser(tokens);
			def tree = parser.start()
			def visitor = new TheKavaVisitor();
			def ret = visitor.visit(tree);
			def tb = visitor.getVarTable();
			def cmpClass = visitor.getCompiledClass();
			//def opc = visitor.getOpcodes();
			String ccode =  class2String(cmpClass)
			print ccode
			//return
			//def opcStrBeforeOptim = opc2String(opc);
			//def optimizer = new Optimizer(opc);
			//opc = optimizer.optimize();
			//new File("output/${name}.kc").withWriter{w->
			//	w.write(opc2String(opc) + "\n${opcStrBeforeOptim}")
			//}
			print name
			print " "
			//this.executeOnVm(opc)
			print " "
			this.executeOnJvm(visitor.getCompiledClass())
			println ''
			
			//printOpc(opc)
		}
	}
	static String class2String(ClassObject cls){
		def str = "${cls.getName()}:";
		def align = "  "
		for(m in cls.methods){
			def rT = m.returnType
			def name = m.name
			str += "${align}${rT} ${name}:"
			for(o in m.opcodes){
				def opStr = opc2String(o)
				str += opStr
			}
		}
		return str
	}
	static String opc2String(opc){
		def str = "";
		for(Op o in opc){
		def r = o.getParameter("result")
		def v1 = o.getParameter("v1")
		def v2 = o.getParameter("v2")
		str  +=o.class.getSimpleName() + " ${r} ${v1} ${v2}\n"
		}
		return str
	}
	
	static void printOpc(opc){
		println opc2String(opc)
	}
	
	static void executeOnVm(List opc){
		def executor = new TheKavaExecutor()
		try{
			executor.execute(opc)
			print executor.getVar('a')
		}catch(Exception e){
			println e.getMessage()
			println opc2String(opc)
			throw e
		}
	}
	
	static void executeOnJvm(ClassObject cls){
		def former = new Register2Stack(cls)
		def name = cls.getName()
		byte[] bs = former.compile();

		new File("output/${name}.class").withOutputStream {os->
			os.write(bs)
		}
		def classLoader = new KavaClassLoader()
		def jcls = classLoader.defineClass(name,bs)
		def result = jcls.invokeMethod("run",null)
		println " " + result
	
	}
	
}