package kalang.ast.stmt

import kalang.ast.expr.AstNode

class FieldDeclStmt extends Statement {
	public String fieldName
	public String type
	public AstNode initExpr
	String toString(){
		String code = "${type} ${fieldName}"
		if(initExpr){
			code+= "=${initExpr}"
		}
		return code + ';'
	}
}
