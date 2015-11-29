/*
Don't modify!This file is generated automately.
*/
package jast.ast;
import java.util.*;
public class UnaryExpr extends ExprNode{
    
    public ExprNode expr;
    
    public String preOperation;
    
    public String postOperation;
    
    
    
    public UnaryExpr(ExprNode expr=null,String preOperation=null,String postOperation=null){
        
            this.expr = expr;
        
            this.preOperation = preOperation;
        
            this.postOperation = postOperation;
        
    }
    
    
    public static UnaryExpr create(){
        UnaryExpr node = new UnaryExpr();
        
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
        
        addChild(ls,expr);
        
        return ls;
    }
    
    public String toString(){
        String str = "UnaryExpr{\r\n";
        
        str += "  expr:" + expr.toString()+"\r\n";
        
        str += "  preOperation:" + preOperation.toString()+"\r\n";
        
        str += "  postOperation:" + postOperation.toString()+"\r\n";
        
        return str+"}";
    }
}