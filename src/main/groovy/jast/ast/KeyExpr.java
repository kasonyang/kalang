/*
Don't modify!This file is generated automately.
*/
package jast.ast;
import java.util.*;
import kalang.core.*;
public class KeyExpr extends ExprNode{
    
    public String key;
    
    
    public KeyExpr(){
        
    }
    
    
    public KeyExpr(String key){
        
        
            this.key = key;
        
    }
    
    
    public static KeyExpr create(){
        KeyExpr node = new KeyExpr();
        
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
        String str = "KeyExpr{\r\n";
        
        if(key!=null){
            str += "  key:" + key.toString()+"\r\n";
        }
        
        return str+"}";
    }
}