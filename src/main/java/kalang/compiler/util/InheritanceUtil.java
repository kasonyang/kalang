package kalang.compiler.util;

import kalang.compiler.ast.ClassNode;
import kalang.compiler.core.ObjectType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

    public static boolean isInnerClassOf(ClassNode innerClass, ClassNode outerClass) {
        return innerClass.name.startsWith(outerClass.name) && innerClass.name.length() != outerClass.name.length();
    }

    public static boolean isInSamePackage(ClassNode class1, ClassNode class2) {
        return Objects.equals(NameUtil.getPackageName(class1.name), NameUtil.getPackageName(class2.name));
    }

}
