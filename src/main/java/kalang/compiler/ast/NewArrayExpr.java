package kalang.compiler.ast;

import kalang.compiler.core.Type;
import kalang.compiler.core.Types;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
public class NewArrayExpr extends ExprNode{
    
    protected Type componentType;
    
    protected ExprNode[] sizes;

    public NewArrayExpr(Type componentType,ExprNode[] sizes){
        this.componentType = componentType;
        this.sizes = sizes;
    }

    public NewArrayExpr(Type componentType,ExprNode size){
        this(componentType, new ExprNode[]{size});
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
    public ExprNode[] getSizes() {
        return sizes;
    }

    /**
     * @param sizes the size to set
     */
    public void setSizes(ExprNode[] sizes) {
        Objects.requireNonNull(sizes);
        this.sizes = sizes;
    }

    @Override
    public List<AstNode> getChildren() {
        return Arrays.asList(sizes);
    }

    @Override
    public void updateChildren(ChildUpdater childUpdater) {
        doUpdateChildren(sizes, childUpdater);
    }
}