/*
Don't modify!This file is generated automately.
*/
package jast.ast;
import java.util.*;
public class ConstExpr extends ExprNode{
    
    public Object value;
    
    public String type;
    
    
    public ConstExpr(){
        
    }
    
    
    public ConstExpr(Object value,String type){
        
        
            this.value = value;
        
            this.type = type;
        
    }
    
    
    public static ConstExpr create(){
        ConstExpr node = new ConstExpr();
        
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
        String str = "ConstExpr{\r\n";
        
        if(value!=null){
            str += "  value:" + value.toString()+"\r\n";
        }
        
        if(type!=null){
            str += "  type:" + type.toString()+"\r\n";
        }
        
        return str+"}";
    }
}