package kalang.ast.expr

class BinaryExpr extends AstNode {
	public AstNode expr1,expr2
	public String operation
	
	public BinaryExpr(){
		
	}
	
	public BinaryExpr(Expression expr1,Expression expr2,String op){
		this.expr1 = expr1;
		this.expr2 = expr2;
		this.operation = op;
	}
	
	String toString(){
		return "${expr1} ${operation} ${expr2}"
	}
}
