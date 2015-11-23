package kalang.core

import kalang.ast.expr.AstNode

class FieldObject {
	String modifier
	String name
	String type
	AstNode initExpr
	
	String toString(){
		"${modifier} ${type} ${name};"
	}
}
