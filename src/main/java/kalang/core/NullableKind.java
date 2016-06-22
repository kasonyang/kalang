package kalang.core;
/**
 *
 * @author Kason Yang
 */
public enum NullableKind {
    
    UNKNOWN,NULLABLE,NONNULL
    ;
    
    public boolean isAssignedFrom(NullableKind other){
        if(this==NONNULL && other==NULLABLE) return false;
        return true;
    }

}
