
package kalang.ast;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import kalang.core.ClassType;
import kalang.core.Type;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class NewObjectExpr extends ExprNode{

    public ClassType objectType;
    
    public ExprNode[] arguments;

    public NewObjectExpr(ClassType objectType, ExprNode[] arguments) {
        this.objectType = objectType;
        this.arguments = arguments;
    }
    
    public NewObjectExpr(ClassType objectType) {
        this.objectType = objectType;
    }

    public NewObjectExpr() {
        
    }
    
    @Override
    public List<AstNode> getChildren() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public Type getType() {
        return objectType;
    }

}
