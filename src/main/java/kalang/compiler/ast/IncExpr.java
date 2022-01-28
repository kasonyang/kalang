package kalang.compiler.ast;

import kalang.compiler.core.Type;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;

/**
 * @author KasonYang
 */
public class IncExpr extends ExprNode {

    private VarObject var;

    private ExprNode increment;

    private boolean isOperatorPrefixed;

    public IncExpr(VarObject varObject, ExprNode increment, boolean isPrefixedOperator) {
        this.var = varObject;
        this.increment = increment;
        this.isOperatorPrefixed = isPrefixedOperator;
    }

    public VarObject getVar() {
        return var;
    }

    public ExprNode getIncrement() {
        return increment;
    }

    public boolean isOperatorPrefixed() {
        return isOperatorPrefixed;
    }

    @Nonnull
    @Override
    public Type getType() {
        return var.getType();
    }

    @Override
    public List<AstNode> getChildren() {
        return Collections.singletonList(increment);
    }

    @Override
    public void updateChildren(ChildUpdater childUpdater) {
        increment = doUpdateChild(increment, childUpdater);
    }
}
