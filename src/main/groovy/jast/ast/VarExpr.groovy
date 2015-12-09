/*
Don't modify!This file is generated automately.
*/
package jast.ast;
import java.util.*;
public class VarExpr extends ExprNode{
    
    public VarObject var;
    
    
    
    public VarExpr(VarObject var=null){
        
        
            this.var = var;
        
    }
    
    
    public static VarExpr create(){
        VarExpr node = new VarExpr();
        
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
        String str = "VarExpr{\r\n";
        
        str += "  var:" + var.toString()+"\r\n";
        
        return str+"}";
    }
}