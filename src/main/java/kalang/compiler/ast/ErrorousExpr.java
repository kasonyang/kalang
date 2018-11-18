
package kalang.compiler.ast;

import kalang.compiler.core.Type;
import kalang.compiler.core.Types;

import java.util.Arrays;
import java.util.List;
/**
 *
 * @author Kason Yang 
 */
public class ErrorousExpr extends ExprNode{
    
    private AstNode[] children;

    public ErrorousExpr(AstNode... children) {
        this.children = children;
    }

    @Override
    public List<AstNode> getChildren() {
        return Arrays.asList(children);
    }

    @Override
    public Type getType() {
        return Types.getRootType();
    }

}
