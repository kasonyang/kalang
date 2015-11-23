import compilier.Ast2Java
import compilier.TypeChecker
import kalang.antlr.KalangLexer
import kalang.antlr.KalangParser
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
  var f:Int;
  def func:Int(){ 
    var a:Int=3;
    var b;
    a=b + 1;
    b.func(a);
    return a;
  }
  def func2(p,a:Int){
    for(var i=0;i<10;i++){
      func();
    }
  }
}
''';
		def opsList = [];
		def lexer = new KalangLexer(new ANTLRInputStream(input));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		def parser = new KalangParser(tokens);
		def tree = parser.start()
		def visitor = new KalangTranslator();
		def ret = visitor.visit(tree);
		def cls = visitor.getClassObject();
		def typeChecker = new TypeChecker();
		def vtb = typeChecker.check(cls)
		println vtb
		def a2j = new Ast2Java();
		println a2j.visit(cls);
		//def tb = visitor.getVarTable();
		//def cmpClass = visitor.getCompiledClass();
		//def opc = visitor.getOpcodes();

	}
}