
package kalang.core;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kalang.ast.ClassNode;
import kalang.util.TypeUtil;
/**
 *
 * @author Kason Yang
 */
public class ParameterizedType extends ObjectType {
    
    Type[] parameterTypes;
    private final ObjectType rawType;
    
    protected ParameterizedType(ObjectType rawType,Type[] parameterTypes,NullableKind nullable ) {
        //TODO may be bug
        super(rawType.getClassNode(),rawType.getSuperType(),nullable);
        this.rawType = rawType;
        this.parameterTypes = parameterTypes;
        if(superType!=null){
            superType =(ObjectType) getActualType(superType);
        }
       //TODO check parameterTypes.length
    }

    public Type[] getParameterTypes() {
        return parameterTypes;
    }
    
    public Map<GenericType,Type> getParameterTypesMap(){
        ClassNode clz = getClassNode();
        GenericType[] gts = clz.getGenericTypes();
        Map<GenericType,Type> ret = new HashMap();
        for(int i=0;i<gts.length;i++){
            ret.put(gts[i], parameterTypes[i]);
        }
        return ret;
    }

    public ObjectType getRawType() {
        return rawType;
    }

    @Override
    public String getDeclarationKey() {
        return rawType.getDeclarationKey();
    }

    @Override
    public String getName() {
        List<String> paramTypes = new ArrayList(parameterTypes.length);
        for(Type t:parameterTypes){
            paramTypes.add(t.getName());
        }
        return rawType.getName() + "<" + String.join(",",paramTypes) + ">";
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
        final ParameterizedType other = (ParameterizedType) obj;
        if (!Arrays.deepEquals(this.parameterTypes, other.parameterTypes)) {
            return false;
        }
        if (!Objects.equals(this.rawType, other.rawType)) {
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
        }else if(type instanceof ParameterizedType){
            ParameterizedType pt = (ParameterizedType) type;
            Type[] ptParameterizedTypes = pt.getParameterTypes();
            Type[] parsedParamTypes = parseGenericType(ptParameterizedTypes,genericTypes);
            if(Arrays.equals(parsedParamTypes, ptParameterizedTypes)) return type;
            return Types.getParameterizedType(pt.getRawType(), parsedParamTypes);
        }else if(type instanceof ObjectType){
            return type;
        }else if(type instanceof PrimitiveType){
            return type;
        }else if(type instanceof WildcardType){
            WildcardType wt = (WildcardType) type;
            Type[] ubs = wt.getUpperBounds();
            Type[] lbs = wt.getLowerBounds();
            Type[] parsedUBs = parseGenericType(ubs, genericTypes);
            Type[] parsedLBs = parseGenericType(lbs, genericTypes);
            return new kalang.core.WildcardType(parsedUBs, parsedLBs);
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
        if(!(type instanceof ParameterizedType)) return false;
        ParameterizedType other = (ParameterizedType) type;
        if(!nullable.isAssignedFrom(other.getNullable())) return false;
        //TODO impl parameterizedTYpe.isAssignedFrom
        return super.isAssignedFrom(type);
    }
    
    

}
