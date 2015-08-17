import kava.antlr.*
import kava.compiler.Optimizer;
import kava.compiler.TheKavaVisitor;
import kava.compiler4j.Register2Stack

import kava.opcode.Op
import kava.vm.TheKavaExecutor

import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream

class Application {
	static void main(args) {
		def input = '''m:System.out.println("hehe");''';
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
			for(t in tb){
			}
			//println tb
			def opc = visitor.getOpcodes();
			def opcStrBeforeOptim = opc2String(opc);
			def optimizer = new Optimizer(opc);
			opc = optimizer.optimize();
			new File("output/${name}.kc").withWriter{w->
				w.write(opc2String(opc) + "\n${opcStrBeforeOptim}")
			}
			print name
			print " "
			this.executeOnVm(opc)
			print " "
			//this.executeOnJvm(name,visitor)
			println ''
			
			printOpc(opc)
		}
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
	
	static void executeOnJvm(name,visitor){
		def former = new Register2Stack(name,visitor)

		byte[] bs = former.toByteArray();

		new File("output/${name}.class").withOutputStream {os->
			os.write(bs)
		}
		def classLoader = new KavaClassLoader()
		def cls = classLoader.defineClass(name,bs)
		def result = cls.invokeMethod("run",null)
		println " " + result
	
	}
	
}