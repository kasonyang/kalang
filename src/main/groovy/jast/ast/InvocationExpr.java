/*
Don't modify!This file is generated automately.
*/
package jast.ast;
import java.util.*;
import kalang.core.*;
public class InvocationExpr extends ExprNode{
    
    public ExprNode target;
    
    public String methodName;
    
    public List<ExprNode> arguments;
    
    public MethodNode matchedMethod;
    
    
    public InvocationExpr(){
        
            if(arguments == null) arguments = new LinkedList();
        
    }
    
    
    public InvocationExpr(ExprNode target,String methodName,List<ExprNode> arguments,MethodNode matchedMethod){
        
            if(arguments == null) arguments = new LinkedList();
        
        
            this.target = target;
        
            this.methodName = methodName;
        
            this.arguments = arguments;
        
            this.matchedMethod = matchedMethod;
        
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
        
        if(target!=null){
            str += "  target:" + target.toString()+"\r\n";
        }
        
        if(methodName!=null){
            str += "  methodName:" + methodName.toString()+"\r\n";
        }
        
        if(arguments!=null){
            str += "  arguments:" + arguments.toString()+"\r\n";
        }
        
        if(matchedMethod!=null){
            str += "  matchedMethod:" + matchedMethod.toString()+"\r\n";
        }
        
        return str+"}";
    }
}