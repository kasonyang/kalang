/*
Don't modify!This file is generated automately.
*/
package jast.ast;
import java.util.*;
public class NewArrayExpr extends ExprNode{
    
    public String type;
    
    public ExprNode size;
    
    
    public NewArrayExpr(){
        
    }
    
    
    public NewArrayExpr(String type,ExprNode size){
        
        
            this.type = type;
        
            this.size = size;
        
    }
    
    
    public static NewArrayExpr create(){
        NewArrayExpr node = new NewArrayExpr();
        
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
        String str = "NewArrayExpr{\r\n";
        
        str += "  type:" + type.toString()+"\r\n";
        
        str += "  size:" + size.toString()+"\r\n";
        
        return str+"}";
    }
}