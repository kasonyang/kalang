package kalang.ast.expr

class VarExpr extends Expression {
	
	public String varName
	
	String toString(){
		return "${varName}"
	}

}
