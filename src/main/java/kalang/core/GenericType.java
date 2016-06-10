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
        super(Types.ROOT_TYPE.getClassNode());
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
    public FieldNode[] getFields() {
        return new FieldNode[0];
    }

    @Override
    public MethodNode[] getMethods() {
        return new MethodNode[0];
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        return Types.ROOT_TYPE.equals(obj);
    }

}
