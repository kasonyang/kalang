package kalang.ast.stmt

import kalang.ast.expr.Expression

class ReturnStmt extends Statement {
	public Expression expr
	
	String toString(){
		if(expr){
			return "return ${expr};"
		}else{
		    return "return;"
		}
	}
}
