package kalang.ast.stmt

import kalang.ast.expr.Expression

class ExprStmt extends Statement {
	public Expression expr
	
	public ExprStmt(){}
	
	public ExprStmt(Expression expr){
		this.expr = expr
	}
	
	String toString(){
		return "${expr};"
	}
}
