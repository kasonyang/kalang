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
    public ExprNode expr1;
    
    @Nonnull
    public ExprNode expr2;
    
    @Nonnull
    public String operation;
    
    public BinaryExpr(@Nonnull ExprNode expr1,@Nonnull ExprNode expr2,@Nonnull String operation){
            this.expr1 = expr1;
            this.expr2 = expr2;
            this.operation = operation;
    }
    @Override
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        addChild(ls,expr1);
        addChild(ls,expr2);
        return ls;
    }

    @Override
    public Type getType() {
        return getType(expr1);
    }

}