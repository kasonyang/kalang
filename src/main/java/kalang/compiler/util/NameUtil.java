package kalang.compiler.util;

import javax.annotation.Nullable;

/**
 *
 * @author Kason Yang 
 */
public class NameUtil {
    
    public static String firstCharToUpperCase(String name){
        if(name.isEmpty()){
            return "";
        }else if(name.length()==1){
            return name.toUpperCase();
        }else{
            return name.substring(0,1).toUpperCase() + name.substring(1);
        }
    }

    public static String getClassNameWithoutPackage(String name) {
        int dotIdx = name.lastIndexOf('.');
        if (dotIdx > 0) {
            return name.substring(dotIdx + 1);
        } else {
            return name;
        }
    }
    
    public static String getSimpleClassName(String className){
        String name = getClassNameWithoutPackage(className);
        String[] parts = name.split("\\$");
        return parts[parts.length-1];
    }

    @Nullable
    public static String getPackageName(String name) {
        int dotIdx = name.lastIndexOf('.');
        if (dotIdx > 0) {
            return name.substring(0, dotIdx);
        } else {
            return null;
        }
    }

}
