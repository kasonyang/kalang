package kalang.compiler.core;

import kalang.compiler.ast.FieldNode;

/**
 *
 * @author Kason Yang
 */
public interface FieldDescriptor {

    String getName();

    Type getType();

    int getModifier() ;

    FieldNode getFieldNode() ;

}
