package kalang.ast;
import java.util.*;
import javax.annotation.Nonnull;
import kalang.core.*;
/**
 * The base class of expression node
 * 
 * @author Kason Yang <i@kasonyang.com>
 */
public abstract class ExprNode extends AstNode{
    /**
     * The type of the expression
     */
    //protected Type type;

    /**
     * @return the type
     */
    @Nonnull
    public abstract Type getType();
    
    protected static Type getType(ExprNode expr){
        if(expr==null) return Types.VOID_TYPE;
        return expr.getType();
    }

    /**
     * @param type the type to set
     */
//    public void setType(Type type) {
//        this.type = type;
//    }
}