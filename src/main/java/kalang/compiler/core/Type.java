package kalang.compiler.core;
/**
 *
 * @author Kason Yang
 */
public abstract class Type {
    
    
    public String getName() {
        return getName(false);
    }

    public abstract String getName(boolean simple);
    
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
