
package kalang.compiler.ast;

import kalang.compiler.core.Type;
import kalang.compiler.core.Types;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Objects;
/**
 *
 * @author Kason Yang 
 */
public class ArrayLengthExpr extends ExprNode{

    @Nonnull
    protected ExprNode arrayExpr;

    public ArrayLengthExpr(@Nonnull ExprNode arrayExpr) {
        this.arrayExpr = arrayExpr;
    }
    
    @Override
    public Type getType() {
        return Types.INT_TYPE;
    }

    /**
     * @return the arrayExpr
     */
    public ExprNode getArrayExpr() {
        return arrayExpr;
    }

    /**
     * @param arrayExpr the arrayExpr to set
     */
    public void setArrayExpr(@Nonnull ExprNode arrayExpr) {
        Objects.requireNonNull(arrayExpr);
        this.arrayExpr = arrayExpr;
    }

    @Override
    public String toString() {
        return arrayExpr + ".length";
    }

    @Override
    public List<AstNode> getChildren() {
        return noNullChildren(arrayExpr);
    }

    @Override
    public void updateChildren(ChildUpdater childUpdater) {
        arrayExpr = doUpdateChild(arrayExpr, childUpdater);
    }
}
