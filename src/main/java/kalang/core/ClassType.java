
package kalang.core;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kalang.ast.ClassNode;
/**
 *
 * @author Kason Yang
 */
public class ClassType extends ObjectType {
    
    Type[] parameterTypes;
    
    protected ClassType(ClassNode rawType,Type[] parameterTypes,NullableKind nullable ) {
        //TODO may be bug
        super(rawType,nullable);
        this.parameterTypes = parameterTypes;
           //TODO check parameterTypes.length
    }

    public Type[] getParameterTypes() {
        return parameterTypes.length>0?parameterTypes:clazz.getGenericTypes();
    }
    
    public Map<GenericType,Type> getParameterTypesMap(){
        ClassNode clz = getClassNode();
        GenericType[] gts = clz.getGenericTypes();
        Map<GenericType,Type> ret = new HashMap();
        if(parameterTypes.length>0){
            for(int i=0;i<gts.length;i++){
                ret.put(gts[i], parameterTypes[i]);
            }
        }
        return ret;
    }

    @Override
    public String getDeclarationKey() {
        return clazz.name;
    }

    @Override
    public String getName() {
        Type[] pTypes = getParameterTypes();
        List<String> paramTypes = new ArrayList(pTypes.length);
        for(Type t:pTypes){
            paramTypes.add(t.getName());
        }
        String suffix = paramTypes.isEmpty() ? "" : "<" + String.join(",",paramTypes) + ">";
        return clazz.name + suffix;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClassType other = (ClassType) obj;
        if (!Objects.equals(this.clazz, other.clazz)) {
            return false;
        }
        Type[] thisPts = this.getParameterTypes();
        Type[] otherPts = other.getParameterTypes();
        if (!Arrays.deepEquals(thisPts,otherPts)) {
            return false;
        }
        return true;
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
        }else if(type instanceof ClassType){
            ClassType pt = (ClassType) type;
            Type[] ptParameterizedTypes = pt.getParameterTypes();
            Type[] parsedParamTypes = parseGenericType(ptParameterizedTypes,genericTypes);
            if(Arrays.equals(parsedParamTypes, ptParameterizedTypes)) return type;
            return Types.getClassType(pt.getClassNode(), parsedParamTypes);
        }else if(type instanceof PrimitiveType){
            return type;
        }else if(type instanceof WildcardType){
            WildcardType wt = (WildcardType) type;
            Type[] ubs = wt.getUpperBounds();
            Type[] lbs = wt.getLowerBounds();
            Type[] parsedUBs = parseGenericType(ubs, genericTypes);
            Type[] parsedLBs = parseGenericType(lbs, genericTypes);
            return new kalang.core.WildcardType(parsedUBs, parsedLBs);
        }else if(type instanceof ArrayType){
            Type ct = ((ArrayType) type).getComponentType();
            Type parsedCt = parseGenericType(ct, genericTypes);
            if(parsedCt.equals(ct)) return type;
            return Types.getArrayType(parsedCt, ((ArrayType) type).getNullable());
        }else{
            System.err.println("unknown type:" + type);
            return type;
        }        
    }
    
    private Type getActualType(Type type){
        Map<GenericType, Type> genericTypes;
        genericTypes = this.getParameterTypesMap();    
        return parseGenericType(type, genericTypes);
    }
    
    private Type[] getActualType(Type[] types){
        Type[] actTypes = new Type[types.length];
        for(int i=0;i<types.length;i++){
            actTypes[i] = getActualType(types[i]);
        }
        return actTypes;
    }

    @Override
    protected Type parseType(Type type) {
        return getActualType(type);
    }

    @Override
    public boolean isAssignedFrom(Type type) {
        if(equalAndNullAssignChecked(type)) return true;
        if(!(type instanceof ClassType)) return false;
        ClassType other = (ClassType) type;
        if(!nullable.isAssignedFrom(other.getNullable())) return false;
        //TODO impl parameterizedTYpe.isAssignedFrom
        return super.isAssignedFrom(type);
    }

    @Override
    public ObjectType getSuperType() {
        ObjectType superType = super.getSuperType();
        if(superType!=null){
            superType =(ObjectType) getActualType(superType);
        }
        return superType;
    }
    
    

}
