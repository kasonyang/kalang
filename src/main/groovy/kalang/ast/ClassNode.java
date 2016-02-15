/*
Don't modify!This file is generated automately.
*/
package kalang.ast;
import java.util.*;
import kalang.core.*;
public class ClassNode extends AstNode{
    
    public Integer modifier;
    
    public String name;
    
    public ClassNode parent;
    
    public List<VarObject> fields;
    
    protected List<MethodNode> methods;
    
    public List<ClassNode> interfaces;
    
    public Boolean isInterface;
    
    public Boolean isArray;
    
    
    public ClassNode(){
        
            if(fields == null) fields = new LinkedList();
        
            if(methods == null) methods = new LinkedList();
        
            if(interfaces == null) interfaces = new LinkedList();
        
    }
    
    
    public ClassNode(Integer modifier,String name,ClassNode parent,List<VarObject> fields,List<MethodNode> methods,List<ClassNode> interfaces,Boolean isInterface,Boolean isArray){
        
            if(fields == null) fields = new LinkedList();
        
            if(methods == null) methods = new LinkedList();
        
            if(interfaces == null) interfaces = new LinkedList();
        
        
            this.modifier = modifier;
        
            this.name = name;
        
            this.parent = parent;
        
            this.fields = fields;
        
            this.methods = methods;
        
            this.interfaces = interfaces;
        
            this.isInterface = isInterface;
        
            this.isArray = isArray;
        
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
        
        if(parent!=null){
            str += "  parent:" + parent.toString()+"\r\n";
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
        
        if(isArray!=null){
            str += "  isArray:" + isArray.toString()+"\r\n";
        }
        
        return str+"}";
    }
    
    public MethodNode createMethodNode(){
        MethodNode md = MethodNode.create(this);
        methods.add(md);
        return md;
    }
    
    public MethodNode[] getMethodNodes(){
        return methods.toArray(new MethodNode[0]);
    }
    
}