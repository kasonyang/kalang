package kalang.compiler.util;

import kalang.compiler.ast.*;
import kalang.compiler.compile.OffsetRange;
import kalang.compiler.compile.semantic.AmbiguousMethodException;
import kalang.compiler.compile.semantic.MethodNotFoundException;
import kalang.compiler.compile.semantic.NodeException;
import kalang.compiler.core.*;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;

/**
 * Helper for data conversion between primitive type and object type
 * 
 * @author Kason Yang 
 */
public class BoxUtil {

    public final static int
            CAST_UNSUPPORTED = -1,
            CAST_PRIMITIVE = 1,
            CAST_PRIMITIVE_TO_OBJECT = 2,
            CAST_OBJECT_TO_PRIMITIVE = 3,
            CAST_NOTHING = 4,
            CAST_CONST   = 5
            //CAST_OBJECT_TO_STRING = 5,
            //CAST_PRIMITIVE_TO_STRING = 6
            ;

    @Nullable
    public static ExprNode assignToObjectType(@Nonnull ExprNode expr) {
        Type fromType = expr.getType();
        if (Types.VOID_TYPE.equals(fromType)) {
            return null;
        }
        if (fromType instanceof ObjectType) {
            return expr;
        }
        if (!(fromType instanceof PrimitiveType)) {
            return null;
        }
        ObjectType targetType = Types.getClassType((PrimitiveType) fromType);
        if (targetType == null) {
            return null;
        }
        return assign(expr, fromType, targetType);
    }

    @Nullable
    public static ExprNode assignToPrimitiveDataType(ExprNode expr, Type fromType) {
        if (Types.VOID_TYPE.equals(fromType)) {
            return null;
        }
        if (fromType instanceof PrimitiveType) {
            return expr;
        }
        if (!(fromType instanceof ObjectType)) {
            return null;
        }
        PrimitiveType targetPrimitiveType = Types.getPrimitiveType((ObjectType) fromType);
        if (targetPrimitiveType == null) {
            return null;
        }
        return assign(expr,fromType,targetPrimitiveType);
    }

    @Nullable
    public static ExprNode assign(ExprNode expr, Type toType) {
        return assign(expr, expr.getType(), toType);
    }

    @Nullable
    public static ExprNode assign(@Nonnull ExprNode expr, @Nonnull Type fromType,@Nonnull Type toType) {
        int t = getCastMethod(expr, toType);
        switch (t) {
            case CAST_NOTHING:
                return expr;
            case CAST_OBJECT_TO_PRIMITIVE:
                return castObject2Primitive(expr, toType);
            case CAST_PRIMITIVE:
                return castPrimitive(expr,(PrimitiveType) fromType, (PrimitiveType)toType);
            case CAST_PRIMITIVE_TO_OBJECT:
                return castPrimitive2Object(expr, (PrimitiveType) fromType);
            case CAST_CONST:
                return castConst((ConstExpr) expr,toType);
            //case CAST_PRIMITIVE_TO_STRING:
            //    return castPrimitive2String(expr, (PrimitiveType) fromType);
            //case CAST_OBJECT_TO_STRING:
            //    return castObject2String(expr);
            case CAST_UNSUPPORTED:
                return null;
            default:
                throw new IllegalStateException("unknown cast type:" + fromType + "=>" + toType);
        }
    }

    @Nonnull
    public static ExprNode requireImplicitCast(Type resultType, ExprNode expr, OffsetRange offset) {
        Type exprType = expr.getType();
        ExprNode result = assign(expr, exprType, resultType);
        if (result == null) {
            throw new NodeException(String.format("%s cannot be converted to %s", exprType,resultType), offset);
        }
        return result;
    }

    @Nonnull
    public static ExprNode requireImplicitCast(Type resultType, ExprNode expr) {
        return requireImplicitCast(resultType, expr, expr.offset);
    }

    public static int getCastMethod(ExprNode from, Type toType) {
        Type fromType = from.getType();
        if (fromType instanceof LambdaType) {
            if (((LambdaType) fromType).isAssignableTo(toType)) {
                return CAST_NOTHING;
            }
        }
        if (toType.isAssignableFrom(fromType)) {
            return CAST_NOTHING;
        }
        if (Types.NULL_TYPE.equals(fromType)) {
            return CAST_UNSUPPORTED;
        }
        if (fromType instanceof PrimitiveType
                && toType instanceof PrimitiveType) {
            //if ((toType) instanceof PrimitiveType) {
            if (Types.isPrimitiveCastable((PrimitiveType)fromType, (PrimitiveType)toType)) {
                return CAST_PRIMITIVE;
            }
        } else if (fromType instanceof PrimitiveType
                && toType instanceof ObjectType) {
            if (toType.isAssignableFrom(Types.getRootType())) {
                return CAST_PRIMITIVE_TO_OBJECT;
            }
            PrimitiveType toPriType = Types.getPrimitiveType((ObjectType) toType);
            if (toPriType == null) {
                return CAST_UNSUPPORTED;
            }
            if (toPriType.equals(fromType)) {
                return CAST_PRIMITIVE_TO_OBJECT;
            }
        } else if (fromType instanceof ObjectType
                && toType instanceof PrimitiveType) {
            if (NullableKind.NULLABLE.equals(((ObjectType) fromType).getNullable())) {
                return CAST_UNSUPPORTED;
            }
            ObjectType fromClassType = (ObjectType) fromType;
            PrimitiveType fromPrimitive = Types.getPrimitiveType(fromClassType);
            if (fromPrimitive == null) {
                return CAST_UNSUPPORTED;
            }
            if (fromPrimitive.equals(toType)) {
                return CAST_OBJECT_TO_PRIMITIVE;
            }
        }
        if (from instanceof ConstExpr) {
            ExprNode newConst = castConst((ConstExpr) from, toType);
            if (newConst != null) {
                return CAST_CONST;
            }
        }
        return CAST_UNSUPPORTED;
    }

    @Nullable
    private static ExprNode castConst(ConstExpr originConst, Type toType) {
        if (originConst.getType().equals(toType)) {
            return originConst;
        }
        Object value = originConst.getValue();
        Type constType = originConst.getType();
        if (!Types.INT_TYPE.equals(constType)) {
            return null;
        }
        Objects.requireNonNull(value);
        if (toType instanceof ClassType) {
            PrimitiveType primitiveType = Types.getPrimitiveType((ClassType)toType);
            if (primitiveType == null) {
                return null;
            }
            ExprNode newConst = castConst(originConst, primitiveType);
            if (newConst == null) {
                return null;
            }
            return assign(newConst, newConst.getType(), toType);
        }
        int num = (Integer) value;
        ConstExpr newConstExpr;
        if (toType.equals(Types.BYTE_TYPE)) {
            if (num > Byte.MAX_VALUE || num < Byte.MIN_VALUE) {
                return null;
            }
            value = (byte) num;
        } else if (toType.equals(Types.CHAR_TYPE)) {
            if (num > Character.MAX_VALUE || num < Character.MIN_VALUE) {
                return null;
            }
            value = (char) num;
        } else if (toType.equals(Types.SHORT_TYPE)) {
            if (num > Short.MAX_VALUE || num < Short.MIN_VALUE) {
                return null;
            }
            value = (short) num;
        } else if (toType.equals(Types.LONG_TYPE)) {
            value = (long) num;
        } else {
            return null;
        }
        newConstExpr = new ConstExpr(value);
        newConstExpr.offset = originConst.offset;
        return newConstExpr;
    }

    private static ExprNode castPrimitive(ExprNode expr,PrimitiveType fromType,PrimitiveType toType) {
        PrimitiveCastExpr result = new PrimitiveCastExpr(fromType, toType, expr);
        result.offset = expr.offset;
        return result;
    }

    private static ExprNode castPrimitive2Object(ExprNode expr, PrimitiveType fromType) {
        ObjectType classType = Types.getClassType(fromType);
        if(classType==null){
            throw new UnknownError("unknown primitive type:" + fromType);
        }
        InvocationExpr inv;
        try {
            inv = StaticInvokeExpr.create(new ClassReference( classType.getClassNode()), "valueOf", new ExprNode[]{expr});
        } catch (MethodNotFoundException|AmbiguousMethodException ex) {
            throw new RuntimeException(ex);
        }
        inv.offset = expr.offset;
        return inv;
    }

    private static ExprNode castObject2Primitive(ExprNode expr, Type toType) {
        InvocationExpr inv;
        try {
            inv = ObjectInvokeExpr.create(expr,toType + "Value",null);
        } catch (MethodNotFoundException|AmbiguousMethodException ex) {
            throw new RuntimeException(ex);
        }
        inv.offset = expr.offset;
        return inv;
    }

}
