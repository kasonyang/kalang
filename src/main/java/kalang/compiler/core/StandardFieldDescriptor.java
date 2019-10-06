package kalang.compiler.core;

import kalang.compiler.ast.FieldNode;

/**
 *
 * @author Kason Yang
 */
public class StandardFieldDescriptor implements FieldDescriptor{
    
    private FieldNode field;
    
    private Type type;

    public StandardFieldDescriptor(FieldNode field, Type type) {
        this.field = field;
        this.type = type;
    }

    public StandardFieldDescriptor(FieldNode field) {
        this.field = field;
    }

    @Override
    public String getName() {
        return field.getName();
    }

    @Override
    public Type getType() {
        return type == null ? field.getType() : type ;
    }

    @Override
    public int getModifier() {
        return field.modifier;
    }

    @Override
    public FieldNode getFieldNode() {
        return field;
    }

    @Override
    public String toString() {
        return getName();
    }
}
