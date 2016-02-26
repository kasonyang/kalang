/*
Don't modify!This file is generated automately.
*/
package kalang.ast;
import java.util.*;
import kalang.core.*;
public class UnaryExpr extends ExprNode{
    
    public final static String
            //OPERATION_INC = "++",
            //OPERATION_DEC = "--",
            OPERATION_NEG = "-",
            OPERATION_POS = "+";
    
    public ExprNode expr;
    
    public String operation;
    
    public UnaryExpr(){
        
    }
    
    
    public UnaryExpr(ExprNode expr,String operation){
            this.expr = expr;
            this.operation = operation;
    }
    
    
    public static UnaryExpr create(){
        UnaryExpr node = new UnaryExpr();
        return node;
    }
    
    protected void addChild(List<AstNode> list,List nodes){
        if(nodes!=null) list.addAll(nodes);
    }
    
    protected void addChild(List<AstNode> list,AstNode node){
        if(node!=null) list.add(node);
    }
    
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        
        addChild(ls,expr);
        
        return ls;
    }

    @Override
    public Type getType() {
        switch(operation){
            case "!":return Types.BOOLEAN_TYPE;
            default:return getType(expr);
        }
    }
    
}