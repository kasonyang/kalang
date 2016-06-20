package kalang.core;

import java.util.Objects;
import javax.annotation.Nullable;
import kalang.ast.FieldNode;
import kalang.ast.MethodNode;

/**
 *
 * @author Kason Yang
 */
public class GenericType extends ClassType{
    
    protected String name;
    
    protected Type[] upperBounds;

    public GenericType(String name,@Nullable Type[] upperBounds) {
        //FIXME wrong arguments
        super(Types.getRootType().getClassNode(),Types.getRootType());
        Objects.requireNonNull(name);
        this.name = name;
        this.upperBounds = upperBounds==null?new Type[0] : upperBounds;
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

    public Type[] getUpperBounds() {
        return upperBounds;
    }

}
