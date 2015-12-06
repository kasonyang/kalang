/*
Don't modify!This file is generated automately.
*/
package jast.ast;
import java.util.*;
public class CastExpr extends ExprNode{
    
    public String type;
    
    public ExprNode expr;
    
    
    
    public CastExpr(String type=null,ExprNode expr=null){
        
        
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
        
        str += "  type:" + type.toString()+"\r\n";
        
        str += "  expr:" + expr.toString()+"\r\n";
        
        return str+"}";
    }
}