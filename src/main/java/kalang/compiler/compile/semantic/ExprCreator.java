package kalang.compiler.compile.semantic;

import kalang.annotation.Nonnull;
import kalang.compiler.ast.ExprNode;

/**
 * expression creator
 * @author lbqh
 */
public interface ExprCreator {

    @Nonnull
    ExprNode createExpr();

}
