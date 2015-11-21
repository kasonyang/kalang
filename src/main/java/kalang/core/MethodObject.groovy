package kalang.core

import kalang.ast.stmt.Statement
import kalang.ast.stmt.VarDeclStmt

class MethodObject {
	String modifier
	String name
	String type
	boolean isStatic
	public final List<Statement> statements = []
	public final List<ArgumentObject> arguments = []
	MethodObject(String name,String type,String mdf,isStatic=false){
		this.name = name
		this.type  = type
		this.modifier = mdf
		this.isStatic = isStatic
	}
	
	String toString(){
		String stateStr = statements.join("\n")
		String args = this.arguments.join(",")
		String code =  """\
${modifier} ${type} ${name}(${args}){
  ${stateStr}
}
"""
		if(this.isStatic){
			code = 'static' + code;
		}
		return code;
	}
	
}
