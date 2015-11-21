package kalang.ast.stmt

class BlockStmt extends Statement {
	public List<Statement> statements = []
	
	String toString(){
		String code = ""
		for(def s in statements){
			code += s.toString()
		}
		return '{' + code + '}'
	}
}
