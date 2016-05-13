package kalang.util;
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

}
