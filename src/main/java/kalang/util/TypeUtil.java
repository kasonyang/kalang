package kalang.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;
import kalang.ast.MethodNode;
import kalang.core.ClassType;
import kalang.core.GenericType;
import kalang.core.ParameterizedType;
import kalang.core.PrimitiveType;
import kalang.core.Type;

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
    
}
