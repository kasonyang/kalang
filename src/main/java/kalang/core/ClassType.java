package kalang.core;

import kalang.ast.ClassNode;

/**
 *
 * @author Kason Yang
 */
public class ClassType extends ObjectType{

    public ClassType(ClassNode clazz, ObjectType superType, NullableKind nullable) {
        super(clazz, superType, nullable);
    }

}
