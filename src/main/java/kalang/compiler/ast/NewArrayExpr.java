package kalang.compiler.ast;

import kalang.compiler.core.Type;
import kalang.compiler.core.Types;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
public class NewArrayExpr extends ExprNode{
    
    protected Type componentType;
    
    protected ExprNode size;
    
    public NewArrayExpr(Type componentType,ExprNode size){
            this.componentType = componentType;
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

    @Override
    public List<AstNode> getChildren() {
        return Collections.singletonList(size);
    }
}