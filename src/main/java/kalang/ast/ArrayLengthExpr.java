
package kalang.ast;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import javax.annotation.Nonnull;
import kalang.core.Type;
import kalang.core.Types;
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

}
