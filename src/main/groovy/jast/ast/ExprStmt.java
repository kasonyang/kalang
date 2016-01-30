/*
Don't modify!This file is generated automately.
*/
package jast.ast;
import java.util.*;
public class ExprStmt extends Statement{
    
    public ExprNode expr;
    
    
    public ExprStmt(){
        
    }
    
    
    public ExprStmt(ExprNode expr){
        
        
            this.expr = expr;
        
    }
    
    
    public static ExprStmt create(){
        ExprStmt node = new ExprStmt();
        
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
        String str = "ExprStmt{\r\n";
        
        if(expr!=null){
            str += "  expr:" + expr.toString()+"\r\n";
        }
        
        return str+"}";
    }
}