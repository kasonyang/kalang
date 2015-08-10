import com.kasonyang.kava.antlr.*
import com.kasonyang.kava.ast.opcode.Op
import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream

class Application {

	static void main(args) {
		def input = '''a=9;
c=0;a=4;b=5;c=a+b;
a=1;if(a){a=9;}
a=9;if(0){a=1;}
a=1;if(a){a=9;}else{a=0;}
a=0;if(0){a=0;}else{a=9;}
a=0;while(a<9){a=a+1;}
a=0;while(a<100){a=a+1;if(a==9){break;}}
a=0;do {a=a+1;}while(a<9);
a=0;for(i=0;i<9;i++){a++;}
a=0;for(i=0;i<90;i++){a++;if(a==9){break;}}''';
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
			def opcOut = "";
			def opIdx = 0;
			for(o in opc){
				opcOut += "${opIdx++} : ${o}\n"
			}
			
			opsList.add(opcOut)
			new File("output/${name}.kc").withWriter{w->
				w.write(opcOut)
			}
			/*
			 def lnIdx=0;
			 for(o in opc){
			 println "${lnIdx++} : ${o}"
			 }
			 */

			
			def former = new Register2Stack(name,opc,visitor.getConstTable())

			byte[] bs = former.toByteArray();

			new File("output/${name}.class").withOutputStream {os->
				os.write(bs)
			}
			def classLoader = new KavaClassLoader()
			def cls = classLoader.defineClass(name,bs)
			def result = cls.invokeMethod("run",null)
			println result
			//TheKavaRunner.execute(opc,tb)
			//println tb
			//println ret.expr
		}
		for(ops in opsList){
			println ops
		}
	}
}