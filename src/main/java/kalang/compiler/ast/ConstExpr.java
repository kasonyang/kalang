package kalang.compiler.ast;

import kalang.compiler.core.NullableKind;
import kalang.compiler.core.PrimitiveType;
import kalang.compiler.core.Type;
import kalang.compiler.core.Types;
import kalang.compiler.util.Exceptions;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ConstExpr extends ExprNode{
    
    @Nullable
    protected Object value;
    
    protected Type constType;

    public ConstExpr(Object value) {
        Type t;
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
            }else if(value instanceof Type) {
                if (Types.NULL_TYPE.equals(value)) {
                    throw Exceptions.unexpectedValue(value);
                }
                Type typeArg = value instanceof PrimitiveType ? Types.getClassType((PrimitiveType) value) : (Type) value;
                t = Types.getClassType(Types.getClassClassType().getClassNode(), new Type[]{typeArg});
            } else if (value instanceof Class) { // compatible with annotation
                t = Types.getClassClassType();
                value = t;
            } else if (value instanceof Enum) {// compatible with annotation
                t = Types.requireClassType(Enum.class.getName(), NullableKind.UNKNOWN);
            } else{
                throw Exceptions.unsupportedTypeException(value);
            }
        }
        this.constType = t;
        this.value = value;
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

    @Override
    public String toString() {
        return Objects.toString(value);
    }

    @Override
    public List<AstNode> getChildren() {
        return Collections.emptyList();
    }

    @Override
    public void updateChildren(ChildUpdater childMapper) {

    }
}