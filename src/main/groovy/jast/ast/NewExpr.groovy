/*
Don't modify!This file is generated automately.
*/
package jast.ast;
import java.util.*;
public class NewExpr extends ExprNode{
    
    public String type;
    
    public List<ExprNode> arguments;
    
    
    
    public NewExpr(String type=null,List<ExprNode> arguments=null){
        
            if(arguments == null) arguments = new LinkedList();
        
        
            this.type = type;
        
            this.arguments = arguments;
        
    }
    
    
    public static NewExpr create(){
        NewExpr node = new NewExpr();
        
        node.arguments = new LinkedList();
        
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
        
        addChild(ls,arguments);
        
        return ls;
    }
    
    public String toString(){
        String str = "NewExpr{\r\n";
        
        str += "  type:" + type.toString()+"\r\n";
        
        str += "  arguments:" + arguments.toString()+"\r\n";
        
        return str+"}";
    }
}