
package kalang.compiler.core;

import kalang.compiler.ast.ClassNode;
import kalang.compiler.util.Exceptions;
import kalang.compiler.util.NameUtil;
import kalang.compiler.util.ParameterizedUtil;

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
    
    public Map<ClassNode,Type> getTypeArgumentsMap(){
        ClassNode clz = getClassNode();
        GenericType[] gts = clz.getGenericTypes();
        Map<ClassNode,Type> ret = new HashMap<>();
        if(typeArguments.length>0){
            for(int i=0;i<gts.length;i++){
                ret.put(gts[i].getClassNode(), typeArguments[i]);
            }
        }
        return ret;
    }

    @Override
    public String getDeclarationKey() {
        return clazz.getName();
    }

    @Override
    public String getName(boolean simple) {
        Type[] pTypes = getTypeArguments();
        List<String> paramTypes = new ArrayList<>(pTypes.length);
        for(Type t:pTypes){
            paramTypes.add(t.getName(simple));
        }
        String suffix = paramTypes.isEmpty() ? "" : "<" + String.join(",",paramTypes) + ">";
        if(nullable.equals(NullableKind.NULLABLE)){
            suffix += "?";
        }
        String className = simple ? NameUtil.getSimpleClassName(clazz.getName()) : clazz.getName();
        return  className + suffix + getNullableSuffix();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (!(other instanceof ObjectType)) {
            return false;
        }
        ObjectType objOther = (ObjectType) other;
        return nullable.equals(objOther.getNullable()) && equalsIgnoreNullable(objOther);
    }

    @Override
    public boolean equalsIgnoreNullable(ObjectType obj) {
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClassType other = (ClassType) obj;
        if (!Objects.equals(this.clazz, other.clazz)) {
            return false;
        }
        Type[] thisPts = this.getTypeArguments();
        Type[] otherPts = other.getTypeArguments();
        return Arrays.deepEquals(thisPts, otherPts);
    }

    @Override
    public int hashCode() {
        int hashCode = Objects.hashCode(clazz);
        hashCode = 31 * hashCode + Arrays.hashCode(typeArguments);
        hashCode = 31 * hashCode + Objects.hash(nullable);
        return hashCode;
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
            return Types.getClassType(ct.getClassNode(),new Type[0], ct.getNullable());
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
        Map<ClassNode, Type> genericTypes = this.getTypeArgumentsMap();
        //FIXME it would also erase generic types declared in method
        return genericTypes.isEmpty() && clazz.getGenericTypes().length>0 ? eraseGenericType(type) : ParameterizedUtil.parameterizedType(type, genericTypes);
    }

    @Override
    public boolean isAssignableFrom(Type type) {
        if(super.isAssignableFrom(type)) return true;
        if(type instanceof ClassType){
            ClassType other = (ClassType) type;
            // infer generic type from left type. For example: List<String> list = Collections.emptyList();
            Map<ClassNode, Type> gtm = ParameterizedUtil.getGenericTypeMap(new Type[]{other}, new Type[]{this});
            if (!gtm.isEmpty()) {
                other = other.toParameterized(gtm);
            }
            if(!nullable.isAssignableFrom(other.getNullable())) return false;
            ClassNode otherClazz = other.getClassNode();
            if(!clazz.getName().equals(otherClazz.getName())) return false;
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
                if (a.isAssignableFrom(oa) && oa.isAssignableFrom(a)) {
                    continue;
                }
                if(a instanceof WildcardType) {
                    WildcardType wt = (WildcardType) a;
                    if (!wt.containsType((ObjectType) oa)) {
                        return false;
                    }
                } else if (!(a instanceof GenericType) && !(oa instanceof GenericType)) {
                    return false;
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

    public ClassType toParameterized(Map<ClassNode,Type> genericTypeTypeMap) {
        GenericType[] declaredGenericTypes = clazz.getGenericTypes();
        Type[] typeArgs = new Type[declaredGenericTypes.length];
        for (int i = 0; i < typeArgs.length; i++) {
            typeArgs[i] = i < typeArguments.length ? typeArguments[i] : declaredGenericTypes[i];
        }
        Type[] newTypeArgs = ParameterizedUtil.parameterizedType(typeArgs, genericTypeTypeMap);
        return Types.getClassType(clazz,newTypeArgs, nullable);
    }

}
