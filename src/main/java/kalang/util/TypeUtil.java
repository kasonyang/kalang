package kalang.util;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;
import kalang.ast.MethodNode;
import kalang.ast.ParameterNode;
import kalang.core.ClassType;
import kalang.core.GenericType;
import kalang.core.ParameterizedType;
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
    
    public static Type getMethodActualReturnType(ClassType clazz,MethodNode mn){
        Map<GenericType, Type> genericTypes = null;
        if(clazz instanceof ParameterizedType){
            genericTypes = ((ParameterizedType)clazz).getParameterTypesMap();    
        }
        Type type = mn.type;
        if(genericTypes!=null && (type instanceof GenericType)){
            type = genericTypes.get((GenericType)type);
        }
        return type;
    }
    
    public static Type[] getMethodActualParameterTypes(ClassType clazz,MethodNode mn){
        Map<GenericType, Type> genericTypes = null;
        if(clazz instanceof ParameterizedType){
            genericTypes = ((ParameterizedType)clazz).getParameterTypesMap();    
        }
        List<ParameterNode> params = mn.parameters;
        Type[] types = new Type[params.size()];
        for(int i=0;i<types.length;i++){
            Type pt = params.get(i).type;
            if(genericTypes!=null && (pt instanceof GenericType)){
                types[i] = genericTypes.get((GenericType)pt);
            }else{
                types[i] = pt;
            }
        }
        return types;
    }
}
