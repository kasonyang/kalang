package kalang.compiler.util;

import kalang.compiler.core.Type;

import java.lang.reflect.Modifier;

/**
 *
 * @author Kason Yang
 */
public class OverrideUtil {
    
    private static boolean throwable(Type type,Type[] exceptionTypes){
        for(Type t:exceptionTypes){
            if(t.isAssignableFrom(type)) return true;
        }
        return false;
    }
    
    public static boolean exceptionTypeCompatible(Type[] newExceptionTypes,Type[] oldExceptionTypes){
        for(Type nt:newExceptionTypes){
            if(!throwable(nt, oldExceptionTypes)) return false;
        }
        return true;
    }

    public static boolean overridingCompatible(int newModifier, int oldModifier) {
        return Modifier.isStatic(oldModifier) == Modifier.isStatic(newModifier) && Modifier.isPrivate(oldModifier) == Modifier.isPrivate(newModifier) && Modifier.isProtected(oldModifier) == Modifier.isProtected(newModifier) && Modifier.isPublic(oldModifier) == Modifier.isPublic(newModifier);
    }
    
    public static boolean returnTypeCompatible(Type newType,Type oldType){
        return oldType.isAssignableFrom(newType);
    }

}
