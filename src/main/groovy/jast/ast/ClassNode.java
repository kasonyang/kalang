/*
Don't modify!This file is generated automately.
*/
package jast.ast;
import java.util.*;
public class ClassNode extends AstNode{
    
    public Integer modifier;
    
    public String name;
    
    public String parentName;
    
    public List<VarObject> fields;
    
    public List<MethodNode> methods;
    
    public List<String> interfaces;
    
    public Boolean isInterface;
    
    
    public ClassNode(){
        
            if(fields == null) fields = new LinkedList();
        
            if(methods == null) methods = new LinkedList();
        
            if(interfaces == null) interfaces = new LinkedList();
        
    }
    
    
    public ClassNode(Integer modifier,String name,String parentName,List<VarObject> fields,List<MethodNode> methods,List<String> interfaces,Boolean isInterface){
        
            if(fields == null) fields = new LinkedList();
        
            if(methods == null) methods = new LinkedList();
        
            if(interfaces == null) interfaces = new LinkedList();
        
        
            this.modifier = modifier;
        
            this.name = name;
        
            this.parentName = parentName;
        
            this.fields = fields;
        
            this.methods = methods;
        
            this.interfaces = interfaces;
        
            this.isInterface = isInterface;
        
    }
    
    
    public static ClassNode create(){
        ClassNode node = new ClassNode();
        
        node.fields = new LinkedList();
        
        node.methods = new LinkedList();
        
        node.interfaces = new LinkedList();
        
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
        
        addChild(ls,fields);
        
        addChild(ls,methods);
        
        return ls;
    }
    
    public String toString(){
        String str = "ClassNode{\r\n";
        
        if(modifier!=null){
            str += "  modifier:" + modifier.toString()+"\r\n";
        }
        
        if(name!=null){
            str += "  name:" + name.toString()+"\r\n";
        }
        
        if(parentName!=null){
            str += "  parentName:" + parentName.toString()+"\r\n";
        }
        
        if(fields!=null){
            str += "  fields:" + fields.toString()+"\r\n";
        }
        
        if(methods!=null){
            str += "  methods:" + methods.toString()+"\r\n";
        }
        
        if(interfaces!=null){
            str += "  interfaces:" + interfaces.toString()+"\r\n";
        }
        
        if(isInterface!=null){
            str += "  isInterface:" + isInterface.toString()+"\r\n";
        }
        
        return str+"}";
    }
}