package kalang.ast;
import java.util.*;
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
    public Type type;
}