package kalang.ast.expr

class AssignExpr  extends Expression{
	public Expression from
	public Expression to
	
	String toString(){
		return "${to}=${from}"
	}
}
