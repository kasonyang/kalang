
package kalang.ast;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import kalang.core.ClassType;
import kalang.core.Type;
import kalang.util.AstUtil;
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
        MethodNode methodNode = AstUtil.getMethod(objectType.getClassNode(), "<init>", null);
        constructor = new InvocationExpr(this, "<init>");
    }
    
    @Override
    public List<AstNode> getChildren() {
        return Collections.EMPTY_LIST;
        //return Collections.singletonList(constructor);
    }

    @Override
    public Type getType() {
        return objectType;
    }

}
