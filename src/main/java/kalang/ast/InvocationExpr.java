package kalang.ast;
import java.util.*;
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
    
    public List<ExprNode> arguments;
    
    public InvocationExpr(){
        
            if(arguments == null) arguments = new LinkedList();
        
    }
    
    
    public InvocationExpr(ExprNode target,String methodName,List<ExprNode> arguments){
        
            if(arguments == null) arguments = new LinkedList();
        
        
            this.target = target;
        
            this.methodName = methodName;
        
            this.arguments = arguments;
        
    }
    
    
    public static InvocationExpr create(){
        InvocationExpr node = new InvocationExpr();
        
        node.arguments = new LinkedList();
        
        return node;
    }
    
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        
        addChild(ls,target);
        
        addChild(ls,arguments);
        
        return ls;
    }
    
    public ClassType getTargetClassType(){
        Type targetType = target.getType();
        if(!(targetType instanceof ClassType)){
            throw new UnsupportedOperationException("unsupported type:" + targetType);
        }
        return (ClassType) targetType;
    }
    
    public Type[] getArgumentTypes(){
        return AstUtil.getExprTypes(arguments.toArray(new ExprNode[0]));
    }

    @Override
    public Type getType() {
        ClassNode clazz = getTargetClassType().getClassNode();
        MethodNode method = AstUtil.getMethod(clazz, methodName,getArgumentTypes());
        if(method == null) return null;
        return method.type;
    }
    
}