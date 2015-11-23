package kalang.ast.stmt

import kalang.ast.expr.AstNode
import kalang.ast.expr.VarExpr

class AssignStmt extends Statement {
	public VarExpr toExpr
	public AstNode fromExpr
}
