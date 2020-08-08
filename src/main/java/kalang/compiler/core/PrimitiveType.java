
package kalang.compiler.core;
/**
 *
 * @author Kason Yang 
 */
public class PrimitiveType extends Type{
    
    private String name;

    public PrimitiveType(String name) {
        this.name = name;
    }

    @Override
    public String getName(boolean simple) {
        return name;
    }

}
