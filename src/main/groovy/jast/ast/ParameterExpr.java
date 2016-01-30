/*
Don't modify!This file is generated automately.
*/
package jast.ast;
import java.util.*;
public class ParameterExpr extends ExprNode{
    
    public VarObject parameter;
    
    
    public ParameterExpr(){
        
    }
    
    
    public ParameterExpr(VarObject parameter){
        
        
            this.parameter = parameter;
        
    }
    
    
    public static ParameterExpr create(){
        ParameterExpr node = new ParameterExpr();
        
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
        String str = "ParameterExpr{\r\n";
        
        if(parameter!=null){
            str += "  parameter:" + parameter.toString()+"\r\n";
        }
        
        return str+"}";
    }
}