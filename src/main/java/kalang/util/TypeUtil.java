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
    
    public static Type getMethodActualReturnType(ClassType clazz,MethodNode mn){
        return getActualType(clazz, mn.type);
    }
    
    public static Type[] getMethodActualParameterTypes(ClassType clazz,MethodNode mn){
        Type[] paramsTypes = AstUtil.getParameterTypes(mn);
        return getActualType(clazz, paramsTypes);
    }
    
    private static Type[] parseGenericType(Type[] types,Map<GenericType,Type> genericTypes){
        Type[] actTypes = new Type[types.length];
        for(int i=0;i<actTypes.length;i++){
            actTypes[i] = parseGenericType(types[i],genericTypes);
        }
        return actTypes;
    }
    
    private static Type parseGenericType(Type type,Map<GenericType,Type> genericTypes){
        if(type instanceof GenericType){
            Type actualType = genericTypes.get((GenericType)type);
            return actualType == null ? type : actualType;
        }else if(type instanceof ParameterizedType){
            ParameterizedType pt = (ParameterizedType) type;
            Type[] ptParameterizedTypes = pt.getParameterTypes();
            Type[] parsedParamTypes = parseGenericType(ptParameterizedTypes,genericTypes);
            if(Arrays.equals(parsedParamTypes, ptParameterizedTypes)) return type;
            return new ParameterizedType(pt.getRawType(), parsedParamTypes);
        }else if(type instanceof ClassType){
            return type;
        }else if(type instanceof PrimitiveType){
            return type;
        }else{
            System.err.println("unknown type:" + type);
            return type;
        }        
    }
    
    public static Type getActualType(ClassType clazz,Type type){
        Map<GenericType, Type> genericTypes;
        if(clazz instanceof ParameterizedType){
            genericTypes = ((ParameterizedType)clazz).getParameterTypesMap();    
        }else{
            genericTypes = new HashMap();
        }
        return parseGenericType(type, genericTypes);
    }
    
    public static Type[] getActualType(ClassType clazz,Type[] types){
        Type[] actTypes = new Type[types.length];
        for(int i=0;i<types.length;i++){
            actTypes[i] = getActualType(clazz, types[i]);
        }
        return actTypes;
    }
    
}
