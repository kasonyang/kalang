package kalang.ast;
import java.util.*;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import kalang.core.*;
import kalang.util.AstUtil;
public class InvocationExpr extends ExprNode{

    public static InvocationExpr create(ExprNode target, MethodNode methodNode) {
        return new InvocationExpr(target, methodNode.name);
    }
    
    /**
     * The target object to invoke
     */
    protected ExprNode target;
    
    /**
     * The method name of invocation
     */
    protected String methodName;
    
    protected ExprNode[] arguments;
    
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
        addChild(ls, getTarget());
        addChild(ls, getArguments());
        return ls;
    }
    
    @Nonnull
    public ClassType getTargetClassType(){
        Type targetType = getTarget().getType();
        if(!(targetType instanceof ClassType)){
            throw new UnsupportedOperationException("unsupported type:" + targetType);
        }
        return (ClassType) targetType;
    }
    
    @Nullable
    public Type[] getArgumentTypes(){
        if(getArguments()==null) return null;
        return AstUtil.getExprTypes(getArguments());
    }

    @Override
    public Type getType() {
        ClassNode clazz = getTargetClassType().getClassNode();
        MethodNode method = AstUtil.getMethod(clazz, getMethodName(),getArgumentTypes());
        if(method == null) return null;
        return method.type;
    }

    /**
     * @return the target
     */
    public ExprNode getTarget() {
        return target;
    }

    /**
     * @param target the target to set
     */
    public void setTarget(ExprNode target) {
        Objects.requireNonNull(target);
        this.target = target;
    }

    /**
     * @return the methodName
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * @param methodName the methodName to set
     */
    public void setMethodName(String methodName) {
        Objects.requireNonNull(methodName);
        this.methodName = methodName;
    }

    /**
     * @return the arguments
     */
    public ExprNode[] getArguments() {
        return arguments;
    }

    /**
     * @param arguments the arguments to set
     */
    public void setArguments(ExprNode[] arguments) {
        //Objects.requireNonNull(arguments);
        this.arguments = arguments;
    }
    
}