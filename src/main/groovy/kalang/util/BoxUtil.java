package kalang.util;

import jast.ast.CastExpr;
import jast.ast.ClassExpr;
import jast.ast.ExprNode;
import jast.ast.InvocationExpr;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import kalang.compiler.MathType;
import kalang.compiler.TypeCastException;
import kalang.core.ClassType;
import kalang.core.PrimitiveType;
import kalang.core.Type;
import kalang.core.Types;

/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class BoxUtil {

    final static int CAST_PRIMITIVE = 1,
            CAST_PRIMITIVE_TO_OBJECT = 2,
            CAST_OBJECT_TO_PRIMITIVE = 3,
            CAST_NOTHING = 4;

    public static ExprNode assign(ExprNode expr, Type fromType, Type toType) {
        int t = getCastMethod(fromType, toType);
        switch (t) {
            case CAST_NOTHING:
                return castNothing(expr, fromType, toType);
            case CAST_OBJECT_TO_PRIMITIVE:
                return castObject2Primitive(expr, fromType, toType);
            case CAST_PRIMITIVE:
                return castPrimitive(expr, fromType, toType);
            case CAST_PRIMITIVE_TO_OBJECT:
                return castPrimitive2Object(expr, (PrimitiveType) fromType, toType);
            default:
                throw new TypeCastException("unknown cast type:" + fromType + "=>" + toType);
        }
    }

    public static boolean assignable(Type fromType, Type toType) {
        return getCastMethod(fromType, toType) > 0;
    }

    private static int getCastMethod(Type fromType, Type toType) {
        if (fromType.equals(toType)) {
            return CAST_NOTHING;
        }
        if (fromType instanceof PrimitiveType) {
            if ((toType) instanceof PrimitiveType) {
                if (MathType.castable(MathType.getType(fromType.getName()), MathType.getType(toType.getName()))) {
                    return CAST_PRIMITIVE;
                }
            } else if (toType instanceof ClassType) {
                if (toType.equals(Types.ROOT_TYPE)) {
                    return CAST_PRIMITIVE_TO_OBJECT;
                }
                if (fromType.equals(Types.NULL_TYPE)) {
                    return CAST_NOTHING;
                }
                PrimitiveType toPriType = Types.getPrimitiveType((ClassType) toType);
                if (toPriType.equals(fromType)) {
                    return CAST_PRIMITIVE_TO_OBJECT;
                }
            }
        } else if (toType instanceof PrimitiveType) {
            ClassType fromClassType = (ClassType) fromType;
            PrimitiveType fromPrimitive = Types.getPrimitiveType(fromClassType);
            if (fromPrimitive.equals(toType)) {
                return CAST_OBJECT_TO_PRIMITIVE;
            }
        } else if (fromType.isSubclassTypeOf(toType)) {
            return CAST_NOTHING;
        }
        return -1;
    }

    private static ExprNode castPrimitive(ExprNode expr, Type fromType, Type toType) {
        return new CastExpr(toType, expr);
    }

    private static ExprNode castPrimitive2Object(ExprNode expr, PrimitiveType fromType, Type toType) {
        ClassType classType = Types.getClassType(fromType);
        return new InvocationExpr(new ClassExpr(classType.getName()), "valueOf", Arrays.asList(new ExprNode[]{expr}));
    }

    private static ExprNode castObject2Primitive(ExprNode expr, Type fromType, Type toType) {
        InvocationExpr inv = new InvocationExpr();
        inv.target = expr;
        inv.methodName = toType + "Value";
        return inv;
    }

    private static ExprNode castNothing(ExprNode expr, Type fromType, Type toType) {
        return expr;
    }

}
