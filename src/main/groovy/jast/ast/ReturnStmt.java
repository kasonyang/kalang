/*
Don't modify!This file is generated automately.
*/
package jast.ast;
import java.util.*;
public class ReturnStmt extends Statement{
    
    public ExprNode expr;
    
    
    public ReturnStmt(){
        
    }
    
    
    public ReturnStmt(ExprNode expr){
        
        
            this.expr = expr;
        
    }
    
    
    public static ReturnStmt create(){
        ReturnStmt node = new ReturnStmt();
        
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
        String str = "ReturnStmt{\r\n";
        
        str += "  expr:" + expr.toString()+"\r\n";
        
        return str+"}";
    }
}