package kalang.compiler.core;

import kalang.compiler.ast.FieldNode;

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
