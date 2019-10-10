package kalang.compiler.util;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Kason Yang
 */
public class CollectionsUtil {
    
    public static <T> Set<T> getIntersection(Set<T>... collections){
        if(collections.length<2) return new HashSet<>();
        Set<T> sets = new HashSet<>(collections[0]);
        for(int i=1;i<collections.length;i++){
            Set<T> c = new HashSet(sets);
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
