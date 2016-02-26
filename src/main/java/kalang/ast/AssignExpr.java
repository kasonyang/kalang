/*
Don't modify!This file is generated automately.
*/
package kalang.ast;
import java.util.*;
import javax.annotation.Nonnull;
import kalang.core.*;
public class AssignExpr extends ExprNode{
    
    @Nonnull
    public AssignableExpr to;
    
    @Nonnull
    public ExprNode from;
    
    public AssignExpr(@Nonnull AssignableExpr to,@Nonnull ExprNode from){
            this.to = to;
            this.from = from;
    }
    

    
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        addChild(ls,to);
        addChild(ls,from);
        return ls;
    }

    @Override
    public Type getType() {
        if(to==null) return null;
        return to.getType();
    }
    
}