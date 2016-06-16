
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

    @Override
    public boolean isArray() {
        return false;
    }

    @Override
    public Type getComponentType() {
        return null;
    }

}
