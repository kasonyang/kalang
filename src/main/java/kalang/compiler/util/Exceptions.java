package kalang.compiler.util;

import kalang.annotation.Nullable;

import java.util.Objects;

/**
 *
 * @author Kason Yang 
 */
public class Exceptions {

    public static RuntimeException unsupportedTypeException(Object obj){
        String typeName = obj == null ? "null" : obj.getClass().getName();
        return new IllegalArgumentException("Unsupported type:" + typeName);
    }
    
    public static UnsupportedOperationException unsupportedTypeException(Class clazz){
        return new UnsupportedOperationException("Unsupported type:" + clazz.getName());
    }
    
    public static RuntimeException missingRuntimeClass(String className){
        return new RuntimeException("missing runtime class:" + className);
    }

    public static RuntimeException unknownValue(Object value) {
        throw new UnsupportedOperationException("unknown value:" + value);
    }

    public static IllegalArgumentException illegalArgument(Object obj) {
        throw new IllegalArgumentException(Objects.toString(obj));
    }
    
     public static RuntimeException unexpectedException(String msg){
         throw new RuntimeException(msg);
     }

    public static RuntimeException unexpectedException(java.lang.Exception ex) {
        return new RuntimeException(ex);
    }
    
    public static RuntimeException unexpectedValue(@Nullable Object obj) {
        return new RuntimeException("unexpected value:" + obj);
    }
}
