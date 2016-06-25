
package kalang.core;
import kalang.compiler.AstLoader;
import kalang.util.AstUtil;
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
    public String getName() {
        return componentType.getName() + "[]";
    }

    public Type getComponentType() {
        return componentType;
    }

    @Override
    public boolean isAssignedFrom(Type type) {
        if(equalAndNullAssignChecked(type)) return true;
        if(!(type instanceof ArrayType)) return false;
        ArrayType other = (ArrayType) type;
        if(!nullable.isAssignedFrom(other.getNullable())) return false;
        return componentType.isAssignedFrom(other.getComponentType());
    }

}
