/*
Don't modify!This file is generated automately.
*/
package jast.ast;
import java.util.*;
public class BinaryExpr extends ExprNode{
    
    public ExprNode expr1;
    
    public ExprNode expr2;
    
    public String operation;
    
    
    
    public BinaryExpr(ExprNode expr1=null,ExprNode expr2=null,String operation=null){
        
        
            this.expr1 = expr1;
        
            this.expr2 = expr2;
        
            this.operation = operation;
        
    }
    
    
    public static BinaryExpr create(){
        BinaryExpr node = new BinaryExpr();
        
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
        
        addChild(ls,expr1);
        
        addChild(ls,expr2);
        
        return ls;
    }
    
    public String toString(){
        String str = "BinaryExpr{\r\n";
        
        str += "  expr1:" + expr1.toString()+"\r\n";
        
        str += "  expr2:" + expr2.toString()+"\r\n";
        
        str += "  operation:" + operation.toString()+"\r\n";
        
        return str+"}";
    }
}