
package kalang.compiler.core;

import kalang.compiler.ast.ClassNode;
import kalang.compiler.ast.FieldNode;
import kalang.compiler.ast.MethodNode;
import kalang.compiler.ast.ParameterNode;
import kalang.compiler.util.AccessUtil;
import kalang.compiler.util.MethodUtil;
import kalang.compiler.util.ModifierUtil;

import javax.annotation.Nullable;
import java.lang.reflect.Modifier;
import java.util.*;
/**
 *
 * @author Kason Yang
 */
public abstract class ObjectType extends Type{
    
    protected final ClassNode clazz;
    
    protected NullableKind nullable;

    public ObjectType(ClassNode clazz,NullableKind nullable) {
        this.clazz = clazz;
        this.nullable = nullable;
    }

    @Override
    public String getName() {
        return clazz.name;
    }

    public ClassNode getClassNode() {
        return clazz;
    }
    
    public boolean isSubTypeOf(Type targetType) {
        if(targetType instanceof ObjectType){
            ObjectType other = (ObjectType) targetType;
            ObjectType superType = getSuperType();
            if(superType!=null){
                if(superType.equals(other)) return true;
                if(superType.isSubTypeOf(other)) return true;
            }
            ObjectType[] interfaces = this.getInterfaces();
            for(ObjectType i:interfaces){
                if(i.equals(targetType)) return true;
                if(i.isSubTypeOf(targetType)) return true;
            }
        }
        return false;
    }
    
    private ParameterDescriptor[] getParameterDescriptors(MethodNode method){
        ParameterNode[] pms = method.getParameters();
        Type[] ptypes = parseTypes(MethodUtil.getParameterTypes(method));
        ParameterDescriptor[] pds = new ParameterDescriptor[ptypes.length];
        for(int j=0;j<pds.length;j++){
            ParameterNode p = pms[j];
            pds[j] = new ParameterDescriptor(p.getName(),ptypes[j],p.modifier);
        }
        return pds;
    }
    
    protected Type parseType(Type type){
        return type;
    }
    
    protected final Type[] parseTypes(Type[] types){
        Type[] ret = new Type[types.length];
        for(int i=0;i<types.length;i++){
            ret[i] = parseType(types[i]);
        }
        return ret;
    }

    public MethodDescriptor[] getMethodDescriptors(@Nullable ClassNode caller,boolean includeSuperType,boolean includeInterfaces){
        return getMethodDescriptors(caller,null,includeSuperType,includeInterfaces);
    }

    public MethodDescriptor[] getMethodDescriptors(@Nullable ClassNode caller,@Nullable String name,boolean includeSuperType,boolean includeInterfaces){
        Map<String,MethodDescriptor> descs = new HashMap();
        List<ObjectType> superList = new LinkedList();
        if(includeSuperType){
            ObjectType superType = getSuperType();
            if(superType==null && ModifierUtil.isInterface(getModifier())){
                superType = Types.getRootType();
            }
            if(superType!=null) superList.add(superType);
        }
        if(includeInterfaces){
            ObjectType[] itfs = getInterfaces();
            superList.addAll(Arrays.asList(itfs));
        }
        for(ObjectType st:superList){
            MethodDescriptor[] ms = st.getMethodDescriptors(caller, name,includeSuperType,includeInterfaces);
            for(MethodDescriptor m:ms){
                descs.put(m.getDeclarationKey(),m);
            }
        }
        MethodNode[] mds = clazz.getDeclaredMethodNodes();
        for(int i=0;i<mds.length;i++){
            if (!AccessUtil.isAccessible(mds[i].getModifier(), clazz, caller)){
                continue;
            }
            if (name!=null && !name.isEmpty() && !name.equals(mds[i].getName())) {
                continue;
            }
            MethodDescriptor md = new MethodDescriptor(
                    mds[i]
                    ,getParameterDescriptors(mds[i])
                    ,parseType(mds[i].getType())
                    ,parseTypes(mds[i].getExceptionTypes())
            );
            descs.put(md.getDeclarationKey(), md);
        }
        return descs.values().toArray(new MethodDescriptor[descs.size()]);
    }
    
    public MethodDescriptor[] getConstructorDescriptors(@Nullable ClassNode caller){
        return this.getMethodDescriptors(caller,"<init>",false,false);
    }
    
    @Nullable
    public FieldDescriptor getFieldDescriptor(ClassNode caller,String name){
        FieldDescriptor[] fds = getFieldDescriptors(caller);
        for(FieldDescriptor f:fds){
            if(name.equals(f.getName())) return f;
        }
        return null;
    }
    
    public FieldDescriptor[] getFieldDescriptors(ClassNode caller){
        FieldNode[] fields = clazz.getFields();
        List<FieldDescriptor> ret = new LinkedList();
        for(int i=0;i<fields.length;i++){
            FieldNode f = fields[i];
            if(AccessUtil.isAccessible(f.modifier, clazz, caller)){
              ret.add(new StandardFieldDescriptor(f,parseType(f.getType())));
            }
        }
        ObjectType superType = clazz.getSuperType();
        if(superType!=null){
            FieldDescriptor[] superFields = superType.getFieldDescriptors(caller);
            ret.addAll(Arrays.asList(superFields));
        }
        return ret.toArray(new FieldDescriptor[ret.size()]);
    }

    @Nullable
    public ObjectType getSuperType() {
        return clazz.getSuperType();
    }

    public NullableKind getNullable() {
        return nullable;
    }
    
    protected boolean equalAndNullAssignChecked(Type type){
        if(type.equals(this)) return true;
        if(type.equals(Types.NULL_TYPE)){
            return nullable== NullableKind.NULLABLE || nullable == NullableKind.UNKNOWN;
        }
        return false;
    }

    @Override
    public boolean isAssignableFrom(Type type) {
        if(equalAndNullAssignChecked(type)) return true;
        if(!(type instanceof ObjectType)) return false;        
        ObjectType other = (ObjectType) type;
        NullableKind otherNullable = other.getNullable();
        if(!nullable.isAssignableFrom(otherNullable)) return false;
        ObjectType superType = other.getSuperType();
        //the super type of interface is null,but actually it should be Object
        if(superType==null && Modifier.isInterface(other.getModifier())){
            superType = Types.getRootType();
        }
        if(superType!=null && isAssignableFrom(superType)) return true;
        for(ObjectType itf:other.getInterfaces()){
            if(isAssignableFrom(itf)) return true;
        }
        return false;
    }
    
    public ObjectType[] getInterfaces(){
        ObjectType[] itfs = clazz.getInterfaces();
        for(int i=0;i<itfs.length;i++){
            itfs[i] = (ObjectType) parseType(itfs[i]);
        }
        return itfs;
    }
    
    public int getModifier(){
        return clazz.modifier;
    }
    
}
