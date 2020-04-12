package kalang.compiler.core;

import kalang.annotation.Nullable;
import kalang.compiler.ast.MethodNode;

import java.util.Map;

/**
 * @author KasonYang
 */
public interface MethodDescriptor {

    MethodDescriptor toParameterized(Map<GenericType, Type> genericTypeMap, @Nullable Type[] actualArgumentTypes);

    Type[] getParameterTypes();

    int getModifier();

    MethodNode getMethodNode();

    ParameterDescriptor[] getParameterDescriptors();

    String getName();

    String getDeclarationKey();

    Type getReturnType();

    //TODO exception type should be object type
    Type[] getExceptionTypes();

}
