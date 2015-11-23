package kalang.ast.expr

class InvocationExpr extends AstNode {
	public AstNode invocationTarget
	public String invocationMethod
	public List<AstNode> invocationArguments = []
	
	String toString(){
		def args = this.invocationArguments.join(",")
		return "${invocationTarget}.${invocationMethod}(${args})"		
	}
}
