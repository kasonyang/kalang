package kalang.ast.expr

class VarExpr extends AstNode {
	
	public String varName
	
	String toString(){
		return "${varName}"
	}

}
