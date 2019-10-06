/*

*/
package kalang.compiler.ast;

import kalang.compiler.core.Type;

import java.util.LinkedList;
import java.util.List;
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
     * @return the expr
     */
    public ExprNode getExpr() {
        return expr;
    }

    @Override
    public String toString() {
        return "(" + toType + ")" + expr;
    }
}