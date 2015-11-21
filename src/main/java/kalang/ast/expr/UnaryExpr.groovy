package kalang.ast.expr

class UnaryExpr extends Expression {
	public Expression target
	public String operation
	public boolean leftOperate = false
	
	public UnaryExpr(){
		
	}
	
	public UnaryExpr(Expression target,String operation,boolean leftOperate){
		this.target = target
		this.operation = operation
		this.leftOperate = leftOperate
	}
	String toString(){
		if(this.leftOperate){
			return "${operation}${target}"
		}else{
			return "${target}${operation}"
		}
	}
}
