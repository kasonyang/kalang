package kalang.compiler.ast;

import kalang.compiler.core.NullableKind;
import kalang.compiler.core.Type;
import kalang.compiler.core.Types;
import kalang.compiler.exception.Exceptions;

import javax.annotation.Nullable;
import java.util.Objects;

public class ConstExpr extends ExprNode{
    
    @Nullable
    protected String value;
    
    protected Type constType;

    public ConstExpr(int i) {
        this(Types.INT_TYPE, String.valueOf(i));
    }

    public ConstExpr(Object value) {
        Type t;
        String v = null;
        if(value == null){
            t = Types.NULL_TYPE;
        }else{
            if(value instanceof Integer){
                t = Types.INT_TYPE;
            }else if(value instanceof Long){
                t = Types.LONG_TYPE;
            }else if(value instanceof Float){
                t = Types.FLOAT_TYPE;
            }else if(value instanceof Double){
                t = Types.DOUBLE_TYPE;
            }else if(value instanceof Byte){
                t = Types.BYTE_TYPE;
            }else if(value instanceof Boolean){
                t = Types.BOOLEAN_TYPE;
            }else if(value instanceof Short){
                t = Types.SHORT_TYPE;
            }else if(value instanceof Character){
                t = Types.CHAR_TYPE;
            }else if(value instanceof String){
                t = Types.getStringClassType();
            }else if(value instanceof ClassReference) {
                t = Types.getClassClassType();
                v = ((ClassReference) value).getReferencedClassNode().name;
            } else if (value instanceof Class) {
                t = Types.getClassClassType();
                v = ((Class) value).getName();
            } else if (value instanceof Enum) {
                t = Types.requireClassType(Enum.class.getName(), NullableKind.UNKNOWN);
                v = ((Enum) value).name();
            }else{
                throw Exceptions.unsupportedTypeException(value);
            }
        }
        this.constType = t;
        this.value = v == null ? String.valueOf(value) : v;
    }

    public ConstExpr(String value) {
        this(Types.getStringClassType(), value);
        Objects.requireNonNull(value);
    }

    public ConstExpr(Type type) {
        this(type,"");
    }

    public ConstExpr(Type type,String value) {
        constType = type;
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
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}