import compilier.*
import jast.ast.*
import kalang.antlr.KalangLexer
import kalang.antlr.KalangParser
import kalang.core.VarObject
import kalang.core.VarTable
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
import java.util.*;
class  kava {
  var f as Int = 123;
  var f2;
  
  var func() as Int{
    var a as Int=3;
    var b;
    a=b + 1;
    b.func(a);
    return a;
  }
  var func2(p,a as Int){
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
		typeChecker.setDefault("this",new VarObject("this","this"))
		def names = typeChecker.resolve(cls)
		nameCheck(names)
		println names
		def a2j = new Ast2Java();
		println a2j.visit(cls);
		
		def ast = AstBuilder.build(String.class);
		println a2j.visit(ast)
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