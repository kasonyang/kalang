/*
Don't modify!This file is generated automately.
*/
package jast.ast;
import java.util.*;
public class ClassExpr extends ExprNode{
    
    public String name;
    
    
    public ClassExpr(){
        
    }
    
    
    public ClassExpr(String name){
        
        
            this.name = name;
        
    }
    
    
    public static ClassExpr create(){
        ClassExpr node = new ClassExpr();
        
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
        String str = "ClassExpr{\r\n";
        
        str += "  name:" + name.toString()+"\r\n";
        
        return str+"}";
    }
}