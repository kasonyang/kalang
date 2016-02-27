package kalang.util;

import kalang.ast.ClassExpr;
import kalang.ast.ExprNode;
import kalang.ast.InvocationExpr;
import kalang.ast.PrimitiveCastExpr;
import java.util.*;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import kalang.compiler.MathType;
import kalang.core.ArrayType;
import kalang.core.ClassType;
import kalang.core.PrimitiveType;
import kalang.core.Type;
import kalang.core.Types;

/**
 * Helper for data conversion between primitive type and object type
 * 
 * @author Kason Yang <i@kasonyang.com>
 */
public class BoxUtil {

    final static int 
            CAST_UNSUPPORTED = -1,
            CAST_PRIMITIVE = 1,
            CAST_PRIMITIVE_TO_OBJECT = 2,
            CAST_OBJECT_TO_PRIMITIVE = 3,
            CAST_NOTHING = 4,
            CAST_OBJECT_TO_STRING = 5,
            CAST_PRIMITIVE_TO_STRING = 6;

    @Nullable
    public static ExprNode assign(@Nonnull ExprNode expr, @Nonnull Type fromType,@Nonnull Type toType) {
        int t = getCastMethod(fromType, toType);
        switch (t) {
            case CAST_NOTHING:
                return expr;
            case CAST_OBJECT_TO_PRIMITIVE:
                return castObject2Primitive(expr, fromType, toType);
            case CAST_PRIMITIVE:
                return castPrimitive(expr,(PrimitiveType) fromType, (PrimitiveType)toType);
            case CAST_PRIMITIVE_TO_OBJECT:
                return castPrimitive2Object(expr, (PrimitiveType) fromType);
            case CAST_PRIMITIVE_TO_STRING:
                return castPrimitive2String(expr, (PrimitiveType) fromType);
            case CAST_OBJECT_TO_STRING:
                return castObject2String(expr);
            case CAST_UNSUPPORTED:
                return null;
            default:
                throw new IllegalStateException("unknown cast type:" + fromType + "=>" + toType);
        }
    }

    public static boolean assignable(Type fromType, Type toType) {
        return getCastMethod(fromType, toType) > 0;
    }

    private static int getCastMethod(Type fromType, Type toType) {
        if (toType.isAssignedFrom(fromType)) {
            return CAST_NOTHING;
        }
        if (fromType instanceof PrimitiveType
                && toType instanceof PrimitiveType) {
            //if ((toType) instanceof PrimitiveType) {
            if (MathType.castable(MathType.getType(fromType.getName()), MathType.getType(toType.getName()))) {
                return CAST_PRIMITIVE;
            }
        } else if (fromType instanceof PrimitiveType
                && toType instanceof ClassType) {
            if (toType.equals(Types.ROOT_TYPE)) {
                return CAST_PRIMITIVE_TO_OBJECT;
            }
            if (fromType.equals(Types.NULL_TYPE)) {
                return CAST_NOTHING;
            }
            if (toType.equals(Types.STRING_CLASS_TYPE)) {
                return CAST_PRIMITIVE_TO_STRING;
            }
            PrimitiveType toPriType = Types.getPrimitiveType((ClassType) toType);
            if (toPriType == null) {
                return CAST_UNSUPPORTED;
            }
            if (toPriType.equals(fromType)) {
                return CAST_PRIMITIVE_TO_OBJECT;
            }
        } else if (fromType instanceof ClassType
                && toType instanceof PrimitiveType) {
//            if() {
            ClassType fromClassType = (ClassType) fromType;
            PrimitiveType fromPrimitive = Types.getPrimitiveType(fromClassType);
            if (fromPrimitive == null) {
                return CAST_UNSUPPORTED;
            }
            if (fromPrimitive.equals(toType)) {
                return CAST_OBJECT_TO_PRIMITIVE;
            }
        } else if (
                (
                fromType instanceof ClassType
                || fromType instanceof ArrayType
                )
                && toType.equals(Types.STRING_CLASS_TYPE)
                ) {
            return CAST_OBJECT_TO_STRING;
        }
        return CAST_UNSUPPORTED;
    }

    private static ExprNode castPrimitive(ExprNode expr,PrimitiveType fromType,PrimitiveType toType) {
        return new PrimitiveCastExpr(fromType, toType, expr);
    }

    private static ExprNode castPrimitive2Object(ExprNode expr, PrimitiveType fromType) {
        ClassType classType = Types.getClassType(fromType);
        if(classType==null){
            throw new UnknownError("unknown primitive type:" + fromType);
        }
        ClassExpr classExpr = new ClassExpr(classType.getClassNode());
        //classExpr.setType(classType);
        InvocationExpr inv = new InvocationExpr(classExpr, "valueOf", new ExprNode[]{expr});
        //inv.setType(classType);
        return inv;
    }

    private static ExprNode castObject2Primitive(ExprNode expr, Type fromType, Type toType) {
        InvocationExpr inv = new InvocationExpr(expr,toType + "Value");
        return inv;
    }

    private static ExprNode castPrimitive2String(ExprNode expr, PrimitiveType fromType) {
        return castObject2String(castPrimitive2Object(expr, fromType));
    }

    private static ExprNode castObject2String(ExprNode expr) {
        InvocationExpr inv = new InvocationExpr(expr, "toString");
        return inv;
    }

}
