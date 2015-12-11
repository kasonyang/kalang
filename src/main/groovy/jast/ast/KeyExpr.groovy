/*
Don't modify!This file is generated automately.
*/
package jast.ast;
import java.util.*;
public class KeyExpr extends ExprNode{
    
    public String key;
    
    
    
    public KeyExpr(String key=null){
        
        
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
        
        str += "  key:" + key.toString()+"\r\n";
        
        return str+"}";
    }
}