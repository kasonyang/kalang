package kalang.compiler.util;
/**
 *
 * @author Kason Yang
 */
public final class Parameters {
    
    public static final void requireNonNull(Object obj){
        requireNonNull(obj, "require non null");
    }
    
    public static final void requireNonNull(Object obj,String msg) {
        if(obj==null) throw new IllegalArgumentException(msg);
    }
    
    public static final void requireTrue(boolean v) {
        if(!v) throw new IllegalArgumentException();
    }
    
    public static final void requireFalse(boolean v){
        if(v) throw new IllegalArgumentException();
    }
    
    

}
