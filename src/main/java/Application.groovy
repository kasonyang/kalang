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
import org.antlr.v4.runtime.tree.ParseTree

class Application {
	static void main(args) {
		def input = '''\
import java.util.*;
class  kava {
  var f as int = 123;
  var f2;
  
  var func() as int{
    var a as int=3;
    var l as long = 3;
	//var aa = new String(3);
    var b;
    //a=b + 1;
    //b.func(a);
    func2(a);
    func2(l);
    return (int)a;
  }
  var func2(p as long){
    f = 123;
    for(var i as int=0;i<10;i++){
      p++;
    }
	//func2(p);
  }
}
''';
		def opsList = [];
		def lexer = new KalangLexer(new ANTLRInputStream(input));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		def parser = new KalangParser(tokens);
		def tree = parser.start()
		def visitor = new KalangTranslator();
		def cls
		try{
			cls = visitor.visit(tree);
		}catch(ParseError e){
			errorOn(e.getMessage(),e.getTree(),tokens)
		}
		//println names
		//println cls;
		def a2j = new Ast2Java();
		println a2j.visit(cls);
		def astLoader = new AstLoader()
		astLoader.add(cls)
		def varParser = new VariableParser()
		println varParser.parse(cls)
		
		def parseTrees = visitor.getParseTreeMap();
		def typeChecker = new TypeChecker(astLoader)
		try{
			typeChecker.check(cls)
			println "type checked!"
		}catch(TypeChecker.TypeError e){
			def node = e.getNode()
			def t = parseTrees.get(node)
			errorOn(e.message,t,tokens)
			//println e.message + ":error on ${node}"
		}
		//def ast = AstBuilder.build(String.class);
		//println a2j.visit(ast)
	}
	
	def static errorOn(String msg,ParseTree tree,CommonTokenStream tokens){
		def itv = tree.getSourceInterval()
			def t = tokens.get(itv.a)
			def col = t.charPositionInLine
			println "@${t.line}:${col} => ${msg}"
	}
}