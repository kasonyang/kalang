package kalang.core;

import java.util.Objects;
import kalang.ast.FieldNode;
import kalang.ast.MethodNode;

/**
 *
 * @author Kason Yang
 */
public class GenericType extends ClassType{
    
    protected String name;

    public GenericType(String name) {
        super(Types.getRootType().getClassNode());
        Objects.requireNonNull(name);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isPrimitiveType() {
        return false;
    }

    @Override
    public boolean isArray() {
        return false;
    }

    @Override
    public Type getComponentType() {
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        return this==obj;
    }

}
