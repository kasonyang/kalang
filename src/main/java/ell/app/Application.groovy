package ell.app

import ell.antlr.EllLexer
import ell.antlr.EllParser
import ell.compiler.EllCompiler
import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream

class Application {
	static void main(String[] args){
		def ln = '''
list:Select user where name=1,pwd=2;
'''
		def lexer = new EllLexer(new ANTLRInputStream(ln));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		def parser = new EllParser(tokens);
		def tree = parser.start()
		def visitor = new EllCompiler();
		def ret = visitor.visit(tree);
		println visitor.getCode();
	}
}
