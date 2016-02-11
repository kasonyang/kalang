/*
Don't modify!This file is generated automately.
*/
package jast.ast;
import java.util.*;
import kalang.core.*;
public class MethodNode extends AstNode{
    
    public Integer modifier;
    
    public Type type;
    
    public String name;
    
    public List<VarObject> parameters;
    
    public Statement body;
    
    public List<Type> exceptionTypes;
    
    
    public MethodNode(){
        
            if(parameters == null) parameters = new LinkedList();
        
            if(exceptionTypes == null) exceptionTypes = new LinkedList();
        
    }
    
    
    public MethodNode(Integer modifier,Type type,String name,List<VarObject> parameters,Statement body,List<Type> exceptionTypes){
        
            if(parameters == null) parameters = new LinkedList();
        
            if(exceptionTypes == null) exceptionTypes = new LinkedList();
        
        
            this.modifier = modifier;
        
            this.type = type;
        
            this.name = name;
        
            this.parameters = parameters;
        
            this.body = body;
        
            this.exceptionTypes = exceptionTypes;
        
    }
    
    
    public static MethodNode create(){
        MethodNode node = new MethodNode();
        
        node.parameters = new LinkedList();
        
        node.exceptionTypes = new LinkedList();
        
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
        
        if(modifier!=null){
            str += "  modifier:" + modifier.toString()+"\r\n";
        }
        
        if(type!=null){
            str += "  type:" + type.toString()+"\r\n";
        }
        
        if(name!=null){
            str += "  name:" + name.toString()+"\r\n";
        }
        
        if(parameters!=null){
            str += "  parameters:" + parameters.toString()+"\r\n";
        }
        
        if(body!=null){
            str += "  body:" + body.toString()+"\r\n";
        }
        
        if(exceptionTypes!=null){
            str += "  exceptionTypes:" + exceptionTypes.toString()+"\r\n";
        }
        
        return str+"}";
    }
}