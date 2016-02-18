/*
Don't modify!This file is generated automately.
*/
package kalang.ast;
import java.util.*;
import kalang.core.*;
public abstract class VarObject extends AstNode{
    
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
}