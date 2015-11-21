package kalang.core

import kalang.ast.expr.Expression

class FieldObject {
	String modifier
	String name
	String type
	Expression initExpr
	
	String toString(){
		"${modifier} ${type} ${name};"
	}
}
