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
    
    public boolean isAssignableFrom(Type type){
        return equals(type);
    }
     
    @Override
    public String toString() {
        return getName();
    }

}
