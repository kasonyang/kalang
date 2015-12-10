package kalang.compiler

import jast.ast.AstNode;

class DefaultErrorHandler implements ErrorHandler{

	@Override
	public void error(AstNode node, String errMsg, int errorCode) {
		System.err.println(errorCode + ":" + errMsg)
	}
	
}
