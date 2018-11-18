package kalang.compiler.util;

import kalang.compiler.AmbiguousMethodException;
import kalang.compiler.AstNotFoundException;
import kalang.compiler.MethodNotFoundException;
import kalang.compiler.ast.*;
import kalang.compiler.compile.AstLoader;
import kalang.compiler.core.ObjectType;
import kalang.compiler.core.PrimitiveType;
import kalang.compiler.core.Type;
import kalang.compiler.core.Types;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Helper for data conversion between primitive type and object type
 * 
 * @author Kason Yang 
 */
public class BoxUtil {

    final static int 
            CAST_UNSUPPORTED = -1,
            CAST_PRIMITIVE = 1,
            CAST_PRIMITIVE_TO_OBJECT = 2,
            CAST_OBJECT_TO_PRIMITIVE = 3,
            CAST_NOTHING = 4
            //CAST_OBJECT_TO_STRING = 5,
            //CAST_PRIMITIVE_TO_STRING = 6
            ;

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

    public static boolean assignable(Type fromType, Type toType) {
        return getCastMethod(fromType, toType) > 0;
    }

    private static int getCastMethod(Type fromType, Type toType) {
        if (toType.isAssignableFrom(fromType)) {
            return CAST_NOTHING;
        }
        if (fromType instanceof PrimitiveType
                && toType instanceof PrimitiveType) {
            //if ((toType) instanceof PrimitiveType) {
            if (Types.isPrimitiveCastable((PrimitiveType)fromType, (PrimitiveType)toType)) {
                return CAST_PRIMITIVE;
            }
        } else if (fromType instanceof PrimitiveType
                && toType instanceof ObjectType) {
            if (Types.isRootObjectType((ObjectType)toType)){
                return CAST_PRIMITIVE_TO_OBJECT;
            }
//            if (fromType.equals(Types.NULL_TYPE)) {
//                return CAST_NOTHING;
//            }
////            if (toType.equals(Types.STRING_CLASS_TYPE)) {
////                return CAST_PRIMITIVE_TO_STRING;
////            }
            PrimitiveType toPriType = Types.getPrimitiveType((ObjectType) toType);
            if (toPriType == null) {
                return CAST_UNSUPPORTED;
            }
            if (toPriType.equals(fromType)) {
                return CAST_PRIMITIVE_TO_OBJECT;
            }
        } else if (fromType instanceof ObjectType
                && toType instanceof PrimitiveType) {
//            if() {
            ObjectType fromClassType = (ObjectType) fromType;
            PrimitiveType fromPrimitive = Types.getPrimitiveType(fromClassType);
            if (fromPrimitive == null) {
                return CAST_UNSUPPORTED;
            }
            if (fromPrimitive.equals(toType)) {
                return CAST_OBJECT_TO_PRIMITIVE;
            }
        } 
//        else if (
//                (
//                fromType instanceof ObjectType
//                || fromType instanceof ArrayType
//                )
//                && toType.equals(Types.STRING_CLASS_TYPE)
//                ) {
//            return CAST_OBJECT_TO_STRING;
//        }
        return CAST_UNSUPPORTED;
    }

    private static ExprNode castPrimitive(ExprNode expr,PrimitiveType fromType,PrimitiveType toType) {
        return new PrimitiveCastExpr(fromType, toType, expr);
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
        return inv;
    }

    private static ExprNode castObject2Primitive(ExprNode expr, Type fromType, Type toType) {
        InvocationExpr inv;
        try {
            inv = ObjectInvokeExpr.create(expr,toType + "Value",null);
        } catch (MethodNotFoundException|AmbiguousMethodException ex) {
            throw new RuntimeException(ex);
        }
        return inv;
    }

    private static ExprNode castPrimitive2String(ExprNode expr, PrimitiveType fromType) {
        return castObject2String(castPrimitive2Object(expr, fromType));
    }

    private static ExprNode castObject2String(ExprNode expr) {
        InvocationExpr inv;
        try {
            inv = StaticInvokeExpr.create(new ClassReference(AstLoader.BASE_AST_LOADER.loadAst("java.util.Objects")), "toString", new ExprNode[]{expr});
        } catch (MethodNotFoundException|AmbiguousMethodException|AstNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        return inv;
    }
    
    public static ExprNode castToString(ExprNode expr){
        Type fromType = expr.getType();
        if(fromType instanceof PrimitiveType){
            return castPrimitive2String(expr, (PrimitiveType) fromType);
        }else if(fromType instanceof ObjectType){
            return castObject2String(expr);
        }else{
            return null;
        }
    }

}
