
package kalang.compiler.ast;
import kalang.compiler.core.Type;
/**
 *
 * @author Kason Yang 
 */
public class ArithmeticBinaryExpr extends BinaryExpr{

    public ArithmeticBinaryExpr(ExprNode expr1, ExprNode expr2, String operation) {
        super(expr1, expr2, operation);
    }
    
    @Override
    public Type getType() {
        return getType(getExpr1());
    }
    

}
