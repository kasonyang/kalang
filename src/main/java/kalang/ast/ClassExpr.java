/*
Don't modify!This file is generated automately.
*/
package kalang.ast;
import java.util.*;
import kalang.core.*;
public class ClassExpr extends ExprNode{
    
    public String name;
    
    
    public ClassExpr(){
        
    }
    
    
    public ClassExpr(String name){
        
        
            this.name = name;
        
    }
    
    
    public static ClassExpr create(){
        ClassExpr node = new ClassExpr();
        
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
        String str = "ClassExpr{\r\n";
        
        if(name!=null){
            str += "  name:" + name.toString()+"\r\n";
        }
        
        return str+"}";
    }
}