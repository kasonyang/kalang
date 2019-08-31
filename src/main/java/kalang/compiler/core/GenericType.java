package kalang.compiler.core;

import kalang.compiler.ast.ClassNode;
import kalang.compiler.util.AstUtil;

import javax.annotation.Nullable;
import java.util.Objects;

/**
 *
 * @author Kason Yang
 */
public class GenericType extends ObjectType{
    
    protected String name;
    
    private static ClassNode getClassNode(String name,@Nullable ObjectType superType,@Nullable ObjectType[] interfaces){
        return AstUtil.createClassNodeWithInterfaces(name,superType,interfaces);
    }

    public GenericType(String name,ObjectType superType,@Nullable ObjectType[] interfaces,NullableKind nullable) {
        super(getClassNode(name,superType,interfaces),nullable);
        Objects.requireNonNull(name);
        this.name = name;
    }

    @Override
    public boolean equalsIgnoreNullable(ObjectType other) {
        //TODO fix equalsIgnoreNullable
        return equals(other);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isAssignableFrom(Type type) {
        ObjectType superType = getSuperType();
        Objects.requireNonNull(superType);
        return superType.isAssignableFrom(type);
    }
}
