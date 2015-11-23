package kalang.ast.stmt

import kalang.ast.expr.AstNode
import kalang.ast.expr.VarExpr

class VarDeclStmt extends Statement {
	public VarExpr var
	public AstNode initExpr
	
	String toString(){
		String type = var.type
		String name = var.varName
		String code = "${type} ${name}"
		if(initExpr){
			code += initExpr.toString()
		}
		return code + ";"
	}
	
}
