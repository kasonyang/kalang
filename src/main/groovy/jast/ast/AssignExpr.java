/*
Don't modify!This file is generated automately.
*/
package jast.ast;
import java.util.*;
public class AssignExpr extends ExprNode{
    
    public ExprNode to;
    
    public ExprNode from;
    
    
    public AssignExpr(){
        
    }
    
    
    public AssignExpr(ExprNode to,ExprNode from){
        
        
            this.to = to;
        
            this.from = from;
        
    }
    
    
    public static AssignExpr create(){
        AssignExpr node = new AssignExpr();
        
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
        
        addChild(ls,to);
        
        addChild(ls,from);
        
        return ls;
    }
    
    public String toString(){
        String str = "AssignExpr{\r\n";
        
        str += "  to:" + to.toString()+"\r\n";
        
        str += "  from:" + from.toString()+"\r\n";
        
        return str+"}";
    }
}