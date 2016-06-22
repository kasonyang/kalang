
package kalang.ast;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import kalang.AmbiguousMethodException;
import kalang.MethodNotFoundException;
import kalang.core.ObjectType;
import kalang.core.Type;
import kalang.util.AstUtil;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class NewObjectExpr extends ExprNode{

    protected ObjectType objectType;
    
    protected InvocationExpr constructor;

    public NewObjectExpr(ObjectType objectType, InvocationExpr constructor) {
        this.objectType = objectType;
        this.constructor = constructor;
    }
    
    public NewObjectExpr(ObjectType objectType,ExprNode[] args) throws MethodNotFoundException, AmbiguousMethodException {
        this.objectType = objectType;
        initDefaultConstructor(args);
    }
    
    public NewObjectExpr(ObjectType objectType) throws MethodNotFoundException, AmbiguousMethodException {
        this.objectType = objectType;
        initDefaultConstructor(null);
    }
    
    private void initDefaultConstructor(ExprNode[] args) throws MethodNotFoundException, AmbiguousMethodException{
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
    public ObjectType getObjectType() {
        return objectType;
    }

    /**
     * @param objectType the objectType to set
     */
    public void setObjectType(ObjectType objectType) {
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
