package kalang.ast.expr

class FieldExpr extends Expression {
	public Expression target
	public String fieldName
	
	String toString(){
		return "${target}.${fieldName}"
	}
}
