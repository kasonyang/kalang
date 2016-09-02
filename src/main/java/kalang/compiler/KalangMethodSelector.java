package kalang.compiler;

import kalang.core.ClassType;
import kalang.core.ExecutableDescriptor;
import kalang.core.PrimitiveType;
import kalang.core.Type;
import kalang.runtime.util.MethodSelector;
import kalang.util.BoxUtil;
import kalang.util.MathType;

/**
 *
 * @author Kason Yang
 */
public class KalangMethodSelector extends MethodSelector<ExecutableDescriptor,Type> {

    @Override
    protected String getMethodName(ExecutableDescriptor m) {
        return m.getName();
    }

    @Override
    protected Type[] getMethodParameterTypes(ExecutableDescriptor m) {
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
                return MathType.castable(MathType.getType(t1.getName()),MathType.getType(t2.getName()));
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
