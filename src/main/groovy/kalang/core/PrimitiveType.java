
package kalang.core;
import kalang.ast.*;
import java.util.*;
import static kalang.core.Types.*;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class PrimitiveType extends Type{
    
    private String name;

    public PrimitiveType(String name) {
        super(null);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isPrimitiveType() {
        return true;
    }

//    @Override
//    public boolean isCastableTo(Type targetType) {
//        if (this.equals(targetType)) {
//            return true;
//        }
//        HashMap<Type, List> baseMap = new HashMap();
//        baseMap.put(Types.INT_TYPE, Arrays.asList(new Type[]{Types.LONG_TYPE, Types.FLOAT_TYPE, Types.DOUBLE_TYPE}));
//        baseMap.put(LONG_TYPE, Arrays.asList(new Type[]{FLOAT_TYPE, DOUBLE_TYPE}));
//        baseMap.put(FLOAT_TYPE, Arrays.asList(new Type[]{DOUBLE_TYPE}));
//        baseMap.put(DOUBLE_TYPE, new LinkedList());
//        if (baseMap.containsKey(this)) {
//            return baseMap.get(this).contains(targetType);
//        }
//        return false;
//    }

//    @Override
//    public ExprNode cast(Type targetType, ExprNode from) {
//        return new CastExpr(targetType, from);
//    }

    @Override
    public boolean isArray() {
        return false;
    }

    @Override
    public Type getComponentType() {
        return null;
    }

    @Override
    public VarObject[] getFields() {
        return null;
    }

    @Override
    public MethodNode[] getMethods() {
        return null;
    }

//    @Override
//    public boolean isSubclassTypeOf(Type targetType) {
//        return false;
//    }

//    @Override
//    public boolean isAssignedFrom(Type type) {
//        return equals(type);
//    }

}
