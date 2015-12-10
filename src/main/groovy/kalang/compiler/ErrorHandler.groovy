package kalang.compiler

import jast.ast.AstNode

interface ErrorHandler {
	void error(AstNode node,String errMsg,int errorCode);
}
