
package kalang.compiler.core;

import kalang.annotation.Nullable;
import kalang.compiler.ast.MethodNode;
import kalang.compiler.util.MethodUtil;

import java.lang.reflect.Modifier;
import java.security.InvalidParameterException;
import java.util.*;

/**
 *
 * @author Kason Yang
 */
public class MethodDescriptor{
    
    

    public MethodDescriptor(MethodNode method, ParameterDescriptor[] parameterDescriptors, Type returnType,Type[] exceptionTypes) {
        this.modifier = method.getModifier();
        this.methodNode = method;
        this.name = method.getName();
        this.parameterDescriptors = parameterDescriptors;
        Type[] ptypes = new Type[parameterDescriptors.length];
        for(int i=0;i<this.parameterDescriptors.length;i++){
            ptypes[i] = parameterDescriptors[i].getType();
        }
        parameterTypes = ptypes;
        this.returnType = returnType;
        this.exceptionTypes = exceptionTypes;
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

    protected final Type[] parameterTypes;
    protected final int modifier;
    protected final MethodNode methodNode;
    protected final ParameterDescriptor[] parameterDescriptors;
    protected final Type returnType;

    protected final String name;

    protected final Type[] exceptionTypes;

    public Type[] getParameterTypes() {
        return parameterTypes;
    }

    public int getModifier() {
        return modifier;
    }

    public MethodNode getMethodNode() {
        return methodNode;
    }

    public ParameterDescriptor[] getParameterDescriptors() {
        return parameterDescriptors;
    }

    public String getName() {
        return name;
    }

    public String getDeclarationKey(){
        return MethodUtil.getDeclarationKey(name, parameterTypes);
    }

    public Type getReturnType() {
        return returnType;
    }

    //TODO exception type should be object type
    public Type[] getExceptionTypes() {
        return exceptionTypes;
    }

    private static void inferGeneric(Type declaredType,Type actualArgType,Map<GenericType,Type> resultMap) {
        if (actualArgType instanceof ObjectType) {
            ObjectType actualArgObjectType = (ObjectType) actualArgType;
            ObjectType superType = actualArgObjectType.getSuperType();
            if (superType != null) {
                inferGeneric(declaredType, superType, resultMap);
            }
            ObjectType[] interfaces = actualArgObjectType.getInterfaces();
            for (ObjectType itf: interfaces) {
                inferGeneric(declaredType, itf, resultMap);
            }
        }
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
        } else{
            //do nothing
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
