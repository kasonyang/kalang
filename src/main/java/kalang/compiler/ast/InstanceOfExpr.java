
package kalang.compiler.ast;
import kalang.compiler.core.Type;
import kalang.compiler.core.Types;
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
