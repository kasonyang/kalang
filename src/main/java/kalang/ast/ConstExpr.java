package kalang.ast;
import javax.annotation.Nullable;
import kalang.core.*;
import kalang.exception.Exceptions;
public class ConstExpr extends ExprNode{
    
    @Nullable
    protected Object value;
    
    protected Type constType;

    public ConstExpr(@Nullable Object value) {
        Type t;
        if(value == null){
            t = Types.NULL_TYPE;
        }else{
            java.lang.Class<? extends Object> vt = value.getClass();
            if(vt.equals(Integer.class)){
                t = Types.INT_TYPE;
            }else if(vt.equals(Long.class)){
                t = Types.LONG_TYPE;
            }else if(vt.equals(Float.class)){
                t = Types.FLOAT_TYPE;
            }else if(vt.equals(Double.class)){
                t = Types.DOUBLE_TYPE;
            }else if(vt.equals(Byte.class)){
                t = Types.BYTE_TYPE;
            }else if(vt.equals(Boolean.class)){
                t = Types.BOOLEAN_TYPE;
            }else if(vt.equals(Short.class)){
                t = Types.SHORT_TYPE;
            }else if(vt.equals(Character.class)){
                t = Types.CHAR_TYPE;
            }else if(vt.equals(String.class)){
                t = Types.getStringClassType();
            }else if(vt.equals(ClassReference.class)){
                t = Types.getClassClassType();
            }else{
                throw Exceptions.unsupportedTypeException(value);
            }
        }
        constType = t;
        this.value  = value;
    }
    
    

    @Override
    public Type getType() {
        return constType;
    }

    /**
     * @return the value
     */
    @Nullable
    public Object getValue() {
        return value;
    }

    
}