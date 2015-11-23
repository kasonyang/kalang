package kalang.ast.stmt

import kalang.ast.expr.AstNode

class ExprStmt extends Statement {
	public AstNode expr
	
	public ExprStmt(){}
	
	public ExprStmt(Expression expr){
		this.expr = expr
	}
	
	String toString(){
		return "${expr};"
	}
}
