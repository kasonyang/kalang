/*
Don't modify!This file is generated automately.
*/
package kalang.ast;
import java.util.*;
import kalang.core.*;
public class NewArrayExpr extends ExprNode{
    
    protected Type componentType;
    
    protected ExprNode size;
    
    
    public NewArrayExpr(){
        
    }
    
    
    public NewArrayExpr(Type type,ExprNode size){
        
        
            this.componentType = type;
        
            this.size = size;
        
    }
    
    
    public static NewArrayExpr create(){
        NewArrayExpr node = new NewArrayExpr();
        
        return node;
    }
    
    
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        
        return ls;
    }
    
    public String toString(){
        String str = "NewArrayExpr{\r\n";
        
        if(getComponentType()!=null){
            str += "  type:" + getComponentType().toString()+"\r\n";
        }
        
        if(getSize()!=null){
            str += "  size:" + getSize().toString()+"\r\n";
        }
        
        return str+"}";
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