/*
Don't modify!This file is generated automately.
*/
package kalang.ast;
import java.util.*;
import kalang.core.*;
public class CastExpr extends ExprNode{
    
    public Type toType;
    
    public ExprNode expr;
    
    public CastExpr(Type type,ExprNode expr){
            this.toType = type;
            this.expr = expr;
    }
    
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        addChild(ls,expr);
        return ls;
    }
    
    @Override
    public Type getType() {
        return toType;
    }
}