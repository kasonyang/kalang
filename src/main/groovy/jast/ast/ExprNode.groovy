/*
Don't modify!This file is generated automately.
*/
package jast.ast;
import java.util.*;
public class ExprNode extends AstNode{
    
    
    
    
    public static ExprNode create(){
        ExprNode node = new ExprNode();
        
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
        String str = "ExprNode{\r\n";
        
        return str+"}";
    }
}