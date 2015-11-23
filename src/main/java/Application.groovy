import compilier.Ast2Java
import compilier.NameResolver
import jast.ast.NameExpr
import kalang.antlr.KalangLexer
import kalang.antlr.KalangParser
import kalang.core.VarObject
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
		def input = '''\
class  kava {
  var f:Int = 123;
  var f2;
  def func:Int(){ 
    var a:Int=3;
    var b;
    a=b + 1;
    b.func(a);
    return a;
  }
  def func2(p,a:Int){
    for(var i=0;i<10;i++){
      func(i,2);
    }
	func(i);
  }
}
''';
		def opsList = [];
		def lexer = new KalangLexer(new ANTLRInputStream(input));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		def parser = new KalangParser(tokens);
		def tree = parser.start()
		def visitor = new KalangTranslator();
		def cls = visitor.visit(tree);
		//def cls = visitor.getClassObject();
		def typeChecker = new NameResolver();
		def names = typeChecker.resolve(cls)
		nameCheck(names)
		println names
		def a2j = new Ast2Java();
		println a2j.visit(cls);
		//def tb = visitor.getVarTable();
		//def cmpClass = visitor.getCompiledClass();
		//def opc = visitor.getOpcodes();

	}
	
	def static void nameCheck(Map<NameExpr,VarObject> names){
		for(def en in names.entrySet()){
			VarObject v = en.getValue()
			NameExpr ne = en.getKey();
			if(v==null){
				System.err.println "Undefinded var:" +  ne.name
			}
		}
	}
}