package kalang.ast.stmt

import kalang.ast.expr.Expression

class IfStmt {
	
	public Expression testExpr
	
	public BlockStmt trueStmt
	
	public BlockStmt falseStmt
	
	String toString(){
		String code = "if(${testExpr}) ${trueStmt}"
		if(falseStmt){
			code+= " else ${falseStmt}"
		}
		code + ';'
	}

}
