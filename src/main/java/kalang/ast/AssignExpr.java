/*
Don't modify!This file is generated automately.
*/
package kalang.ast;
import java.util.*;
import kalang.core.*;
public class AssignExpr extends ExprNode{
    
    public ExprNode to;
    
    public ExprNode from;
    
    
    public AssignExpr(){
        
    }
    
    
    public AssignExpr(ExprNode to,ExprNode from){
        
        
            this.to = to;
        
            this.from = from;
        
    }
    
    
    public static AssignExpr create(){
        AssignExpr node = new AssignExpr();
        
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
        
        addChild(ls,to);
        
        addChild(ls,from);
        
        return ls;
    }
    
    public String toString(){
        String str = "AssignExpr{\r\n";
        
        if(to!=null){
            str += "  to:" + to.toString()+"\r\n";
        }
        
        if(from!=null){
            str += "  from:" + from.toString()+"\r\n";
        }
        
        return str+"}";
    }
}