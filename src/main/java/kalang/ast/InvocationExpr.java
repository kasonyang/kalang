package kalang.ast;
import java.util.*;
import kalang.core.*;
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
    
    private void addChild(List<AstNode> list,List nodes){
        if(nodes!=null) list.addAll(nodes);
    }
    
    private void addChild(List<AstNode> list,AstNode node){
        if(node!=null) list.add(node);
    }
    
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        
        addChild(ls,target);
        
        addChild(ls,arguments);
        
        return ls;
    }
    
}