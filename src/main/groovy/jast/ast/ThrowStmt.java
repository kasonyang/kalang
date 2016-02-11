/*
Don't modify!This file is generated automately.
*/
package jast.ast;
import java.util.*;
import kalang.core.*;
public class ThrowStmt extends Statement{
    
    public ExprNode expr;
    
    
    public ThrowStmt(){
        
    }
    
    
    public ThrowStmt(ExprNode expr){
        
        
            this.expr = expr;
        
    }
    
    
    public static ThrowStmt create(){
        ThrowStmt node = new ThrowStmt();
        
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
        String str = "ThrowStmt{\r\n";
        
        if(expr!=null){
            str += "  expr:" + expr.toString()+"\r\n";
        }
        
        return str+"}";
    }
}