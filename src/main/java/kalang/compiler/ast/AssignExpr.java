/*

*/
package kalang.compiler.ast;

import kalang.compiler.core.Type;

import javax.annotation.Nonnull;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
public class AssignExpr extends ExprNode{
    
    @Nonnull
    protected AssignableExpr to;
    
    @Nonnull
    protected ExprNode from;
    
    public AssignExpr(@Nonnull AssignableExpr to,@Nonnull ExprNode from){
            this.to = to;
            this.from = from;
    }
    

    
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        addChild(ls, getTo());
        addChild(ls, getFrom());
        return ls;
    }

    @Override
    public Type getType() {
        return getType(getTo());
    }

    /**
     * @return the to
     */
    public AssignableExpr getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    public void setTo(AssignableExpr to) {
        Objects.requireNonNull(to);
        this.to = to;
    }

    /**
     * @return the from
     */
    public ExprNode getFrom() {
        return from;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(ExprNode from) {
        Objects.requireNonNull(from);
        this.from = from;
    }
    
}