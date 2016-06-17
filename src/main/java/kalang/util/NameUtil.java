package kalang.util;

import javax.annotation.Nullable;

/**
 *
 * @author Kason Yang <im@kasonyang.com>
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
