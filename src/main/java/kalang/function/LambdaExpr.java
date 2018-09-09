package kalang.function;

import java.util.List;
import kalang.ast.MultiStmtExpr;
import kalang.ast.Statement;
import kalang.ast.VarExpr;

/**
 *
 * @author Kason Yang
 */
public class LambdaExpr extends MultiStmtExpr {

    private final VarExpr referenceVarExpr;

    public LambdaExpr(List<Statement> stmts, VarExpr referenceExpr) {
        super(stmts, referenceExpr);
        this.referenceVarExpr = referenceExpr;
    }

    public VarExpr getReferenceExpr() {
        return referenceVarExpr;
    }

}
