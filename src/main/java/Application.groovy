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
		def input = '''int a=9;
int a=9;float b=9.5;a=b;
int a=9;double b=9.5;a=b;
int a=0;int c=4;int b=5;a=c+b;
int a=1;float b=9;if(a<b){a=9;}
int a=1;if(a<9.0){a=9;}
int a=9;if(0){a=1;}
int a=1;if(a){a=9;}else{a=0;}
int a=0;if(0){a=0;}else{a=9;}
int a=0;while(a<9){a=a+1;}
int a=0;while(a<100){a=a+1;if(a==9){break;}}
int a=0;do {a=a+1;}while(a<9);
int a=0;for(int i=0;i<9;i++){a++;}
int a=0;int i;for(i=0;i<9.0;i=i+1){a++;}
int a=0;int i;for(i=0;i<90;i++){a++;if(a==9){break;}}
int a=0;int[2] b;b[1]=9;a=b[1];
int a=0;if(!a){a=9;}
int a=0;if(5&&4){a=9;}
int a=0;if(0||4){a=9;}''';
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