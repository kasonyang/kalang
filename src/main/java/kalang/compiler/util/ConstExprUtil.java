package kalang.compiler.util;

import kalang.annotation.Nullable;
import kalang.compiler.ast.BinaryExpr;
import kalang.compiler.ast.ConstExpr;
import kalang.compiler.ast.ExprNode;

/**
 * @author KasonYang
 */
public class ConstExprUtil {

    @Nullable
    public static ConstExpr evaluate(ExprNode expr) {
        if (expr instanceof BinaryExpr) {
            BinaryExpr be = (BinaryExpr) expr;
            ExprNode e1 = be.getExpr1();
            ExprNode e2 = be.getExpr2();
            String op = be.getOperation();
            if (!(e1 instanceof ConstExpr) || !(e2 instanceof ConstExpr)) {
                return null;
            }
            Object value1 = ((ConstExpr) e1).getValue();
            Object value2 =((ConstExpr) e2).getValue();
            Object result;
            //TODO support shift operation
            if (value1 instanceof Integer && value2 instanceof Integer) {
                result = evalIntegerBinaryOp(op, (Integer) value1,(Integer)value2);
            } else if (value1 instanceof Long && value2 instanceof Long) {
                result = evalLongBinaryOp(op, (Long) value1, (Long) value2);
            } else if (value1 instanceof Float && value2 instanceof Float) {
                result = evalFloatBinaryOp(op, (Float) value1, (Float) value2);
            } else if (value1 instanceof Double && value2 instanceof Double) {
                result = evalDoubleBinaryOp(op, (Double) value1, (Double) value2);
            } else {
                return null;
            }
            if (result == null) {
                return null;
            }
            ConstExpr ce = new ConstExpr(result);
            ce.offset = expr.offset;
            return ce;
        }
        return null;
    }

    private static Object evalIntegerBinaryOp(String op, Integer value1, Integer value2) {
        switch (op) {
            case BinaryExpr.OP_ADD:
                return value1 + value2;
            case BinaryExpr.OP_SUB:
                return value1 - value2;
            case BinaryExpr.OP_MUL:
                return value1 * value2;
            case BinaryExpr.OP_DIV:
                return value1 / value2;
            case BinaryExpr.OP_REM:
                return value1 % value2;
            case BinaryExpr.OP_AND:
                return value1 & value2;
            case BinaryExpr.OP_OR:
                return value1 | value2;
            case BinaryExpr.OP_XOR:
                return value1 ^ value2;
            case BinaryExpr.OP_EQ:
                return value1.equals(value2);
            case BinaryExpr.OP_NE:
                return !value1.equals(value2);
            case BinaryExpr.OP_GE:
                return value1 >= value2;
            case BinaryExpr.OP_GT:
                return value1 > value2;
            case BinaryExpr.OP_LE:
                return value1 <= value2;
            case BinaryExpr.OP_LT:
                return value1 < value2;
            default:
                return null;
        }
    }

    private static Object evalLongBinaryOp(String op, Long value1, Long value2) {
        switch (op) {
            case BinaryExpr.OP_ADD:
                return value1 + value2;
            case BinaryExpr.OP_SUB:
                return value1 - value2;
            case BinaryExpr.OP_MUL:
                return value1 * value2;
            case BinaryExpr.OP_DIV:
                return value1 / value2;
            case BinaryExpr.OP_REM:
                return value1 % value2;
            case BinaryExpr.OP_AND:
                return value1 & value2;
            case BinaryExpr.OP_OR:
                return value1 | value2;
            case BinaryExpr.OP_XOR:
                return value1 ^ value2;
            case BinaryExpr.OP_EQ:
                return value1.equals(value2);
            case BinaryExpr.OP_NE:
                return !value1.equals(value2);
            case BinaryExpr.OP_GE:
                return value1 >= value2;
            case BinaryExpr.OP_GT:
                return value1 > value2;
            case BinaryExpr.OP_LE:
                return value1 <= value2;
            case BinaryExpr.OP_LT:
                return value1 < value2;
            default:
                return null;
        }
    }

    private static Object evalFloatBinaryOp(String op, Float value1, Float value2) {
        switch (op) {
            case BinaryExpr.OP_ADD:
                return value1 + value2;
            case BinaryExpr.OP_SUB:
                return value1 - value2;
            case BinaryExpr.OP_MUL:
                return value1 * value2;
            case BinaryExpr.OP_DIV:
                return value1 / value2;
            case BinaryExpr.OP_REM:
                return value1 % value2;
            case BinaryExpr.OP_EQ:
                return value1.equals(value2);
            case BinaryExpr.OP_NE:
                return !value1.equals(value2);
            case BinaryExpr.OP_GE:
                return value1 >= value2;
            case BinaryExpr.OP_GT:
                return value1 > value2;
            case BinaryExpr.OP_LE:
                return value1 <= value2;
            case BinaryExpr.OP_LT:
                return value1 < value2;
            default:
                return null;
        }
    }

    private static Object evalDoubleBinaryOp(String op, Double value1, Double value2) {
        switch (op) {
            case BinaryExpr.OP_ADD:
                return value1 + value2;
            case BinaryExpr.OP_SUB:
                return value1 - value2;
            case BinaryExpr.OP_MUL:
                return value1 * value2;
            case BinaryExpr.OP_DIV:
                return value1 / value2;
            case BinaryExpr.OP_REM:
                return value1 % value2;
            case BinaryExpr.OP_EQ:
                return value1.equals(value2);
            case BinaryExpr.OP_NE:
                return !value1.equals(value2);
            case BinaryExpr.OP_GE:
                return value1 >= value2;
            case BinaryExpr.OP_GT:
                return value1 > value2;
            case BinaryExpr.OP_LE:
                return value1 <= value2;
            case BinaryExpr.OP_LT:
                return value1 < value2;
            default:
                return null;
        }
    }

}
