/*
Don't modify!This file is generated automately.
*/
package kalang.ast;
import java.util.*;
import kalang.core.*;
public class NewArrayExpr extends ExprNode{
    
    public Type type;
    
    public ExprNode size;
    
    
    public NewArrayExpr(){
        
    }
    
    
    public NewArrayExpr(Type type,ExprNode size){
        
        
            this.type = type;
        
            this.size = size;
        
    }
    
    
    public static NewArrayExpr create(){
        NewArrayExpr node = new NewArrayExpr();
        
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
        String str = "NewArrayExpr{\r\n";
        
        if(type!=null){
            str += "  type:" + type.toString()+"\r\n";
        }
        
        if(size!=null){
            str += "  size:" + size.toString()+"\r\n";
        }
        
        return str+"}";
    }
}