package kalang.ast.stmt

import kalang.ast.expr.AstNode

class IfStmt {
	
	public AstNode testExpr
	
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
