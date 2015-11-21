package kalang.ast.stmt

import kalang.ast.expr.Expression

class WhileStmt extends Statement {
	public Expression testExpr
	public BlockStmt body
	
	String toString(){
		String code = "while(${testExpr})"
		if(body){
			code += "${body}"
		}
		code + ";"
	}
	
}
