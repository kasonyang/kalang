package kalang.compiler.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author Kason Yang
 */
public class ClassExecutor {
    public static void executeMain(Class clazz,String[] args) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        Method method = clazz.getMethod("main", String[].class);
        method.invoke(null, new Object[]{args});
    }
}
