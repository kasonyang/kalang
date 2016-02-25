
package kalang.ast;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class IncrementExpr extends ExprNode{
    
    public AssignableExpr expr;
    
    public boolean isDesc = false;
    
    public boolean isPrefix = false;

    @Override
    public List<AstNode> getChildren() {
        return Collections.singletonList(expr);
    }

    public IncrementExpr(AssignableExpr expr,boolean isDesc,boolean isPrefix) {
        this.expr = expr;
        this.isDesc = isDesc;
        this.isPrefix = isPrefix;
    }

    public IncrementExpr(AssignableExpr expr) {
        this.expr = expr;
    }

}
