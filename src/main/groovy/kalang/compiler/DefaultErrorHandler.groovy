package kalang.compiler

import jast.ast.AstNode;
import jast.ast.ClassNode

class DefaultErrorHandler implements ErrorHandler{

	@Override
	public void error(ClassNode clazz,AstNode node, String errMsg, int errorCode) {
		System.err.println(errorCode + ":" + errMsg)
	}
	
}
