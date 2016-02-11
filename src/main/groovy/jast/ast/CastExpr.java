/*
Don't modify!This file is generated automately.
*/
package jast.ast;
import java.util.*;
import kalang.core.*;
public class CastExpr extends ExprNode{
    
    public Type type;
    
    public ExprNode expr;
    
    
    public CastExpr(){
        
    }
    
    
    public CastExpr(Type type,ExprNode expr){
        
        
            this.type = type;
        
            this.expr = expr;
        
    }
    
    
    public static CastExpr create(){
        CastExpr node = new CastExpr();
        
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
        
        return ls;
    }
    
    public String toString(){
        String str = "CastExpr{\r\n";
        
        if(type!=null){
            str += "  type:" + type.toString()+"\r\n";
        }
        
        if(expr!=null){
            str += "  expr:" + expr.toString()+"\r\n";
        }
        
        return str+"}";
    }
}