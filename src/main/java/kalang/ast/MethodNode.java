/*
Don't modify!This file is generated automately.
*/
package kalang.ast;
import java.util.*;
import kalang.core.*;
public class MethodNode extends AstNode{
    
    public int modifier;
    
    public Type type;
    
    public String name;
    
    public List<ParameterNode> parameters;
    
    public Statement body;
    
    public List<Type> exceptionTypes;
    
    public ClassNode classNode;
    
    
    protected MethodNode(ClassNode classNode){
            this.classNode = classNode;
            if(parameters == null) parameters = new LinkedList();
        
            if(exceptionTypes == null) exceptionTypes = new LinkedList();
        
    }
    
    
    protected MethodNode(ClassNode classNode,Integer modifier,Type type,String name,List<ParameterNode> parameters,Statement body,List<Type> exceptionTypes){
        this.classNode = classNode;
            if(parameters == null) parameters = new LinkedList();
        
            if(exceptionTypes == null) exceptionTypes = new LinkedList();
        
        
            this.modifier = modifier;
        
            this.type = type;
        
            this.name = name;
        
            this.parameters = parameters;
        
            this.body = body;
        
            this.exceptionTypes = exceptionTypes;
        
    }
    
    
    protected static MethodNode create(ClassNode classNode){
        MethodNode node = new MethodNode(classNode);
        
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
    
}