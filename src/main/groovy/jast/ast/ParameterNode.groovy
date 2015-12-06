/*
Don't modify!This file is generated automately.
*/
package jast.ast;
import java.util.*;
public class ParameterNode extends AstNode{
    
    public String type;
    
    public String name;
    
    
    
    public ParameterNode(String type=null,String name=null){
        
        
            this.type = type;
        
            this.name = name;
        
    }
    
    
    public static ParameterNode create(){
        ParameterNode node = new ParameterNode();
        
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
        String str = "ParameterNode{\r\n";
        
        str += "  type:" + type.toString()+"\r\n";
        
        str += "  name:" + name.toString()+"\r\n";
        
        return str+"}";
    }
}