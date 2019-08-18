package kalang.compiler.compile;

import kalang.compiler.ast.ExprNode;

import javax.annotation.Nullable;

/**
 * expression creator
 * @author lbqh
 */
public interface ExprCreator {

    @Nullable
    ExprNode createExpr();

}
