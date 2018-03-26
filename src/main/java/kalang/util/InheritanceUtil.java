package kalang.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kalang.ast.ClassNode;
import kalang.core.ObjectType;

/**
 *
 * @author Kason Yang
 */
public class InheritanceUtil {
    
    public static boolean isSubclassOf(ClassNode childClass,ClassNode parentClass){
        ObjectType[] interfaces = childClass.getInterfaces();
        ObjectType superType = childClass.getSuperType();
        List<ObjectType> list = new ArrayList(interfaces.length+1);
        list.addAll(Arrays.asList(interfaces));
        if (superType!=null){
            list.add(superType);
        }
        for(ObjectType it:list){
            ClassNode clz = it.getClassNode();
            if (clz.equals(parentClass)){
                return true;
            }
            if (isSubclassOf(clz,parentClass)) {
                return true;
            }
        }
        return false;
    }

}
