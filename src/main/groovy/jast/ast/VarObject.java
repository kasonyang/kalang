/*
Don't modify!This file is generated automately.
*/
package jast.ast;
import java.util.*;
public class VarObject extends AstNode{
    
    public Integer modifier;
    
    public String type;
    
    public String name;
    
    public ExprNode initExpr;
    
    
    public VarObject(){
        
    }
    
    
    public VarObject(Integer modifier,String type,String name,ExprNode initExpr){
        
        
            this.modifier = modifier;
        
            this.type = type;
        
            this.name = name;
        
            this.initExpr = initExpr;
        
    }
    
    
    public static VarObject create(){
        VarObject node = new VarObject();
        
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
        String str = "VarObject{\r\n";
        
        str += "  modifier:" + modifier.toString()+"\r\n";
        
        str += "  type:" + type.toString()+"\r\n";
        
        str += "  name:" + name.toString()+"\r\n";
        
        str += "  initExpr:" + initExpr.toString()+"\r\n";
        
        return str+"}";
    }
}