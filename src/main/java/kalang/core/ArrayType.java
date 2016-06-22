
package kalang.core;
import kalang.compiler.AstLoader;
/**
 *
 * @author Kason Yang
 */
public class ArrayType extends ObjectType{

    private Type componentType;

    public ArrayType(Type componentType,NullableKind nullable) {
        //TODO should not hard code
        super(AstLoader.createArrayAst("java.lang.Object"),nullable);
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
