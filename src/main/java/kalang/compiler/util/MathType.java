package kalang.compiler.util;

import kalang.annotation.Nullable;
import kalang.compiler.core.PrimitiveType;
import kalang.compiler.core.Types;

import java.util.Arrays;
import java.util.List;

public class MathType {

    private static List<PrimitiveType> supportedTypes = Arrays.asList(
            Types.DOUBLE_TYPE,
            Types.FLOAT_TYPE,
            Types.LONG_TYPE,
            Types.INT_TYPE,
            Types.SHORT_TYPE,
            Types.BYTE_TYPE,
            Types.CHAR_TYPE
    );

    public static boolean isSupportedType(@Nullable PrimitiveType type) {
        return supportedTypes.contains(type);
    }

    public static PrimitiveType getType(PrimitiveType type1, PrimitiveType type2) {
        if (Types.DOUBLE_TYPE.equals(type1) || Types.DOUBLE_TYPE.equals(type2)) {
            return Types.DOUBLE_TYPE;
        } else if (Types.FLOAT_TYPE.equals(type1) || Types.FLOAT_TYPE.equals(type2)) {
            return Types.FLOAT_TYPE;
        } else if (Types.LONG_TYPE.equals(type1) || Types.LONG_TYPE.equals(type2)) {
            return Types.LONG_TYPE;
        } else {
            return Types.INT_TYPE;
        }
    }
}
