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
    
    @Nonnull
    protected ExprNode expr1;
    
    @Nonnull
    protected ExprNode expr2;
    
    @Nonnull
    protected String operation;
    
    public BinaryExpr(@Nonnull ExprNode expr1,@Nonnull ExprNode expr2,@Nonnull String operation){
            this.expr1 = expr1;
            this.expr2 = expr2;
            this.operation = operation;
    }
    @Override
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        addChild(ls, getExpr1());
        addChild(ls, getExpr2());
        return ls;
    }

    @Override
    public Type getType() {
        return getType(getExpr1());
    }

    /**
     * @return the expr1
     */
    public ExprNode getExpr1() {
        return expr1;
    }

    /**
     * @param expr1 the expr1 to set
     */
    public void setExpr1(ExprNode expr1) {
        Objects.requireNonNull(expr1);
        this.expr1 = expr1;
    }

    /**
     * @return the expr2
     */
    public ExprNode getExpr2() {
        return expr2;
    }

    /**
     * @param expr2 the expr2 to set
     */
    public void setExpr2(ExprNode expr2) {
        Objects.requireNonNull(expr2);
        this.expr2 = expr2;
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