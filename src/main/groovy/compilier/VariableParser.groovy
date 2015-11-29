package compilier

import jast.ast.AstVisitor
import jast.ast.ClassNode
import jast.ast.VarDeclStmt;
import kalang.core.VarObject

class VariableParser extends AstVisitor {

	HashMap<Integer,VarObject> vars;
	
	public HashMap<Integer,VarObject>parse(ClassNode clsNode){
		vars = new HashMap();
		visit(clsNode)
		return vars
	}
	
	@Override
	public Object visitVarDeclStmt(VarDeclStmt node) {
		VarObject var = new VarObject();
		var.id = node.varId
		var.name = node.varName
		var.type = node.type
		vars.put(var.id,var)
	}

}
