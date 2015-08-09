import com.kasonyang.kava.antlr.*
import com.kasonyang.kava.ast.opcode.Op
import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream

class Application {
	
	static void main(args) {
		def input = new ANTLRInputStream('''
a=1;
b=2;
c=a+b;
d=c+1;
myFunc(d);
if(d){d=0;}
if(d){d=1;}else{d=0;}
while(d){d=1;}
do {d=1;}while(d);
for(i=0;i+100;i=i+1){d=1;}
''');
		def lexer = new KavaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		def parser = new KavaParser(tokens);
		def tree = parser.start()
		def visitor = new TheKavaVisitor();
		def ret = visitor.visit(tree);
		def tb = visitor.getVarTable();
		for(t in tb){
			
		}
		println tb
		def opc = visitor.getOpcodes();
		def lnIdx=0;
		for(o in opc){
			println "${lnIdx++} : ${o}"
		}
		//TheKavaRunner.execute(opc,tb)
		//println tb
		//println ret.expr
	}

}
