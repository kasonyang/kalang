package kalang.function;

import javax.annotation.Nullable;
import kalang.ast.ClassNode;
import kalang.core.ClassType;
import kalang.core.NullableKind;
import kalang.core.Type;
import kalang.core.Types;
import kalang.type.FunctionClasses;

/**
 *
 * @author Kason Yang
 */
public class FunctionType extends ClassType {

    private Type[] parameterTypes;

    private Type returnType;

    public FunctionType(Type returnType, @Nullable Type[] parameterTypes, NullableKind nullable) {
        super(buildClassNode(parameterTypes), buildArgumentTypes(returnType, parameterTypes), nullable);
        this.returnType = returnType;
        this.parameterTypes = parameterTypes;
    }

    public Type[] getParameterTypes() {
        return parameterTypes;
    }

    public Type getReturnType() {
        return returnType;
    }

    @Override
    public boolean isAssignableFrom(Type type) {
        if (super.isAssignableFrom(type)) {
            return true;
        }
        if (!(type instanceof ClassType)) {
            return false;
        }
        ClassType classType = (ClassType) type;
        //TODO check nullable
        if (classType.equals(Types.requireClassType(Types.FUNCTION_CLASS_NAME))) {
            return true;
        }
        return false;
    }

    private static Type[] buildArgumentTypes(Type returnType, Type[] parameterTypes) {
        if (parameterTypes == null) {
            parameterTypes = new Type[0];
        }
        int paramCount = parameterTypes.length;
        if (paramCount > FunctionClasses.CLASSES.length - 1) {
            throw new IllegalArgumentException("");
        }
        Type[] types = new Type[paramCount + 1];
        types[0] = returnType;
        for (int i = 1; i < types.length; i++) {
            types[i] = parameterTypes[i - 1];
        }
        return types;
    }

    private static ClassNode buildClassNode(@Nullable Type[] parameterTypes) {
        int pcount = parameterTypes == null ? 0 : parameterTypes.length;
        if (pcount > FunctionClasses.CLASSES.length - 1) {
            throw new IllegalArgumentException("");
        }
        return Types.requireClassType(FunctionClasses.CLASSES[pcount].getName()).getClassNode();
    }

}
