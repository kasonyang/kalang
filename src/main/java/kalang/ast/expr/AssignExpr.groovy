package kalang.ast.expr

class AssignExpr  extends AstNode{
	public AstNode from
	public AstNode to
	
	String toString(){
		return "${to}=${from}"
	}
}
