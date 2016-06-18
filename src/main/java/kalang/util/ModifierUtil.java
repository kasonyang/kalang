package kalang.util;

import java.lang.reflect.Modifier;

/**
 *
 * @author Kason Yang <im@kasonyang.com>
 */
public class ModifierUtil {
    
    public static int setPrivate(int modifier){
        return modifier
                & (~Modifier.PUBLIC)
                & (~Modifier.PROTECTED)
                | (Modifier.PRIVATE);
    }
    
    public static int setProtected(int modifier){
        return modifier
                & (~Modifier.PUBLIC)
                & (~Modifier.PRIVATE)
                | (Modifier.PROTECTED);
    }
    
    public static int setPublic(int modifier){
        return modifier
                & (~Modifier.PRIVATE)
                & (~Modifier.PROTECTED)
                | (Modifier.PUBLIC);
    }
    
    public static boolean overridingCompatible(int overridingModifier,int overriddenModifier){
        return 
                Modifier.isStatic(overriddenModifier) == Modifier.isStatic(overridingModifier)
                && 
                Modifier.isPrivate(overriddenModifier) == Modifier.isPrivate(overridingModifier)
                && Modifier.isProtected(overriddenModifier) == Modifier.isPrivate(overridingModifier)
                && Modifier.isPublic(overriddenModifier) == Modifier.isPrivate(overridingModifier)
                ;
        
    }

}
