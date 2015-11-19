package ell.app

import ell.antlr.EllLexer
import ell.antlr.EllParser
import ell.compiler.EllCompiler
import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream
import groovy.transform.TypeChecked
@TypeChecked
class Application {
	static void main(String[] args){
		def ln = '''
class User extends p{
   String name;
   String[] arr;
   String* list = String*[1,2,3];
}

'''
		def lexer = new EllLexer(new ANTLRInputStream(ln));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		def parser = new EllParser(tokens);
		def tree = parser.compilationUnit();
		def visitor = new EllCompiler();
		def ret = visitor.visit(tree);
		println ret.replace(";",";\n")
		ret.doth();
	}
}
