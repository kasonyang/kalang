package kalang.ast.stmt

import kalang.ast.expr.Expression

class FieldDeclStmt extends Statement {
	public String fieldName
	public String type
	public Expression initExpr
	String toString(){
		String code = "${type} ${fieldName}"
		if(initExpr){
			code+= "=${initExpr}"
		}
		return code + ';'
	}
}
