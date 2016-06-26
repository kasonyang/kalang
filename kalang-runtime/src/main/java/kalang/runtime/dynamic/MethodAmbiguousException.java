
package kalang.runtime.dynamic;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class MethodAmbiguousException extends Exception{
    
    protected Method[] ambiguousMethods;

    public MethodAmbiguousException(Method[] ambiguousMethods) {
        this.ambiguousMethods = ambiguousMethods;
    }

    @Override
    public String toString() {
        return "method is ambiguous:" + Arrays.toString(ambiguousMethods);
    }
    
    

}
