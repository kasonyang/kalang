/*
Don't modify!This file is generated automately.
*/
package jast.ast;
import java.util.*;
public class FieldNode extends AstNode{
    
    public Integer modifier;
    
    public String type;
    
    public String name;
    
    public ExprNode initExpr;
    
    
    
    public FieldNode(Integer modifier=null,String type=null,String name=null,ExprNode initExpr=null){
        
            this.modifier = modifier;
        
            this.type = type;
        
            this.name = name;
        
            this.initExpr = initExpr;
        
    }
    
    
    public static FieldNode create(){
        FieldNode node = new FieldNode();
        
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
        
        addChild(ls,initExpr);
        
        return ls;
    }
    
    public String toString(){
        String str = "FieldNode{\r\n";
        
        str += "  modifier:" + modifier.toString()+"\r\n";
        
        str += "  type:" + type.toString()+"\r\n";
        
        str += "  name:" + name.toString()+"\r\n";
        
        str += "  initExpr:" + initExpr.toString()+"\r\n";
        
        return str+"}";
    }
}