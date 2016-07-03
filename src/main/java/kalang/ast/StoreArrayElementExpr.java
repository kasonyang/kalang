package kalang.ast;

import kalang.core.ArrayType;
import kalang.core.Type;
import kalang.exception.Exceptions;

/**
 *
 * @author Kason Yang
 */
public class StoreArrayElementExpr extends ExprNode {
    
    private VarObject array;
    
    private ExprNode index;
    
    private ExprNode from;

    public StoreArrayElementExpr(VarObject array, ExprNode index, ExprNode from) {
        if(!(array.type instanceof ArrayType)){
            throw Exceptions.illegalArgument(array);
        }
        this.array = array;
        this.index = index;
        this.from = from;
    }

    @Override
    public Type getType() {
        return ((ArrayType)array.type).getComponentType();
    }

    public VarObject getArray() {
        return array;
    }

    public ExprNode getIndex() {
        return index;
    }

    public ExprNode getFrom() {
        return from;
    }
    
    

}
