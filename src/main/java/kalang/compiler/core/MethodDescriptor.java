
package kalang.compiler.core;

import kalang.annotation.Nullable;
import kalang.compiler.ast.MethodNode;

import java.lang.reflect.Modifier;
import java.security.InvalidParameterException;
import java.util.*;

/**
 *
 * @author Kason Yang
 */
public class MethodDescriptor extends ExecutableDescriptor {
    
    

    public MethodDescriptor(MethodNode method, ParameterDescriptor[] parameterDescriptors, Type returnType,Type[] exceptionTypes) {
        super(method, parameterDescriptors,returnType,exceptionTypes);
    }

    @Override
    public String toString() {
        List<String> params = new ArrayList();
        for(ParameterDescriptor p:getParameterDescriptors()){
            params.add(String.format("%s %s", p.getType(),p.getName()));
        }
        return String.format("%s %s %s(%s)", Modifier.toString(modifier),returnType.toString(),name,String.join(",", params));
    }

    public MethodDescriptor toParameterized(Map<GenericType,Type> genericTypeMap, @Nullable Type[] actualArgumentTypes) {
        if (actualArgumentTypes != null && actualArgumentTypes.length>0) {
            Map<GenericType, Type> gtMap = new HashMap<>(genericTypeMap);
            inferGeneric(parameterTypes,actualArgumentTypes,gtMap);
            genericTypeMap = gtMap;
        }
        ParameterDescriptor[] pds = new ParameterDescriptor[parameterDescriptors.length];
        for(int i=0;i<pds.length;i++) {
            ParameterDescriptor originalPd = parameterDescriptors[i];
            pds[i] = new ParameterDescriptor(originalPd.getName(),parseGenericType(originalPd.getType(),genericTypeMap),originalPd.getModifier());
        }
        return new MethodDescriptor(methodNode,pds,parseGenericType(returnType,genericTypeMap),parseGenericType(exceptionTypes,genericTypeMap));
    }

    private static void inferGeneric(Type declaredType,Type actualArgType,Map<GenericType,Type> resultMap) {
        if (declaredType.equals(actualArgType)) {
            return;
        } else if (declaredType instanceof GenericType) {
            resultMap.put((GenericType)declaredType,actualArgType);
        } else if (declaredType instanceof ClassType && actualArgType instanceof ClassType) {
            ClassType actualPt = (ClassType) actualArgType;
            ClassType declaredPt = (ClassType) declaredType;
            Type[] actualPtArguments = actualPt.getTypeArguments();
            Type[] declaredPtArguments = declaredPt.getTypeArguments();
            inferGeneric(declaredPtArguments,actualPtArguments,resultMap);
        } else if (declaredType instanceof WildcardType && actualArgType instanceof ClassType) {
            WildcardType declWt = (WildcardType) declaredType;
            ClassType actualWt = (ClassType) actualArgType;
            Type[] declUbs = declWt.getUpperBounds();
            Type[] declLbs = declWt.getLowerBounds();
            for(Type ub:declUbs) {
                inferGeneric(ub,actualWt,resultMap);
            }
            for(Type lb:declLbs) {
                inferGeneric(lb,actualWt,resultMap);
            }
        } else if (declaredType instanceof ArrayType && actualArgType instanceof ArrayType) {
            Type declComponentType = ((ArrayType) declaredType).getComponentType();
            Type actualComponentType = ((ArrayType) actualArgType).getComponentType();
            inferGeneric(declComponentType, actualComponentType, resultMap);
        } else if (Types.NULL_TYPE.equals(actualArgType)){
            //do nothing
        } else {
            throw new InvalidParameterException();
        }
    }

    private static void inferGeneric(Type[] declaredTypes,Type[] actualTypes,Map<GenericType,Type> resultMap) {
        int min = Math.min(declaredTypes.length,actualTypes.length);
        for(int i=0;i<min;i++){
            inferGeneric(declaredTypes[i],actualTypes[i],resultMap);
        }
    }

    private static Type parseGenericType(Type type,Map<GenericType,Type> genericTypes){
        if(type instanceof GenericType){
            Type actualType = genericTypes.get((GenericType)type);
            return actualType == null ? type : actualType;
        }else if(type instanceof ClassType){
            ClassType pt = (ClassType) type;
            Type[] ptTypeArguments = pt.getTypeArguments();
            Type[] parsedTypeArguments = parseGenericType(ptTypeArguments,genericTypes);
            if(Arrays.equals(parsedTypeArguments, ptTypeArguments)) return type;
            return Types.getClassType(pt.getClassNode(), parsedTypeArguments);
        }else if(type instanceof PrimitiveType){
            return type;
        }else if(type instanceof WildcardType){
            WildcardType wt = (WildcardType) type;
            Type[] ubs = wt.getUpperBounds();
            Type[] lbs = wt.getLowerBounds();
            Type[] parsedUBs = parseGenericType(ubs, genericTypes);
            Type[] parsedLBs = parseGenericType(lbs, genericTypes);
            return new WildcardType(parsedUBs, parsedLBs);
        }else if(type instanceof ArrayType){
            Type ct = ((ArrayType) type).getComponentType();
            Type parsedCt = parseGenericType(ct, genericTypes);
            if(parsedCt.equals(ct)) return type;
            return Types.getArrayType(parsedCt, ((ArrayType) type).getNullable());
        }else{
            Exception ex = new Exception("unknown type:" + type);
            ex.printStackTrace(System.err);
            return type;
        }
    }

    private static Type[] parseGenericType(Type[] types,Map<GenericType,Type> genericTypes){
        Type[] actTypes = new Type[types.length];
        for(int i=0;i<actTypes.length;i++){
            actTypes[i] = parseGenericType(types[i],genericTypes);
        }
        return actTypes;
    }
    
    
    
}
