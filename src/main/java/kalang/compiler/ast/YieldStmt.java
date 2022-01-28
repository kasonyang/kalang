package kalang.compiler.ast;

import java.util.Collections;
import java.util.List;

/**
 * @author KasonYang
 */
public class YieldStmt extends Statement {

    private ExprNode expr;

    public YieldStmt(ExprNode expr) {
        this.expr = expr;
    }

    public ExprNode getExpr() {
        return expr;
    }

    @Override
    public List<AstNode> getChildren() {
        return Collections.singletonList(expr);
    }

    @Override
    public void updateChildren(ChildUpdater childUpdater) {
        expr = doUpdateChild(expr, childUpdater);
    }
}
