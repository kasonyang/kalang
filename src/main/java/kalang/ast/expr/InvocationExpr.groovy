package kalang.ast.expr

class InvocationExpr extends Expression {
	public Expression invocationTarget
	public String invocationMethod
	public List<Expression> invocationArguments = []
	
	String toString(){
		def args = this.invocationArguments.join(",")
		return "${invocationTarget}.${invocationMethod}(${args})"		
	}
}
