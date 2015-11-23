package kalang.ast.expr

class FieldExpr extends AstNode {
	public AstNode target
	public String fieldName
	
	String toString(){
		return "${target}.${fieldName}"
	}
}
