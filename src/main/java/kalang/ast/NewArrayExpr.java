package kalang.ast;
import java.util.*;
import kalang.core.*;
public class NewArrayExpr extends ExprNode{
    
    protected Type componentType;
    
    protected ExprNode size;
    
    public NewArrayExpr(Type type,ExprNode size){
            this.componentType = type;
            this.size = size;
    }

    @Override
    public Type getType() {
        return Types.getArrayType(getComponentType());
    }

    /**
     * @return the componentType
     */
    public Type getComponentType() {
        return componentType;
    }

    /**
     * @param componentType the componentType to set
     */
    public void setComponentType(Type componentType) {
        Objects.requireNonNull(componentType);
        this.componentType = componentType;
    }

    /**
     * @return the size
     */
    public ExprNode getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(ExprNode size) {
        Objects.requireNonNull(size);
        this.size = size;
    }
    
}