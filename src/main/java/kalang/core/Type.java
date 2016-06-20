package kalang.core;
/**
 *
 * @author Kason Yang
 */
public abstract class Type {
    
    
    public abstract String getName();
    
    public String getDeclarationKey(){
        return getName();
    }
    
    public boolean isSubTypeOf(Type targetType){
        return false;
    }
    
    public boolean isAssignedFrom(Type type){
        if(equals(type)) return true;
        return type.isSubTypeOf(this);
    }
     
    @Override
    public String toString() {
        return getName();
    }

}
