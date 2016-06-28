package kalang.exception;

import java.util.Objects;
import kalang.core.FieldDescriptor;

/**
 *
 * @author Kason Yang <im@kasonyang.com>
 */
public class Exceptions {
    
    public static UnsupportedOperationException unsupportedTypeException(Object obj){
        return unsupportedTypeException(obj.getClass());
    }
    
    public static UnsupportedOperationException unsupportedTypeException(Class clazz){
        return new UnsupportedOperationException("Unsupported type:" + clazz.getName());
    }
    
    public static RuntimeException missingRuntimeClass(String className){
        return new RuntimeException("missing runtime class:" + className);
    }

    public static RuntimeException unknownValue(String value) {
        throw new UnsupportedOperationException("unknown value:" + value);
    }

    public static IllegalArgumentException illegalArgument(Object obj) {
        throw new IllegalArgumentException(Objects.toString(obj));
    }
}
