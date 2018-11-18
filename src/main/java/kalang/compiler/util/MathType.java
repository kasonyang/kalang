package kalang.compiler.util;

import kalang.compiler.core.PrimitiveType;
import kalang.compiler.core.Types;

public class MathType {

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
