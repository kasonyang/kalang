/*

*/
package kalang.compiler.ast;

import javax.annotation.Nonnull;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
/**
 * BinaryExpr presents a binary operation, such as add,sub,multiply and so on
 * @author Kason Yang 
 */
public abstract class BinaryExpr extends ExprNode{
    
    public static final String
            //Math
            OP_ADD = "+",
            OP_SUB = "-",
            OP_MUL = "*",
            OP_DIV = "/",
            OP_REM = "%",
            //Bitwise
            OP_AND = "&",
            OP_OR = "|",
            OP_XOR = "^",
            OP_SHIFT_LEFT = "<<",
            OP_SHIFT_RIGHT = ">>",
            //Compare
            OP_LE = "<=",
            OP_GE = ">=",
            OP_LT = "<",
            OP_GT = ">",
            OP_EQ = "==",
            OP_NE = "!=",
            //Logic
            OP_LOGIC_AND = "&&",
            OP_LOGIC_OR = "||"
            ;
            
    
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

}