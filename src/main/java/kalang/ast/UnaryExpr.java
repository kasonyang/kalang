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
            OPERATION_POS = "+",
            OPERATION_NOT = "!";
    
    protected ExprNode expr;
    
    protected String operation;
    
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
        
        addChild(ls, getExpr());
        
        return ls;
    }

    @Override
    public Type getType() {
        switch(getOperation()){
            case "!":return Types.BOOLEAN_TYPE;
            default:return getType(getExpr());
        }
    }

    /**
     * @return the expr
     */
    public ExprNode getExpr() {
        return expr;
    }

    /**
     * @param expr the expr to set
     */
    public void setExpr(ExprNode expr) {
        Objects.requireNonNull(expr);
        this.expr = expr;
    }

    /**
     * @return the operation
     */
    public String getOperation() {
        return operation;
    }

    /**
     * @param operation the operation to set
     */
    public void setOperation(String operation) {
        Objects.requireNonNull(operation);
        this.operation = operation;
    }
    
}