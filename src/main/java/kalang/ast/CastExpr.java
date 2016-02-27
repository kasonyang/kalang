/*
Don't modify!This file is generated automately.
*/
package kalang.ast;
import java.util.*;
import kalang.core.*;
public class CastExpr extends ExprNode{
    
    protected Type toType;
    
    protected ExprNode expr;
    
    public CastExpr(Type type,ExprNode expr){
            this.toType = type;
            this.expr = expr;
    }
    
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        addChild(ls, getExpr());
        return ls;
    }
    
    @Override
    public Type getType() {
        return getToType();
    }

    /**
     * @return the toType
     */
    public Type getToType() {
        return toType;
    }

    /**
     * @param toType the toType to set
     */
    public void setToType(Type toType) {
        Objects.requireNonNull(toType);
        this.toType = toType;
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
        this.expr = expr;
    }
}