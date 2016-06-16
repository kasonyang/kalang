package kalang.core;

import kalang.ast.FieldNode;

/**
 *
 * @author Kason Yang
 */
public interface FieldDescriptor {

    public String getName();

    public Type getType();

    public int getModifier() ;

    public FieldNode getFieldNode() ;

}
