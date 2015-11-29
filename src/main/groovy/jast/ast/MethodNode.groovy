/*
Don't modify!This file is generated automately.
*/
package jast.ast;
import java.util.*;
public class MethodNode extends AstNode{
    
    public Integer modifier;
    
    public String type;
    
    public String name;
    
    public boolean isStatic;
    
    public List<ParameterNode> parameters;
    
    public Statement body;
    
    
    
    public MethodNode(Integer modifier=null,String type=null,String name=null,boolean isStatic=null,List<ParameterNode> parameters=null,Statement body=null){
        
            this.modifier = modifier;
        
            this.type = type;
        
            this.name = name;
        
            this.isStatic = isStatic;
        
            this.parameters = parameters;
        
            this.body = body;
        
    }
    
    
    public static MethodNode create(){
        MethodNode node = new MethodNode();
        
        node.parameters = new LinkedList();
        
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
        
        addChild(ls,parameters);
        
        addChild(ls,body);
        
        return ls;
    }
    
    public String toString(){
        String str = "MethodNode{\r\n";
        
        str += "  modifier:" + modifier.toString()+"\r\n";
        
        str += "  type:" + type.toString()+"\r\n";
        
        str += "  name:" + name.toString()+"\r\n";
        
        str += "  isStatic:" + isStatic.toString()+"\r\n";
        
        str += "  parameters:" + parameters.toString()+"\r\n";
        
        str += "  body:" + body.toString()+"\r\n";
        
        return str+"}";
    }
}