package kalang.ast;
import java.util.*;
import kalang.core.*;
/**
 * The ElementExpr presents a element of a array,for example <code>args[i]</code>
 * 
 * @author Kason Yang <i@kasonyang.com>
 */
public class ElementExpr extends AssignableExpr{
    
    public ExprNode arrayExpr;
    
    public ExprNode index;
    
    
    public ElementExpr(){
        
    }
    
    
    public ElementExpr(ExprNode target,ExprNode key){
        
        
            this.arrayExpr = target;
        
            this.index = key;
        
    }
    
    
    public static ElementExpr create(){
        ElementExpr node = new ElementExpr();
        
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
        
        addChild(ls,arrayExpr);
        
        addChild(ls,index);
        
        return ls;
    }
    
}