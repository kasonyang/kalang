package kalang.ast.stmt

import kalang.ast.expr.AstNode

class WhileStmt extends Statement {
	public AstNode testExpr
	public BlockStmt body
	
	String toString(){
		String code = "while(${testExpr})"
		if(body){
			code += "${body}"
		}
		code + ";"
	}
	
}
