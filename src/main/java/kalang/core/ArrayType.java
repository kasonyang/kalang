
package kalang.core;
import kalang.compiler.AstLoader;
/**
 *
 * @author Kason Yang
 */
public class ArrayType extends ClassType{

    private Type componentType;

    public ArrayType(Type componentType,NullableKind nullable) {
        //TODO should not hard code
        super(AstLoader.createArrayAst("java.lang.Object"),Types.getRootType(),nullable);
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
        if(type.equals(this)) return true;
        if(!(type instanceof ArrayType)) return false;
        ArrayType other = (ArrayType) type;
        if(!nullable.isAssignedFrom(other.getNullable())) return false;
        return componentType.isAssignedFrom(other.getComponentType());
    }

    @Override
    public boolean isSubTypeOf(Type targetType) {
        if(targetType.equals(superType)) return true;
        if(targetType instanceof ArrayType){
            return componentType.isSubTypeOf(((ArrayType)targetType).componentType);
        }
        return false;
    }


}
