package kalang.ast.expr

class ConstExpr extends AstNode {
	public String value
	
	ConstExpr(String value){
		this.value = value
	}
	
	String toString(){
		return value
	}
}
