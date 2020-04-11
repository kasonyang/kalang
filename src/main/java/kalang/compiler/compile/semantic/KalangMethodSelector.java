package kalang.compiler.compile.semantic;

import kalang.compiler.ast.ExprNode;
import kalang.compiler.core.*;
import kalang.compiler.util.Exceptions;
import kalang.compiler.util.BoxUtil;
import kalang.runtime.util.MethodResolver;

/**
 *
 * @author Kason Yang
 */
public class KalangMethodSelector extends MethodResolver<MethodDescriptor,Type, ExprNode> {

    @Override
    protected String getMethodName(MethodDescriptor m) {
        return m.getName();
    }

    @Override
    protected Type[] getMethodParameterTypes(MethodDescriptor m) {
        return m.getParameterTypes();
    }

    @Override
    protected boolean isMorePreciseType(ExprNode arg, Type t1, Type t2) {
        Type actualType = arg.getType();
        if(t1.isAssignableFrom(t2)) return false;
        if(t2.isAssignableFrom(t1)) return true;
        if (actualType.equals(t1) && !actualType.equals(t2)) return true;
        if (actualType.equals(t2) && !actualType.equals(t1)) return false;
        if(actualType instanceof ClassType){
            if( (t1 instanceof ClassType) && (t2 instanceof PrimitiveType)) return true;
        }else if(actualType instanceof PrimitiveType){
            if((t1 instanceof PrimitiveType) && (t2 instanceof ClassType)) return true;
            if(t1 instanceof PrimitiveType && t2 instanceof PrimitiveType){
                return Types.isPrimitiveCastable((PrimitiveType)t1,(PrimitiveType)t2);
            }
        }
        //TODO imcomplete isMorePreciseType
        return false;
    }

    @Override
    protected boolean equalsType(Type type1, Type type2) {
        return type1.equals(type2);
    }

    @Override
    protected int getMatchScore(ExprNode arg, Type type) {
        if (type.equals(arg.getType())) {
            return 0;
        }
        int castMethod = BoxUtil.getCastMethod(arg, type);
        switch (castMethod) {
            case BoxUtil.CAST_CONST:
                return 0;
            case BoxUtil.CAST_UNSUPPORTED:
                return -1;
            case BoxUtil.CAST_NOTHING:
                return 1;
            case BoxUtil.CAST_PRIMITIVE_TO_OBJECT:
            case BoxUtil.CAST_OBJECT_TO_PRIMITIVE:
            case BoxUtil.CAST_PRIMITIVE:
                return 2;
            default:
                throw Exceptions.unknownValue(castMethod);

        }
    }

}
