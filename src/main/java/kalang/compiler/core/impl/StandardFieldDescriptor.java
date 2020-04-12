package kalang.compiler.core.impl;

import kalang.compiler.ast.FieldNode;
import kalang.compiler.core.FieldDescriptor;
import kalang.compiler.core.Type;

/**
 *
 * @author Kason Yang
 */
public class StandardFieldDescriptor implements FieldDescriptor {
    
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
