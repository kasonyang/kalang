package kalang.compiler.util;

import kalang.compiler.core.*;
import kalang.mixin.CollectionMixin;

import java.util.ArrayList;
import java.util.List;

import static kalang.compiler.core.Types.*;
import static kalang.compiler.core.Types.NULL_TYPE;

/**
 *
 * @author Kason Yang
 */
public class TypeUtil {
    
    public static String toString(Type[] types,String delimiter, boolean simple){
        List<String> list = new ArrayList<>(types.length);
        for(Type t:types){
            list.add(t.getName(simple));
        }
        return String.join(delimiter, list);
    }
    
    public static Type getCommonType(Type... types){
        if(types.length==0) return Types.getRootType(NullableKind.UNKNOWN);
        if(types.length==1) return types[0];
        Type ret = CollectionMixin.find(types, it -> !Types.NULL_TYPE.equals(it));
        if (ret == null) {
            return Types.NULL_TYPE;
        }
        boolean requireNullable = isNullable(ret);
        for (Type t : types) {
            requireNullable = requireNullable || isNullable(ret);
            if (t.equals(ret)) {
                continue;
            }
            if (Types.NULL_TYPE.equals(t)) {
                requireNullable = true;
                continue;
            }
            if ((Types.isPrimitiveDataType(ret)) && (Types.isPrimitiveDataType(t))) {
                ret = Types.getHigherType(ret, t);
                continue;
            }
            if (t.isAssignableFrom(ret)) {
                ret = t;
                continue;
            }
            if (ret.isAssignableFrom(t)) {
                continue;
            }
            if (t instanceof ObjectType) {
                ObjectType tSuperType = ((ObjectType) t).getSuperType();
                if (tSuperType != null) {
                    ret = getCommonType(ret, tSuperType);
                    continue;
                }
            }
            ret = Types.getRootType(NullableKind.UNKNOWN);
        }
        if (requireNullable) {
            if (ret instanceof PrimitiveType) {
                ret = Types.getClassType((PrimitiveType) ret);
            }
            ret = Types.getObjectType((ObjectType)ret, NullableKind.NULLABLE);
        }
        return ret;
    }

    public static Type normalizeForMethod(Type type) {
        //wildcards is used only as reference parameters
        if (type instanceof WildcardType) {
            WildcardType wt = (WildcardType) type;
            ClassType rootObjType = Types.getRootType(wt.getNullable());
            ObjectType superType = wt.getSuperType();
            if (superType != null && !superType.equalsIgnoreNullable(rootObjType)) {
                return superType;
            }
            Type[] upperBounds = wt.getUpperBounds();
            if (upperBounds.length > 0) {
                return upperBounds[0];
            }
            return rootObjType;
        }
        return type;
    }

    public static String getTypeDescriptor(Type t) {
        if (t instanceof PrimitiveType) {
            if (t.equals(VOID_TYPE)) {
                return "V";
            } else if (t.equals(BOOLEAN_TYPE)) {
                return "Z";
            } else if (t.equals(LONG_TYPE)) {
                return "J";
            } else if (t.equals(INT_TYPE)) {
                return "I";
            } else if (t.equals(CHAR_TYPE)) {
                return "C";
            } else if (t.equals(SHORT_TYPE)) {
                return "S";
            } else if (t.equals(BYTE_TYPE)) {
                return "B";
            } else if (t.equals(FLOAT_TYPE)) {
                return "F";
            } else if (t.equals(DOUBLE_TYPE)) {
                return "D";
            } else if (t.equals(NULL_TYPE)) {
                return "Ljava/lang/Object;";
            } else {
                throw Exceptions.unsupportedTypeException(t);
            }
        } else if (t instanceof ArrayType) {
            return "[" + getTypeDescriptor(((ArrayType) t).getComponentType());
        } else if (t instanceof GenericType) {
            GenericType gt = (GenericType) t;
            ObjectType st = gt.getSuperType();
            ObjectType[] itfs = gt.getInterfaces();
            if (itfs.length == 1 && st != null && st.isAssignableFrom(itfs[0])) {
                st = itfs[0];
            }
            return getTypeDescriptor(st);
        } else if (t instanceof ClassType) {
            return "L" + internalName(((ClassType) t).getClassNode().getName()) + ";";
        } else if (t instanceof WildcardType) {
            return getTypeDescriptor(((WildcardType) t).getSuperType());
        } else {
            throw Exceptions.unsupportedTypeException(t);
        }
    }

    private static String internalName(String className) {
        return className.replace(".", "/");
    }

    private static boolean isNullable(Type type) {
        if (type instanceof ObjectType) {
            NullableKind nullableKind = ((ObjectType) type).getNullable();
            return NullableKind.NULLABLE.equals(nullableKind);
        }
        return false;
    }
    
}
