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

class NameResolver extends AstVisitor {
	
	static class ResolveResult{
		List<NameExpr> fieldNames
		List<NameExpr> unresolvedNames
		Map<NameExpr,VarObject> vars
	}

	private VarTable<String> parentVarTable
	
	private VarTable<String> varTable ;
	
	private Map<NameExpr,VarObject> vars
	
	private List<String> fields = []
	
	private List<NameExpr> fieldNames;
	
	private List<NameExpr> unresolvedNames;
	
	public NameResolver(){
		this.parentVarTable = new VarTable();
	}
	
	public void setDefault(String name,VarObject var){
		this.parentVarTable.put(name,var)
	}

	public ResolveResult resolve(AstNode node){
		varTable = new VarTable(this.parentVarTable)
		vars = new HashMap();
		this.fieldNames = []
		this.unresolvedNames = []
		visit(node);
		def ret = new ResolveResult();
		ret.vars = vars
		ret.fieldNames = fieldNames
		ret.unresolvedNames = this.unresolvedNames
		//def vt = varTable;
		varTable = null;
		vars = null;
		this.fieldNames = null;
		this.unresolvedNames = null;
		return ret
		//return vt;
	}

	@Override
	public Object visitLoopStmt(LoopStmt node) {
		def oldVtb = varTable;
		varTable = new VarTable(oldVtb);
		this.visitChildren(node)
		varTable = oldVtb
	}

	@Override
	public Object visitNameExpr(NameExpr node) {
		String name = node.name;
		def var = varTable.get(name);
		if(var){
			vars.put(node,var)
		}else if(fields.contains(name)){
			fieldNames.add(node)
		}else{//unresolved name
			this.unresolvedNames.add(node)
		}
		return null;
	}

	@Override
	public Object visitVarDeclStmt(VarDeclStmt node) {
		def var = new VarObject();
		String name = var.name = node.varName;
		var.type = node.type;
		if(varTable.exist(node.varName)){
			println "duplicated var:${var.name}"
			return
		}
		varTable.put(node.varName,var)
		return null;
	}

	@Override
	public Object visitFieldNode(FieldNode node) {
		fields.add(node.name)
	}
	
}
