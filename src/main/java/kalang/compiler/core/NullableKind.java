package kalang.compiler.core;
/**
 *
 * @author Kason Yang
 */
public enum NullableKind {
    
    UNKNOWN,NULLABLE,NONNULL
    ;
    
    public boolean isAssignableFrom(NullableKind other){
        if(this==NONNULL && other==NULLABLE) return false;
        return true;
    }

}
