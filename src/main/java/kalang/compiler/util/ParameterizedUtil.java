package kalang.compiler.util;

import kalang.compiler.ast.ClassNode;
import kalang.compiler.core.*;

import java.util.*;

/**
 * @author KasonYang
 */
public class ParameterizedUtil {

    public static Type parameterizedType(Type type, Map<ClassNode,Type> genericTypes){
        if(type instanceof GenericType){
            Type actualType = genericTypes.get(((GenericType) type).getClassNode());
            return actualType == null ? type : actualType;
        }else if(type instanceof ClassType){
            ClassType pt = (ClassType) type;
            Type[] ptTypeArguments = pt.getTypeArguments();
            Type[] parsedTypeArguments = parameterizedType(ptTypeArguments,genericTypes);
            if(Arrays.equals(parsedTypeArguments, ptTypeArguments)) return type;
            return Types.getClassType(pt.getClassNode(), parsedTypeArguments, pt.getNullable());
        }else if(type instanceof PrimitiveType){
            return type;
        }else if(type instanceof WildcardType){
            WildcardType wt = (WildcardType) type;
            Type[] ubs = wt.getUpperBounds();
            Type[] lbs = wt.getLowerBounds();
            Type[] parsedUBs = parameterizedType(ubs, genericTypes);
            Type[] parsedLBs = parameterizedType(lbs, genericTypes);
            return new WildcardType(parsedUBs, parsedLBs);
        }else if(type instanceof ArrayType){
            Type ct = ((ArrayType) type).getComponentType();
            Type parsedCt = parameterizedType(ct, genericTypes);
            if(parsedCt.equals(ct)) return type;
            return Types.getArrayType(parsedCt, ((ArrayType) type).getNullable());
        }else{
            Exception ex = new Exception("unknown type:" + type);
            ex.printStackTrace(System.err);
            return type;
        }
    }

    public static Type[] parameterizedType(Type[] types, Map<ClassNode,Type> genericTypes){
        Type[] actTypes = new Type[types.length];
        for(int i=0;i<actTypes.length;i++){
            actTypes[i] = parameterizedType(types[i],genericTypes);
        }
        return actTypes;
    }

    public static Map<ClassNode, Type> getGenericTypeMap(Type[] declaredTypes, Type[] actualTypes) {
        return getGenericTypeMap(Arrays.asList(declaredTypes), Arrays.asList(actualTypes));
    }

    public static Map<ClassNode, Type> getGenericTypeMap(List<Type> declaredTypes, List<Type> actualTypes) {
        Map<ClassNode, Type> result = new HashMap<>();
        collectGenericTypeMap(declaredTypes, actualTypes, result);
        return result;
    }

    private static void collectGenericTypeMap(List<Type> declaredTypes, List<Type> actualTypes, Map<ClassNode, Type> resultMap) {
        int min = Math.min(declaredTypes.size(), actualTypes.size());
        for (int i = 0; i < min; i++) {
            Map<ClassNode, Type> rm = new HashMap<>();
            collectGenericTypeMap(declaredTypes.get(i), actualTypes.get(i), rm);
            mergeGenericType(resultMap, rm);
        }
    }

    private static void collectGenericTypeMap(Type declaredType, Type actualArgType, Map<ClassNode, Type> resultMap) {
        if (actualArgType instanceof ObjectType) {
            ObjectType actualArgObjectType = (ObjectType) actualArgType;
            ObjectType superType = actualArgObjectType.getSuperType();
            if (superType != null) {
                collectGenericTypeMap(declaredType, superType, resultMap);
            }
            ObjectType[] interfaces = actualArgObjectType.getInterfaces();
            for (ObjectType itf : interfaces) {
                collectGenericTypeMap(declaredType, itf, resultMap);
            }
        }
        if (declaredType.equals(actualArgType)) {
            return;
        } else if (declaredType instanceof GenericType) {
            resultMap.put(((GenericType) declaredType).getClassNode(), actualArgType);
        } else if (declaredType instanceof ClassType && actualArgType instanceof ClassType) {
            ClassType actualPt = (ClassType) actualArgType;
            ClassType declaredPt = (ClassType) declaredType;
            Type[] actualPtArguments = actualPt.getTypeArguments();
            Type[] declaredPtArguments = declaredPt.getTypeArguments();
            collectGenericTypeMap(Arrays.asList(declaredPtArguments), Arrays.asList(actualPtArguments), resultMap);
        } else if (declaredType instanceof WildcardType && actualArgType instanceof ClassType) {
            WildcardType declWt = (WildcardType) declaredType;
            ClassType actualWt = (ClassType) actualArgType;
            Type[] declUbs = declWt.getUpperBounds();
            Type[] declLbs = declWt.getLowerBounds();
            for (Type ub : declUbs) {
                collectGenericTypeMap(ub, actualWt, resultMap);
            }
            for (Type lb : declLbs) {
                collectGenericTypeMap(lb, actualWt, resultMap);
            }
        } else if (declaredType instanceof ArrayType && actualArgType instanceof ArrayType) {
            Type declComponentType = ((ArrayType) declaredType).getComponentType();
            Type actualComponentType = ((ArrayType) actualArgType).getComponentType();
            collectGenericTypeMap(declComponentType, actualComponentType, resultMap);
        } else {
            //do nothing
        }
    }

    private static void mergeGenericType(Map<ClassNode, Type> resultMap, Map<ClassNode, Type> otherMap) {
        for (Map.Entry<ClassNode, Type> e : otherMap.entrySet()) {
            resultMap.merge(e.getKey(), e.getValue(), (t1, t2) -> TypeUtil.getCommonType(t1, t2));
        }
    }

}
