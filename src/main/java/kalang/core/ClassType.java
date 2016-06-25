
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
    
    Type[] typeArguments;
    
    protected ClassType(ClassNode clazz,Type[] typeArguments,NullableKind nullable ) {
        super(clazz,nullable);
        this.typeArguments = typeArguments;
        //TODO check typeArguments.length
    }

    public Type[] getTypeArguments() {
        return typeArguments.length>0?typeArguments:clazz.getGenericTypes();
    }
    
    public Map<GenericType,Type> getTypeArgumentsMap(){
        ClassNode clz = getClassNode();
        GenericType[] gts = clz.getGenericTypes();
        Map<GenericType,Type> ret = new HashMap();
        if(typeArguments.length>0){
            for(int i=0;i<gts.length;i++){
                ret.put(gts[i], typeArguments[i]);
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
        Type[] pTypes = getTypeArguments();
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
        Type[] thisPts = this.getTypeArguments();
        Type[] otherPts = other.getTypeArguments();
        if (!Arrays.deepEquals(thisPts,otherPts)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Arrays.deepHashCode(this.typeArguments);
        return hash;
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

    @Override
    protected Type parseType(Type type) {
        Map<GenericType, Type> genericTypes;
        genericTypes = this.getTypeArgumentsMap();    
        return parseGenericType(type, genericTypes);
    }

    @Override
    public boolean isAssignedFrom(Type type) {
        if(equalAndNullAssignChecked(type)) return true;
        if(!(type instanceof ClassType)) return false;
        ClassType other = (ClassType) type;
        if(!nullable.isAssignedFrom(other.getNullable())) return false;
        if(super.isAssignedFrom(type)) return true;
        //handle parameterizedType
        Type[] typeArgs = getTypeArguments();
        if(typeArgs.length==0) return false;
        Type[] otherTypeArgs = other.getTypeArguments();
        if(typeArgs.length==otherTypeArgs.length){
            for(int i=0;i<typeArgs.length;i++){
                Type a = typeArgs[i];
                Type oa = otherTypeArgs[i];
                if(a.equals(oa)) continue;
                if(a instanceof WildcardType){
                    WildcardType wt = (WildcardType)a;
                    if(!wt.containsType((ObjectType)oa)) return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public ObjectType getSuperType() {
        ObjectType superType = super.getSuperType();
        if(superType!=null){
            superType =(ObjectType) parseType(superType);
        }
        return superType;
    }    

}
