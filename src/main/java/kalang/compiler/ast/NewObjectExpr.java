
package kalang.compiler.ast;

import kalang.compiler.AmbiguousMethodException;
import kalang.compiler.MethodNotFoundException;
import kalang.compiler.core.ObjectType;
import kalang.compiler.core.Type;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
/**
 *
 * @author Kason Yang 
 */
public class NewObjectExpr extends ExprNode{

    protected ObjectType objectType;
    
    protected InvocationExpr constructor;

    public NewObjectExpr(ObjectType objectType, InvocationExpr constructor) {
        this.objectType = objectType;
        this.constructor = constructor;
    }
    
    public NewObjectExpr(ObjectType objectType,ExprNode[] args) throws MethodNotFoundException, AmbiguousMethodException {
        this(objectType,args,null);
    }
    
    public NewObjectExpr(ObjectType objectType) throws MethodNotFoundException, AmbiguousMethodException {
        this(objectType,new ExprNode[0],null);
    }
    
    public NewObjectExpr(ObjectType objectType,ExprNode[] args,@Nullable ClassNode caller) throws MethodNotFoundException, AmbiguousMethodException {
        this.objectType = objectType;
        initDefaultConstructor(args, caller);
    }
    
    private void initDefaultConstructor(ExprNode[] args,@Nullable ClassNode caller) throws MethodNotFoundException, AmbiguousMethodException{
        constructor = 
                ObjectInvokeExpr.create(this, "<init>",args,caller);
    }
    
    @Override
    public List<AstNode> getChildren() {
        return Arrays.asList(constructor.getArguments());
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
