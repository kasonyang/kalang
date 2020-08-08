
package kalang.compiler.core;
import kalang.compiler.util.AstUtil;

import java.util.Objects;

/**
 *
 * @author Kason Yang
 */
public class ArrayType extends ObjectType{

    private Type componentType;

    public ArrayType(Type componentType,NullableKind nullable) {
        super(AstUtil.createArrayAst(Types.ROOT_CLASS_NAME),nullable);
        this.componentType = componentType;
    }
    
    @Override
    public String getName(boolean simple) {
        return componentType.getName(simple) + "[]" + getNullableSuffix();
    }

    public Type getComponentType() {
        return componentType;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ArrayType)) {
            return false;
        }
        return nullable.equals(obj) && equalsIgnoreNullable((ArrayType) obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(componentType) * 31 + Objects.hash(nullable);
    }

    @Override
    public boolean equalsIgnoreNullable(ObjectType other) {
        if (!(other instanceof ArrayType)) {
            return false;
        }
        Type otherComponentType = ((ArrayType) other).getComponentType();
        if (componentType instanceof ObjectType && otherComponentType instanceof ObjectType) {
            return ((ObjectType) componentType).equalsIgnoreNullable((ObjectType) otherComponentType);
        }
        return componentType.equals(otherComponentType);
    }

    @Override
    public boolean isAssignableFrom(Type type) {
        if(equalAndNullAssignChecked(type)) return true;
        if(!(type instanceof ArrayType)) return false;
        ArrayType other = (ArrayType) type;
        if(!nullable.isAssignableFrom(other.getNullable())) return false;
        return componentType.isAssignableFrom(other.getComponentType());
    }

}
