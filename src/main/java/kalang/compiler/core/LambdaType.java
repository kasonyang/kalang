package kalang.compiler.core;

import kalang.compiler.ast.ClassNode;
import kalang.compiler.util.LambdaUtil;

import java.util.Objects;

public class LambdaType extends ObjectType {

    private static int functionTypeCounter = 0;
    private final int parameterCount;

    public LambdaType(int parameterCount) {
        super(buildClassNode(),NullableKind.NONNULL);
        this.parameterCount = parameterCount;
    }

    @Override
    public boolean equals(Object type) {
        if (!(type instanceof ObjectType)){
            return false;
        }
        return nullable.equals(((ObjectType) type).getNullable()) && equalsIgnoreNullable((ObjectType) type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parameterCount, nullable);
    }

    public boolean isAssignableTo(Type type) {
        if (!(type instanceof ClassType)) {
            return false;
        }
        MethodDescriptor funcMethod = LambdaUtil.getFunctionalMethod((ClassType) type);
        if (funcMethod == null) {
            return false;
        }
        return funcMethod.getParameterTypes().length >= parameterCount;
    }

    private static ClassNode buildClassNode() {
        ClassNode cn = new ClassNode();
        cn.setName("kalang.compiler.internal.FunctionClass" + (functionTypeCounter++));
        cn.setSuperType(Types.getRootType());
        return cn;
    }

    @Override
    public boolean equalsIgnoreNullable(ObjectType type) {
        if (super.equals(type)) {
            return true;
        }
        if (!(type instanceof ClassType)) {
            return false;
        }
        MethodDescriptor funcMethod = LambdaUtil.getFunctionalMethod((ClassType) type);
        if (funcMethod == null) {
            return false;
        }
        return funcMethod.getParameterTypes().length == parameterCount;
    }
}
