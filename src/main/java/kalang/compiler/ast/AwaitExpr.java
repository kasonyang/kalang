package kalang.compiler.ast;

import kalang.compiler.core.Type;
import kalang.compiler.util.AsyncUtil;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * @author KasonYang
 */
public class AwaitExpr extends ExprNode {

    private ExprNode expr;

    public AwaitExpr(ExprNode expr) {
        this.expr = expr;
    }

    @Nonnull
    @Override
    public Type getType() {
        Type exprType = expr.getType();
        return AsyncUtil.getAsyncResultType(exprType);
    }

    public ExprNode getExpr() {
        return expr;
    }

    public void setExpr(ExprNode expr) {
        this.expr = expr;
    }

    @Override
    public List<AstNode> getChildren() {
        return noNullChildren(expr);
    }

    @Override
    public void updateChildren(ChildUpdater childUpdater) {
        expr = doUpdateChild(expr, childUpdater);
    }
}
