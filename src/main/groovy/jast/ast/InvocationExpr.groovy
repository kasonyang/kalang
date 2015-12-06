/*
Don't modify!This file is generated automately.
*/
package jast.ast;
import java.util.*;
public class InvocationExpr extends ExprNode{
    
    public ExprNode target;
    
    public String methodName;
    
    public List<ExprNode> arguments;
    
    
    
    public InvocationExpr(ExprNode target=null,String methodName=null,List<ExprNode> arguments=null){
        
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
    
    public String toString(){
        String str = "InvocationExpr{\r\n";
        
        str += "  target:" + target.toString()+"\r\n";
        
        str += "  methodName:" + methodName.toString()+"\r\n";
        
        str += "  arguments:" + arguments.toString()+"\r\n";
        
        return str+"}";
    }
}