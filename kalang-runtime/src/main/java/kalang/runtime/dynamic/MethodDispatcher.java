
package kalang.runtime.dynamic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kalang.runtime.util.MethodSelector;

/**
 *
 * @author Kason Yang
 */
public class MethodDispatcher {
    
    private final static JavaMethodSelector methodSelector = new JavaMethodSelector();
    
    public static Class[] getObjectTypes(Object... objects){
        Class[] types = new Class[objects.length];
        for(int i=0;i<objects.length;i++){
            types[i] = objects[i].getClass();
        }
        return types;
    }
    
    public static Object invokeMethodExactly(Object obj,String method,Object[] args,String[] types) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        Class<? extends Object> clazz = obj.getClass();
        Class[] typeClasses = new Class[types.length];
        for(int i=0;i<types.length;i++){
            typeClasses[i] = Class.forName(types[i]);
        }
        Method md = clazz.getMethod(method, typeClasses);
        return md.invoke(obj, args);
    }
    
    public static Object invokeMethod(Object object,String method,Object... args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, MethodAmbiguousException{
        List<Method> mds = methodSelector.select(object.getClass().getMethods(), method, getObjectTypes(args));
        if(mds.isEmpty()){
            throw new NoSuchMethodException(method);
        }else if(mds.size()==1){
            return mds.get(0).invoke(object, args);
        }else{
            throw new MethodAmbiguousException(mds.toArray(new Method[mds.size()]));
        }
    }
   
}

class JavaMethodSelector extends MethodSelector<Method,Class>{

    @Override
    protected String getMethodName(Method m) {
        return m.getName();
    }

    @Override
    protected Class[] getMethodParameterTypes(Method m) {
        return m.getParameterTypes();
    }
    

    @Override
    protected boolean isMorePreciseType(Class actualType,Class candidate1, Class candidate2) {
        if(candidate1.equals(candidate2)) return false;
        if(candidate2.isAssignableFrom(candidate1)) return true;
        //TODO handle primitive and class type
        return false;
    }

    @Override
    protected boolean isAssignableFrom(Class to, Class from) {
        return to.isAssignableFrom(from);
    }
    
}