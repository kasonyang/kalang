package kalang.ast;
import java.util.*;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import kalang.core.*;
import kalang.util.AstUtil;
public class InvocationExpr extends ExprNode{
    
    /**
     * The target object to invoke
     */
    public ExprNode target;
    
    /**
     * The method name of invocation
     */
    public String methodName;
    
    public ExprNode[] arguments;
    
    public InvocationExpr(ExprNode target,String methodName){
        this(target, methodName, null);
    }
    
    public InvocationExpr(ExprNode target,String methodName, ExprNode[] arguments){
        this(target, methodName, arguments, null);
    }
    
    public InvocationExpr(ExprNode target,String methodName, ExprNode[] arguments,ClassNode specialClass){
            this.target = target;
            this.methodName = methodName;
            this.arguments = arguments;
    }
    
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        addChild(ls,target);
        addChild(ls,arguments);
        return ls;
    }
    
    @Nonnull
    public ClassType getTargetClassType(){
        Type targetType = target.getType();
        if(!(targetType instanceof ClassType)){
            throw new UnsupportedOperationException("unsupported type:" + targetType);
        }
        return (ClassType) targetType;
    }
    
    @Nullable
    public Type[] getArgumentTypes(){
        if(arguments==null) return null;
        return AstUtil.getExprTypes(arguments);
    }

    @Override
    public Type getType() {
        ClassNode clazz = getTargetClassType().getClassNode();
        MethodNode method = AstUtil.getMethod(clazz, methodName,getArgumentTypes());
        if(method == null) return null;
        return method.type;
    }
    
}