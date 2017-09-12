
package kalang.ast;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import kalang.core.Type;
import kalang.core.Types;
/**
 *
 * @author Kason Yang 
 */
public class InstanceOfExpr extends ExprNode{
    
    protected ClassReference target;
    
    protected ExprNode expr;

    public InstanceOfExpr(ExprNode expr, ClassReference target) {
        this.target = target;
        this.expr = expr;
    }
    
    @Override
    public Type getType() {
        return Types.BOOLEAN_TYPE;
    }

    public ClassReference getTarget() {
        return target;
    }

    public ExprNode getExpr() {
        return expr;
    }

}
