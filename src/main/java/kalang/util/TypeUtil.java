package kalang.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;
import kalang.ast.MethodNode;
import kalang.core.ObjectType;
import kalang.core.GenericType;
import kalang.core.ClassType;
import kalang.core.PrimitiveType;
import kalang.core.Type;
import kalang.core.Types;

/**
 *
 * @author Kason Yang
 */
public class TypeUtil {
    public static boolean equalTypes(Type[] declaredTypes,Type[] argTypes,@Nullable Map<GenericType,Type> genericTypes){
        if(declaredTypes.length!=argTypes.length) return false;
        if(declaredTypes.length==0) return true;
        for(int i=0;i<declaredTypes.length;i++){
            Type dt = declaredTypes[i];
            if(dt instanceof GenericType){
                if(genericTypes!=null){
                    dt = genericTypes.get((GenericType)dt);
                    Objects.requireNonNull(dt);
                }
            }
            if(!equalType(dt,argTypes[i],genericTypes)) return false;
        }
        return true;
    }

    public static  boolean equalType(Type declaredType, Type argType,@Nullable Map<GenericType,Type> genericTypes) {
        if(declaredType instanceof GenericType){
            if(genericTypes!=null){
                declaredType = genericTypes.get((GenericType)declaredType);
                Objects.requireNonNull(declaredType);
            }
        }
        return declaredType.equals(argType);
    }
    
    public static String toString(Type[] types,String delimiter){
        List<String> list = new ArrayList(types.length);
        for(Type t:types){
            list.add(t.toString());
        }
        return String.join(delimiter, list);
    }
    
    public static Type getCommonType(Type... types){
        if(types.length==0) return Types.getRootType();
        if(types.length==1) return types[0];
        Type ret = types[0];
        for(int i=1;i<types.length;i++){
            Type t = types[i];
            if(!t.equals(ret)){
                if((ret instanceof PrimitiveType) && (t instanceof PrimitiveType)){
                    ret = Types.getHigherType(ret, t);
                }else{
                    if(t.isAssignableFrom(ret)){
                        ret = t;
                    }else if(!ret.isAssignableFrom(t)){
                        ret = Types.getRootType();
                    }
                }
            }
        }
        return ret;
    }
    
}
