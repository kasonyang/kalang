
package kalang.runtime.dynamic;

import java.lang.reflect.Field;

/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class FieldVisitor {
    public static Object get(Object obj,String name) throws NoSuchFieldException, IllegalAccessException{
        Field field = obj.getClass().getField(name);
        return  field.get(obj);
    }
    
    public static void set(Object obj,String name,Object value) throws IllegalAccessException, NoSuchFieldException{
        Field field = obj.getClass().getField(name);
        field.set(obj, value);
    }
}
