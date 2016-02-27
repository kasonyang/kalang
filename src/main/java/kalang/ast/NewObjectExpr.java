
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
    
    public InvocationExpr constructor;

    public NewObjectExpr(ClassType objectType, InvocationExpr constructor) {
        this.objectType = objectType;
        this.constructor = constructor;
    }
    
    public NewObjectExpr(ClassType objectType) {
        this.objectType = objectType;
    }
    
    @Override
    public List<AstNode> getChildren() {
        //TODO should constructor become a child
        return Collections.EMPTY_LIST;
    }

    @Override
    public Type getType() {
        return objectType;
    }

}
