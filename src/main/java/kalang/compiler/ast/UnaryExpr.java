package kalang.compiler.ast;

import kalang.compiler.core.Type;
import kalang.compiler.core.Types;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
public class UnaryExpr extends ExprNode{
    
    public final static String
            //OPERATION_INC = "++",
            //OPERATION_DEC = "--",
            OPERATION_NEG = "-",
            OPERATION_POS = "+",
            OPERATION_LOGIC_NOT = "!",
            OPERATION_NOT = "~" ;
    
    protected ExprNode expr;
    
    protected String operation;
    
    public UnaryExpr(ExprNode expr,String operation){
            this.expr = expr;
            this.operation = operation;
    }
    
    @Override
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        addChild(ls, getExpr());
        return ls;
    }

    @Override
    public Type getType() {
        if ("!".equals(getOperation())) {
            return Types.BOOLEAN_TYPE;
        }
        return getType(getExpr());
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

    @Override
    public String toString() {
        return operation + expr;
    }
}