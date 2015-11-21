package kalang.ast.stmt

import kalang.ast.expr.Expression
import kalang.ast.expr.VarExpr

class AssignStmt extends Statement {
	public VarExpr toExpr
	public Expression fromExpr
}
