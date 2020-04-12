
package kalang.compiler.core.impl;

import kalang.annotation.Nullable;
import kalang.compiler.ast.MethodNode;
import kalang.compiler.core.GenericType;
import kalang.compiler.core.MethodDescriptor;
import kalang.compiler.core.ParameterDescriptor;
import kalang.compiler.core.Type;
import kalang.compiler.util.MethodUtil;
import kalang.compiler.util.ParameterizedUtil;

import java.lang.reflect.Modifier;
import java.util.*;

import static kalang.compiler.util.ParameterizedUtil.parameterizedType;

/**
 *
 * @author Kason Yang
 */
public class StandardMethodDescriptor implements MethodDescriptor {

    protected final Type[] parameterTypes;
    protected final int modifier;
    protected final MethodNode methodNode;
    protected final ParameterDescriptor[] parameterDescriptors;
    protected final Type returnType;

    protected final String name;

    protected final Type[] exceptionTypes;

    private final String declarationKey;


    public StandardMethodDescriptor(MethodNode method, ParameterDescriptor[] parameterDescriptors, Type returnType,Type[] exceptionTypes) {
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
        this.declarationKey = MethodUtil.getDeclarationKey(name, parameterTypes);
    }

    @Override
    public String toString() {
        List<String> params = new ArrayList();
        for(ParameterDescriptor p:getParameterDescriptors()){
            params.add(String.format("%s %s", p.getType(),p.getName()));
        }
        return String.format("%s %s %s(%s)", Modifier.toString(modifier),returnType.toString(),name,String.join(",", params));
    }

    @Override
    public MethodDescriptor toParameterized(Map<GenericType, Type> genericTypeMap, @Nullable Type[] actualArgumentTypes) {
        if (actualArgumentTypes != null && actualArgumentTypes.length>0) {
            Map<GenericType, Type> gtMap = new HashMap<>(genericTypeMap);
            gtMap.putAll(ParameterizedUtil.getGenericTypeMap(parameterTypes, actualArgumentTypes));
            genericTypeMap = gtMap;
        }
        ParameterDescriptor[] pds = new ParameterDescriptor[parameterDescriptors.length];
        for(int i=0;i<pds.length;i++) {
            ParameterDescriptor originalPd = parameterDescriptors[i];
            pds[i] = new StandardParameterDescriptor(originalPd.getName(), parameterizedType(originalPd.getType(),genericTypeMap),originalPd.getModifier());
        }
        return new StandardMethodDescriptor(methodNode,pds,parameterizedType(returnType,genericTypeMap),parameterizedType(exceptionTypes,genericTypeMap));
    }

    @Override
    public Type[] getParameterTypes() {
        return parameterTypes;
    }

    @Override
    public int getModifier() {
        return modifier;
    }

    @Override
    public MethodNode getMethodNode() {
        return methodNode;
    }

    @Override
    public ParameterDescriptor[] getParameterDescriptors() {
        return parameterDescriptors;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDeclarationKey(){
        return declarationKey;
    }

    @Override
    public Type getReturnType() {
        return returnType;
    }

    //TODO exception type should be object type
    @Override
    public Type[] getExceptionTypes() {
        return exceptionTypes;
    }

    
}
