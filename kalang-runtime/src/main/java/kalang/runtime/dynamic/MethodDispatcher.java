
package kalang.runtime.dynamic;

import kalang.runtime.util.MethodSelector;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 *
 * @author Kason Yang
 */
public class MethodDispatcher {
    
    private final static JavaMethodSelector methodSelector = new JavaMethodSelector();
    
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
        List<Method> mds = methodSelector.select(object.getClass().getMethods(), method, args);
        if(mds.isEmpty()){
            throw new NoSuchMethodException(method);
        }else if(mds.size()==1){
            return mds.get(0).invoke(object, args);
        }else{
            throw new MethodAmbiguousException(mds.toArray(new Method[mds.size()]));
        }
    }
   
}

class JavaMethodSelector extends MethodSelector<Method,Class<?>,Object>{

    @Override
    protected String getMethodName(Method m) {
        return m.getName();
    }

    @Override
    protected Class[] getMethodParameterTypes(Method m) {
        return m.getParameterTypes();
    }
    

    @Override
    protected boolean isMorePreciseType(Object arg,Class<?> candidate1, Class<?> candidate2) {
        if(candidate1.equals(candidate2)) {
            return false;
        }
        if(candidate2.isAssignableFrom(candidate1)) {
            return true;
        }
        //TODO handle primitive and class type
        return false;
    }

    @Override
    protected boolean equalsType(Class type1, Class type2) {
        return type1.equals(type2);
    }

    @Override
    protected int getMatchScore(Object arg, Class<?> type) {
        //TODO handle sugar
        Class<? extends Object> argClass = arg.getClass();
        if (argClass.equals(type)) {
            return 0;
        } else if (type.isAssignableFrom(argClass)) {
            return 1;
        }
        return -1;
    }

}