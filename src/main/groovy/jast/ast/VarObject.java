/*
Don't modify!This file is generated automately.
*/
package jast.ast;
import java.util.*;
import kalang.core.*;
public class VarObject extends AstNode{
    
    public Integer modifier;
    
    public Type type;
    
    public String name;
    
    public ExprNode initExpr;
    
    
    public VarObject(){
        
    }
    
    
    public VarObject(Integer modifier,Type type,String name,ExprNode initExpr){
        
        
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
        
        if(modifier!=null){
            str += "  modifier:" + modifier.toString()+"\r\n";
        }
        
        if(type!=null){
            str += "  type:" + type.toString()+"\r\n";
        }
        
        if(name!=null){
            str += "  name:" + name.toString()+"\r\n";
        }
        
        if(initExpr!=null){
            str += "  initExpr:" + initExpr.toString()+"\r\n";
        }
        
        return str+"}";
    }
}