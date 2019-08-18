package kalang.runtime.util;
import java.util.*;

/**
 *
 * @author Kason Yang
 */
public abstract class MethodSelector<M,T,A> {
    
    public List<M> select(M[] mds,String name,A... args){
        List<M> matched = new ArrayList<>(mds.length);
        for(M m:mds){
            if(!name.equals(getMethodName(m))){
                continue;
            }
            T[] types = getMethodParameterTypes(m);
            if (types.length != args.length) {
                continue;
            }
            int[] matchScore = getMatchScore(args, types);
            if(isFullMatchScore(matchScore)){
                return Collections.singletonList(m);
            }
            if (isValidMatchScore(matchScore)) {
                matched.add(m);
            }
        }
        if (matched.isEmpty()) {
            return Collections.emptyList();
        }
        return selectMostPrecise(matched,args);
    }
    
    private boolean isMorePreciseTypes(A[] arguments,T[] typesToCompare1,T[] typesToCompare2){
        if(typesToCompare1.length!=typesToCompare2.length){
            return false;
        }
        boolean isMorePrecise = false;
        for(int i=0;i<typesToCompare1.length;i++){
            A at = arguments[i];
            T t1 = typesToCompare1[i];
            T t2 = typesToCompare2[i];
            if(equalsType(t1, t2)){
                continue;
            }
            if(isMorePreciseType(at,t2,t1)){
                return false;
            }
            if(isMorePreciseType(at,t1, t2)){
                isMorePrecise = true;
            }
        }
        return isMorePrecise;
    }
     
    private List<M> selectMostPrecise(List<M>mds,A[] args){
        int size = mds.size();
        if(size==0) return new ArrayList();
        M ret = mds.get(0);
        for(int i=1;i<size;i++){
            M m = mds.get(i);
            T[] mpts = getMethodParameterTypes(m);
            T[] retTypes = getMethodParameterTypes(ret);
            if(isMorePreciseTypes(args,mpts, retTypes)){
                ret = m;
                continue;
            }
            if(isMorePreciseTypes(args,retTypes, mpts)){
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
     * @param actualType actual type
     * @param candidate1 first candidate
     * @param candidate2 second candidate
     * @return true if candidate1 is more precise
     */
    protected abstract boolean isMorePreciseType(A actualType,T candidate1,T candidate2);

    protected abstract boolean equalsType(T type1,T type2);

    protected abstract int getMatchScore(A arg,T type);

    private int[] getMatchScore(A[] args, T[] types) {
        int[] score = new int[args.length];
        for (int i=0; i < args.length; i++) {
            score[i] = getMatchScore(args[i], types[i]);
        }
        return score;
    }

    private boolean isFullMatchScore(int[] score) {
        for (int i=0; i < score.length; i++) {
            if (score[i] != 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidMatchScore(int[] score) {
        for (int i=0; i < score.length; i++) {
            if (score[i] < 0) {
                return false;
            }
        }
        return true;
    }

}
