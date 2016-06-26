
package kalang.core;
import kalang.ast.ClassNode;
import kalang.ast.MethodNode;
import java.util.*;
import javax.annotation.Nullable;
import kalang.ast.FieldNode;
import kalang.ast.ParameterNode;
import kalang.util.MethodUtil;
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
        List<ParameterNode> pms = method.parameters;
        Type[] ptypes = parseTypes(MethodUtil.getParameterTypes(method));
        ParameterDescriptor[] pds = new ParameterDescriptor[ptypes.length];
        for(int j=0;j<pds.length;j++){
            ParameterNode p = pms.get(j);
            pds[j] = new ParameterDescriptor(p.name,ptypes[j],p.modifier);
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
        Map<String,MethodDescriptor> descs = new HashMap();
        List<ObjectType> superList = new LinkedList();
        if(includeSuperType){
            ObjectType superType = getSuperType();
            if(superType!=null) superList.add(superType);
        }
        if(includeInterfaces){
            ObjectType[] itfs = getInterfaces();
            superList.addAll(Arrays.asList(itfs));
        }
        for(ObjectType st:superList){
            MethodDescriptor[] ms = st.getMethodDescriptors(caller, includeSuperType,includeInterfaces);
            for(MethodDescriptor m:ms){
                descs.put(m.getDeclarationKey(),m);
            }
        }
        MethodNode[] mds = clazz.getDeclaredMethodNodes();
        for(int i=0;i<mds.length;i++){
            if("<init>".equals(mds[i].name)) continue;
            MethodDescriptor md = new MethodDescriptor(
                    mds[i]
                    ,getParameterDescriptors(mds[i])
                    ,parseType(mds[i].type)
                    ,parseTypes(mds[i].exceptionTypes.toArray(new Type[0]))
            );
            descs.put(md.getDeclarationKey(), md);
        }
        return descs.values().toArray(new MethodDescriptor[descs.size()]);
    }
    
    public ConstructorDescriptor[] getConstructorDescriptors(@Nullable ClassNode caller){
        Map<String,ConstructorDescriptor> descs = new HashMap();
        MethodNode[] mds = clazz.getDeclaredMethodNodes();
        for(int i=0;i<mds.length;i++){
            if(!"<init>".equals(mds[i].name)) continue;
            ConstructorDescriptor md = new ConstructorDescriptor(
                    mds[i]
                    ,getParameterDescriptors(mds[i])
                    ,parseTypes(mds[i].exceptionTypes.toArray(new Type[0]))
            );
            descs.put(md.getDeclarationKey(), md);
        }
        return descs.values().toArray(new ConstructorDescriptor[descs.size()]);
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
        List<FieldNode> fields = clazz.fields;
        List<FieldDescriptor>ret = new ArrayList(fields.size());
        for(FieldNode f:fields){
            ret.add(new StandardFieldDescriptor(f,parseType(f.type)));
        }
        return ret.toArray(new FieldDescriptor[ret.size()]);
    }

    @Nullable
    public ObjectType getSuperType() {
        return clazz.superType;
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
    public boolean isAssignedFrom(Type type) {
        if(equalAndNullAssignChecked(type)) return true;
        if(!(type instanceof ObjectType)) return false;        
        ObjectType other = (ObjectType) type;
        NullableKind otherNullable = other.getNullable();
        if(!nullable.isAssignedFrom(otherNullable)) return false;
        if(clazz.equals(other.clazz)) return true;
        ObjectType superType = other.getSuperType();
        if(superType!=null){
            return isAssignedFrom(superType);
        }
        return false;
    }
    
    public ObjectType[] getInterfaces(){
        ObjectType[] itfs = clazz.interfaces.toArray(new ObjectType[clazz.interfaces.size()]);
        for(int i=0;i<itfs.length;i++){
            itfs[i] = (ObjectType) parseType(itfs[i]);
        }
        return itfs;
    }
    
    public int getModifier(){
        return clazz.modifier;
    }
    
}
