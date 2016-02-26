
package kalang.ast;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import kalang.core.Type;
import kalang.core.Types;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class ArrayLengthExpr extends ExprNode{

    public ExprNode arrayExpr;

    public ArrayLengthExpr(ExprNode arrayExpr) {
        this.arrayExpr = arrayExpr;
    }
    
    @Override
    public Type getType() {
        return Types.INT_TYPE;
    }

}
