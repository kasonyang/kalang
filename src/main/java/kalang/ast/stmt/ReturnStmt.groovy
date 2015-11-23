package kalang.ast.stmt

import kalang.ast.expr.AstNode

class ReturnStmt extends Statement {
	public AstNode expr
	
	String toString(){
		if(expr){
			return "return ${expr};"
		}else{
		    return "return;"
		}
	}
}
