package kalang.compiler.core;

import kalang.compiler.ast.ClassNode;
import kalang.compiler.util.AstUtil;
import kalang.compiler.util.ModifierUtil;
import kalang.compiler.util.TypeUtil;

import javax.annotation.Nullable;
import java.util.Arrays;

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
            return AstUtil.createClassNodeWithInterfaces("?", Types.getRootType());
        }else{
            if(upperBounds==null || upperBounds.length==0){
                upperBounds = new ObjectType[]{Types.getRootType()};
            }
            ObjectType ub = (ObjectType) upperBounds[0];
            ObjectType superType;
            ObjectType[] interfaces;
            if(ModifierUtil.isInterface(ub.getModifier())){
                superType = Types.getRootType();
                interfaces = new ObjectType[]{ub};
            }else{
                superType = ub;
                interfaces = new ObjectType[0];
            }
            return AstUtil.createClassNodeWithInterfaces("?",superType,interfaces);
        }
    }

    @Deprecated
    public WildcardType(@Nullable Type[] upperBounds,@Nullable Type[] lowerBounds){
        this(upperBounds, lowerBounds, NullableKind.NONNULL);
    }

    public WildcardType(@Nullable Type[] upperBounds,@Nullable Type[] lowerBounds, NullableKind nullableKind) {
        super(getClassNode(upperBounds, lowerBounds), nullableKind);
        this.upperBounds = upperBounds == null ? new Type[0] : upperBounds;
        this.lowerBounds = lowerBounds == null ? new Type[0] : lowerBounds;
    }

    @Override
    public boolean equalsIgnoreNullable(ObjectType obj) {
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
        if (!(obj instanceof WildcardType)) {
            return false;
        }
        WildcardType other = (WildcardType) obj;
        return nullable.equals(other.getNullable()) && equalsIgnoreNullable(other);
    }

    @Override
    public boolean isAssignableFrom(Type type) {
        if(lowerBounds.length>0){
            return lowerBounds[0].isAssignableFrom(type);
        }else{
            return super.isAssignableFrom(type);
        }
    }
    
    public boolean containsType(ObjectType type){
        if(lowerBounds.length>0){
            return type.isAssignableFrom(lowerBounds[0]);
        }else{
            return upperBounds[0].isAssignableFrom(type);
        }
    }

}
