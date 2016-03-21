
package kalang.ast;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import kalang.compiler.MethodNotFoundException;
import kalang.core.ClassType;
import kalang.core.Type;
import kalang.util.AstUtil;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class NewObjectExpr extends ExprNode{

    protected ClassType objectType;
    
    protected InvocationExpr constructor;

    public NewObjectExpr(ClassType objectType, InvocationExpr constructor) {
        this.objectType = objectType;
        this.constructor = constructor;
    }
    
    public NewObjectExpr(ClassType objectType,ExprNode[] args) throws MethodNotFoundException {
        this.objectType = objectType;
        initDefaultConstructor(args);
    }
    
    public NewObjectExpr(ClassType objectType) throws MethodNotFoundException {
        this.objectType = objectType;
        initDefaultConstructor(null);
    }
    
    private void initDefaultConstructor(ExprNode[] args) throws MethodNotFoundException{
        constructor = 
                ObjectInvokeExpr.create(this, "<init>",args);
    }
    
    @Override
    public List<AstNode> getChildren() {
        return Collections.EMPTY_LIST;
        //return Collections.singletonList(constructor);
    }

    @Override
    public Type getType() {
        return getObjectType();
    }

    /**
     * @return the objectType
     */
    public ClassType getObjectType() {
        return objectType;
    }

    /**
     * @param objectType the objectType to set
     */
    public void setObjectType(ClassType objectType) {
        Objects.requireNonNull(objectType);
        this.objectType = objectType;
    }

    /**
     * @return the constructor
     */
    public InvocationExpr getConstructor() {
        return constructor;
    }

    /**
     * @param constructor the constructor to set
     */
    public void setConstructor(InvocationExpr constructor) {
        Objects.requireNonNull(constructor);
        this.constructor = constructor;
    }

}
