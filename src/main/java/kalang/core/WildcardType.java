package kalang.core;

import java.util.Arrays;
import javax.annotation.Nullable;
import kalang.ast.ClassNode;
import kalang.util.AstUtil;
import kalang.util.TypeUtil;

/**
 *
 * @author Kason Yang
 */
public class WildcardType extends ObjectType {
    
    //TODO why upperBounds is array
    private Type[] upperBounds;
    
    //TODO why lowerBounds is array
    private Type[] lowerBounds;
    
    static ClassNode getClassNode(Type[] upperBounds,Type[] lowerBounds){
        if(lowerBounds!=null && lowerBounds.length>0){
            return Types.getRootType().getClassNode();
        }else if(upperBounds!=null && upperBounds.length>0){
            Type ub = upperBounds[0];
            if(ub instanceof ClassType){
                ClassType ct = (ClassType) ub;
                return AstUtil.createClassNodeWithInterfaces(ct.getName(),ct);
            }else{
                return Types.getRootType().getClassNode();
            }
        }else{
            throw new IllegalArgumentException();
        }
    }

    public WildcardType(@Nullable Type[] upperBounds,@Nullable Type[] lowerBounds) {
        //TODO is non-null?
        //TODO bounds maybe parameterizedType
        super(getClassNode(upperBounds, lowerBounds),NullableKind.NONNULL);
        this.upperBounds = upperBounds == null ? new Type[0] : upperBounds;
        this.lowerBounds = lowerBounds == null ? new Type[0] : lowerBounds;
    }

    @Override
    public String getName() {
        if(lowerBounds.length>0){
            return "? super " + TypeUtil.toString(lowerBounds, "&");
        }else if(upperBounds.length>0){
            return "? extends " + TypeUtil.toString(upperBounds,"&");
        }else{
            return "?";
        }
    }

    public Type[] getUpperBounds() {
        return upperBounds;
    }

    public void setUpperBounds(Type[] upperBounds) {
        this.upperBounds = upperBounds;
    }

    public Type[] getLowerBounds() {
        return lowerBounds;
    }

    public void setLowerBounds(Type[] lowerBounds) {
        this.lowerBounds = lowerBounds;
    }
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final WildcardType other = (WildcardType) obj;
        if (!Arrays.deepEquals(this.upperBounds, other.upperBounds)) {
            return false;
        }
        if (!Arrays.deepEquals(this.lowerBounds, other.lowerBounds)) {
            return false;
        }
        return true;
    }

    
    
    

}
