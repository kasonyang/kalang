package kalang.compiler.util;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Kason Yang
 */
public class CollectionsUtil {
    
    public static <T> Set<T> getIntersection(Set<T>... collections){
        Set<T> sets = new HashSet<>();
        if(collections.length<2) return sets;
        sets = collections[0];
        for(int i=1;i<collections.length;i++){
            Set<T> c = sets;
            Set<T> c2 = collections[i];
            sets.clear();
            for(T it:c){
                if(c2.contains(it)){
                    sets.add(it);
                }
            }
        }
        return sets;
    }

}
