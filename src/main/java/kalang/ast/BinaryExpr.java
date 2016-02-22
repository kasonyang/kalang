/*
Don't modify!This file is generated automately.
*/
package kalang.ast;
import java.util.*;
import javax.annotation.Nonnull;
import kalang.core.*;
/**
 * BinaryExpr presents a binary operation, such as add,sub,multiply and so on
 * @author Kason Yang <i@kasonyang.com>
 */
public class BinaryExpr extends ExprNode{
    
    public ExprNode expr1 = null;
    
    public ExprNode expr2 = null;
    
    public String operation = null;
    
    
    public BinaryExpr(){
        
    }
    
    
    public BinaryExpr(@Nonnull ExprNode expr1,@Nonnull ExprNode expr2,@Nonnull String operation){
        
        
            this.expr1 = expr1;
        
            this.expr2 = expr2;
        
            this.operation = operation;
        
    }
    
    
    public static BinaryExpr create(){
        BinaryExpr node = new BinaryExpr();
        
        return node;
    }
    
    private void addChild(List<AstNode> list,List nodes){
        if(nodes!=null) list.addAll(nodes);
    }
    
    private void addChild(List<AstNode> list,AstNode node){
        if(node!=null) list.add(node);
    }
    
    @Override
    public List<AstNode> getChildren(){
        
        List<AstNode> ls = new LinkedList();
        
        addChild(ls,expr1);
        
        addChild(ls,expr2);
        
        return ls;
    }

}