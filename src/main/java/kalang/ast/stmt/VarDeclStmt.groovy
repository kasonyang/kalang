package kalang.ast.stmt

import kalang.ast.expr.Expression
import kalang.ast.expr.VarExpr

class VarDeclStmt extends Statement {
	public VarExpr var
	public Expression initExpr
	
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
