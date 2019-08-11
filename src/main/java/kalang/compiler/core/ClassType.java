
package kalang.compiler.core;

import kalang.compiler.ast.ClassNode;
import kalang.compiler.exception.Exceptions;

import java.util.*;
/**
 *
 * @author Kason Yang
 */
public class ClassType extends ObjectType {
    
    Type[] typeArguments;
    
    protected ClassType(ClassNode clazz,Type[] typeArguments,NullableKind nullable ) {
        super(clazz,nullable);
        this.typeArguments = typeArguments;
        //TODO check typeArguments.length.clazz may be uninitailized
//        if(typeArguments.length>0 && typeArguments.length != clazz.getGenericTypes().length){
//            throw new IllegalArgumentException("illegal size of typeArguments");
//        }
    }

    public Type[] getTypeArguments() {
        return typeArguments;
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
        if(nullable.equals(NullableKind.NULLABLE)){
            suffix += "?";
        }
        return  clazz.name + suffix;
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
        return nullable.equals(other.getNullable());
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
    
    private Type eraseGenericType(Type type){
        if(type instanceof PrimitiveType){
            return type;
        }else if(type instanceof GenericType){
            GenericType gt = (GenericType) type;
            ObjectType superType = gt.getSuperType();
            if(superType!=null) return superType;
            ObjectType[] bs = gt.getInterfaces();
            if(bs.length>0) return bs[0];
            return Types.getRootType();
        }else if(type instanceof ClassType){
            ClassType ct = (ClassType) type;
            Type[] typeArgs = ct.getTypeArguments();
            if(typeArgs.length==0) return ct;
            return Types.getClassType(ct.getClassNode(),new Type[0]);
        }else if(type instanceof WildcardType){
            return eraseGenericType(((WildcardType) type).getSuperType());
        }else if(type instanceof ArrayType){
            ArrayType at = (ArrayType) type;
            return Types.getArrayType(eraseGenericType(at.getComponentType()));
        }else{
            throw Exceptions.unsupportedTypeException(type);
        }
    }

    @Override
    protected Type parseType(Type type) {
        Map<GenericType, Type> genericTypes = this.getTypeArgumentsMap();
        //FIXME it would also erase generic types declared in method
        return genericTypes.isEmpty() && clazz.getGenericTypes().length>0 ? eraseGenericType(type) : parseGenericType(type, genericTypes);
    }

    @Override
    public boolean isAssignableFrom(Type type) {
        if(super.isAssignableFrom(type)) return true;
        if(type instanceof ClassType){
            ClassType other = (ClassType) type;
            if(!nullable.isAssignableFrom(other.getNullable())) return false;
            ClassNode otherClazz = other.getClassNode();
            if(!clazz.equals(otherClazz)) return false;
            GenericType[] gts = clazz.getGenericTypes();
            if(gts.length==0) return true;
            //handle parameterizedType
            Type[] typeArgs = getTypeArguments();
            Type[] otherTypeArgs = other.getTypeArguments();
            if(typeArgs.length==0 || otherTypeArgs.length==0) return true;
            if(typeArgs.length!=otherTypeArgs.length) return false;
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

    public ClassType toParameterized(Map<GenericType,Type> genericTypeTypeMap) {
        GenericType[] gts = clazz.getGenericTypes();
        Type[] typeArgs = new Type[gts.length];
        for(int i=0;i<typeArgs.length;i++) {
            Type aType = genericTypeTypeMap.get(gts[i]);
            typeArgs[i] = aType==null ? gts[i] : aType;
        }
        return Types.getClassType(clazz,typeArgs);
    }

}
