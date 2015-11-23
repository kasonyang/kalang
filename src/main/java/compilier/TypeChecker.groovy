package compilier

import jast.ast.AssignExpr;
import jast.ast.AstNode
import jast.ast.AstVisitor
import jast.ast.BinaryExpr;
import jast.ast.BlockStmt;
import jast.ast.BreakStmt;
import jast.ast.ClassNode;
import jast.ast.ConstExpr;
import jast.ast.ContinueStmt;
import jast.ast.ElementExpr;
import jast.ast.ExprStmt;
import jast.ast.FieldDeclStmt;
import jast.ast.FieldExpr;
import jast.ast.FieldNode;
import jast.ast.ForStmt;
import jast.ast.IfStmt;
import jast.ast.InvocationExpr;
import jast.ast.LoopStmt;
import jast.ast.MethodNode;
import jast.ast.NameExpr;
import jast.ast.ParameterNode;
import jast.ast.ReturnStmt;
import jast.ast.UnaryExpr;
import jast.ast.VarDeclStmt;
import jast.ast.WhileStmt;
import kalang.core.VarObject
import kalang.core.VarTable

class TypeChecker extends AstVisitor {

	private VarTable varTable ;

	public VarTable check(AstNode node){
		varTable = new VarTable()
		visit(node);
		def vt = varTable;
		varTable = null;
		return vt;
	}

	@Override
	public Object visitNameExpr(NameExpr node) {
		String name = node.name;
		if(!varTable.get(name)){
			System.err.println "undefined var:${name}"
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitVarDeclStmt(VarDeclStmt node) {
		def var = new VarObject();
		var.name = node.varName;
		var.type = node.type;
		varTable.put(node.varName,var)
		return null;
	}
}
