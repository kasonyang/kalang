/*
Don't modify!This file is generated automately.
*/
package jast.ast;
import java.util.*;
import kalang.core.*;
public class ElementExpr extends ExprNode{
    
    public ExprNode target;
    
    public ExprNode key;
    
    
    public ElementExpr(){
        
    }
    
    
    public ElementExpr(ExprNode target,ExprNode key){
        
        
            this.target = target;
        
            this.key = key;
        
    }
    
    
    public static ElementExpr create(){
        ElementExpr node = new ElementExpr();
        
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
        
        addChild(ls,key);
        
        return ls;
    }
    
    public String toString(){
        String str = "ElementExpr{\r\n";
        
        if(target!=null){
            str += "  target:" + target.toString()+"\r\n";
        }
        
        if(key!=null){
            str += "  key:" + key.toString()+"\r\n";
        }
        
        return str+"}";
    }
}