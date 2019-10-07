package kalang.compiler.ast;

import kalang.compiler.core.Type;
import kalang.compiler.core.Types;

import javax.annotation.Nullable;
import java.util.Objects;

public class ConstExpr extends ExprNode{
    
    @Nullable
    protected String value;
    
    protected Type constType;

    public ConstExpr(int i) {
        this(Types.INT_TYPE, String.valueOf(i));
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