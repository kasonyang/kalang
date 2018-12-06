package kalang.compiler.compile;

import kalang.compiler.core.*;
import kalang.compiler.util.BoxUtil;
import kalang.runtime.util.MethodSelector;

/**
 *
 * @author Kason Yang
 */
public class KalangMethodSelector extends MethodSelector<MethodDescriptor,Type> {

    @Override
    protected String getMethodName(MethodDescriptor m) {
        return m.getName();
    }

    @Override
    protected Type[] getMethodParameterTypes(MethodDescriptor m) {
        return m.getParameterTypes();
    }

    @Override
    protected boolean isMorePreciseType(Type actualType, Type t1, Type t2) {
        if(t1.isAssignableFrom(t2)) return false;
        if(t2.isAssignableFrom(t1)) return true;
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
    protected boolean isAssignableFrom(Type t, Type t1) {
        return BoxUtil.assignable(t1, t);
    }

    @Override
    protected boolean equalsType(Type type1, Type type2) {
        return type1.equals(type2);
    }

}
