package kalang.compiler.core;

import kalang.compiler.ast.ConstExpr;
import kalang.compiler.exception.Exceptions;

/**
 * @author lbqh
 */
public class Values {

    private static boolean DEFAULT_BOOLEAN_VALUE;

    private static char DEFAULT_CHAR_VALUE;

    private static short DEFAULT_SHORT_VALUE;

    private static int DEFAULT_INT_VALUE;

    private static long DEFAULT_LONG_VALUE;

    private static float DEFAULT_FLOAT_VALUE;

    private static double DEFAULT_DOUBLE_VALUE;


    public static ConstExpr getDefaultValue(Type type) {
        if (Types.BOOLEAN_TYPE.equals(type)) {
            return new ConstExpr(DEFAULT_BOOLEAN_VALUE);
        } else if (Types.CHAR_TYPE.equals(type)) {
            return new ConstExpr(DEFAULT_CHAR_VALUE);
        } else if (Types.SHORT_TYPE.equals(type)) {
            return new ConstExpr(DEFAULT_SHORT_VALUE);
        } else if (Types.INT_TYPE.equals(type)) {
            return new ConstExpr(DEFAULT_INT_VALUE);
        } else if (Types.LONG_TYPE.equals(type)) {
            return new ConstExpr(DEFAULT_LONG_VALUE);
        } else if (Types.FLOAT_TYPE.equals(type)) {
            return new ConstExpr(DEFAULT_FLOAT_VALUE);
        } else if (Types.DOUBLE_TYPE.equals(type)) {
            return new ConstExpr(DEFAULT_DOUBLE_VALUE);
        } else if (type instanceof ObjectType) {
            return new ConstExpr(Types.NULL_TYPE);
        } else {
            throw Exceptions.unexpectedValue(type);
        }
    }

}
