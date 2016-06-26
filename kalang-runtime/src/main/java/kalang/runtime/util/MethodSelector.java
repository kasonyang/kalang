package kalang.runtime.util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Kason Yang
 */
public abstract class MethodSelector<M,T> {
    
    public boolean matchType(T objClass,T declaredClass){
        return isAssignableFrom(declaredClass, objClass);
    }
    
    public boolean matchType(T[] objClasses,T[] declaredClasses){
        int objLen = objClasses.length;
        int declaredLen = declaredClasses.length;
        if(objLen!=declaredLen) return false;
        for(int i=0;i<objLen;i++){
            if(!matchType(objClasses[i], declaredClasses[i])) return false;
        }
        return true;
    }
    
    private boolean equalsTypes(T[] types1,T[] types2){
        if(types1.length!=types2.length) return false;
        for(int i=0;i<types1.length;i++){
            if(!equalsType(types1[i], types2[i])) return false;
        }
        return true;
    }
    
    public List<M> select(M[] mds,String name,T... argTypes){
        List<M> matched = new ArrayList(mds.length);
        for(M m:mds){
            if(!name.equals(getMethodName(m))) continue;
            T[] types = getMethodParameterTypes(m);
            if(equalsTypes(argTypes, types)){
                return Collections.singletonList(m);
            }
            if(matchType(argTypes, types)){
                matched.add(m);
            }
        }
        if(matched.size()<=1) return matched;
        return selectMostPrecise(matched,argTypes);
    }
    
    private boolean isMorePreciseTypes(T[] actualTypes,T[] typesToCompare1,T[] typesToCompare2){
        if(typesToCompare1.length!=typesToCompare2.length) return false;
        boolean isMorePrecise = false;
        for(int i=0;i<typesToCompare1.length;i++){
            T at = actualTypes[i];
            T t1 = typesToCompare1[i];
            T t2 = typesToCompare2[i];
            if(equalsType(t1, t2)) continue;
            if(isMorePreciseType(at,t2,t1)) return false;
            if(isMorePreciseType(at,t1, t2)){
                isMorePrecise = true;
            }
        }
        return isMorePrecise;
    }
     
    private List<M> selectMostPrecise(List<M>mds,T[] actualTypes){
        int size = mds.size();
        if(size==0) return new ArrayList();
        M ret = mds.get(0);
        for(int i=1;i<size;i++){
            M m = mds.get(i);
            T[] mpts = getMethodParameterTypes(m);
            T[] retTypes = getMethodParameterTypes(ret);
            if(isMorePreciseTypes(actualTypes,mpts, retTypes)){
                ret = m;
                continue;
            }
            if(isMorePreciseTypes(actualTypes,retTypes, mpts)){
                continue;
            }
            return Arrays.asList(ret,m);
        }
        return Collections.singletonList(ret);
    }

    protected abstract String getMethodName(M method) ;

    protected abstract T[] getMethodParameterTypes(M method);
    
    /**
     * 
     * @param actualType
     * @param candidate1
     * @param candidate2
     * @return true if candidate1 is more precise
     */
    protected abstract boolean isMorePreciseType(T actualType,T candidate1,T candidate2);
    
    protected abstract boolean isAssignableFrom(T to,T from);
    
    protected abstract boolean equalsType(T type1,T type2);

}
