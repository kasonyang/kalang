package kalang.compiler;

import jast.ast.AstNode;
import jast.ast.ClassNode;

public interface ErrorHandler {
	void error(ClassNode clazz,AstNode node,String errMsg,int errorCode);
}
