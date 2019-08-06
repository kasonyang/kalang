package kalang.compiler.core;

import kalang.compiler.ast.ClassNode;
import kalang.compiler.util.LambdaUtil;

public class LambdaType extends ObjectType {

    private static int functionTypeCounter = 0;
    private final int parameterCount;

    public LambdaType(int parameterCount) {
        super(buildClassNode(),NullableKind.NONNULL);
        this.parameterCount = parameterCount;
    }

    @Override
    public boolean equals(Object type) {
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

    @Override
    public boolean isAssignableFrom(Type type) {
        if (super.isAssignableFrom(type)) {
            return true;
        }
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
        cn.name = "kalang.compiler.internal.FunctionClass" + (functionTypeCounter++);
        cn.setSuperType(Types.getRootType());
        return cn;
    }

}
