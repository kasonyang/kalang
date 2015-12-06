/*
Don't modify!This file is generated automately.
*/
package jast.ast;
import java.util.*;
public class FieldExpr extends ExprNode{
    
    public ExprNode target;
    
    public String fieldName;
    
    
    
    public FieldExpr(ExprNode target=null,String fieldName=null){
        
        
            this.target = target;
        
            this.fieldName = fieldName;
        
    }
    
    
    public static FieldExpr create(){
        FieldExpr node = new FieldExpr();
        
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
        
        return ls;
    }
    
    public String toString(){
        String str = "FieldExpr{\r\n";
        
        str += "  target:" + target.toString()+"\r\n";
        
        str += "  fieldName:" + fieldName.toString()+"\r\n";
        
        return str+"}";
    }
}