
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
