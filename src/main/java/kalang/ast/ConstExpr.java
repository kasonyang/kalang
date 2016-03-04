/*

*/
package kalang.ast;
import java.util.*;
import kalang.core.*;
public class ConstExpr extends ExprNode{
    
    protected Object value;
    
    protected Type constType;
    
    
    public ConstExpr(){
        
    }
    
    
    public ConstExpr(Object value,Type type){
        
        
            this.value = value;
        
            this.constType = type;
        
    }
    
    
    public static ConstExpr create(){
        ConstExpr node = new ConstExpr();
        
        return node;
    }
    
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        
        return ls;
    }
    
    public String toString(){
        String str = "ConstExpr{\r\n";
        
        if(getValue()!=null){
            str += "  value:" + getValue().toString()+"\r\n";
        }
        
        if(getConstType()!=null){
            str += "  type:" + getConstType().toString()+"\r\n";
        }
        
        return str+"}";
    }

    @Override
    public Type getType() {
        return getConstType();
    }

    /**
     * @return the value
     */
    public Object getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * @return the constType
     */
    public Type getConstType() {
        return constType;
    }

    /**
     * @param constType the constType to set
     */
    public void setConstType(Type constType) {
        Objects.requireNonNull(constType);
        this.constType = constType;
    }
}