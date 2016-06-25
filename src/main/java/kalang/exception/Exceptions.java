package kalang.exception;
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
}
