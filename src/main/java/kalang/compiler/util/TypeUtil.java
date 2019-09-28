package kalang.compiler.util;

import kalang.compiler.core.*;
import kalang.mixin.CollectionMixin;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
        Type ret = CollectionMixin.find(types, it -> !Types.NULL_TYPE.equals(it));
        if (ret == null) {
            return Types.NULL_TYPE;
        }
        boolean requireNullable = isNullable(ret);
        for(int i=0;i<types.length;i++){
            Type t = types[i];
            requireNullable = requireNullable || isNullable(ret);
            if(!t.equals(ret)){
                if (Types.NULL_TYPE.equals(t)) {
                    requireNullable = true;
                    continue;
                }
                if((Types.isPrimitiveDataType(ret)) && (Types.isPrimitiveDataType(t))){
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
        if (requireNullable) {
            if (ret instanceof PrimitiveType) {
                ret = Types.getClassType((PrimitiveType) ret);
            }
            ret = Types.getObjectType((ObjectType)ret, NullableKind.NULLABLE);
        }
        return ret;
    }

    private static boolean isNullable(Type type) {
        if (type instanceof ObjectType) {
            NullableKind nullableKind = ((ObjectType) type).getNullable();
            return NullableKind.NULLABLE.equals(nullableKind);
        }
        return false;
    }
    
}
