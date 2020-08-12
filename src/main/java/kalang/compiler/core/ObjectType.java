
package kalang.compiler.core;

import kalang.compiler.ast.ClassNode;
import kalang.compiler.ast.FieldNode;
import kalang.compiler.ast.MethodNode;
import kalang.compiler.ast.ParameterNode;
import kalang.compiler.core.impl.StandardFieldDescriptor;
import kalang.compiler.core.impl.StandardMethodDescriptor;
import kalang.compiler.core.impl.StandardParameterDescriptor;
import kalang.compiler.util.*;
import kalang.mixin.CollectionMixin;

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

    private MethodDescriptor[] allMethodDescriptors;

    private MethodDescriptor[] declaredMethodDescriptors;

    public ObjectType(ClassNode clazz,NullableKind nullable) {
        this.clazz = clazz;
        this.nullable = nullable;
    }

    public abstract boolean equalsIgnoreNullable(ObjectType other);

    @Override
    public String getName(boolean simple) {
        return (simple ? NameUtil.getSimpleClassName(clazz.getName()) : clazz.getName()) + getNullableSuffix();
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
            pds[j] = new StandardParameterDescriptor(p.getName(),ptypes[j], p.getModifier());
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

    public MethodDescriptor[] getMethodDescriptors(@Nullable ClassNode caller, @Nullable String name, boolean includeSuperType, boolean includeInterfaces) {
        MethodDescriptor[] allMds = getAllMethodDescriptors();
        List<MethodDescriptor> result = new ArrayList<>(allMds.length);
        ClassNode rootClassNode = Types.getRootType(NullableKind.UNKNOWN).getClassNode();
        for (MethodDescriptor m : allMds) {
            if (!AccessUtil.isAccessible(m.getModifier(), clazz, caller)) {
                continue;
            }
            if (name != null && !name.isEmpty() && !name.equals(m.getName())) {
                continue;
            }
            boolean isInterfaceMethod = Modifier.isInterface(m.getMethodNode().getClassNode().getModifier());
            boolean isDeclaredMethod = Objects.equals(m.getMethodNode().getClassNode(),clazz);
            if (!isDeclaredMethod && !includeInterfaces && isInterfaceMethod) {
                continue;
            }
            if (!isDeclaredMethod
                    && !includeSuperType
                    && !isInterfaceMethod
                    // method from Object should not be ignored
                    && !rootClassNode.equals(m.getMethodNode().getClassNode())
            ) {
                continue;
            }
            result.add(m);
        }
        return result.toArray(new MethodDescriptor[0]);
    }

    public MethodDescriptor[] getDeclaredMethodDescriptors() {
        if (!clazz.isStructureFinished) {
            return buildDeclaredMethodDescriptorsFromClass();
        }
        if (declaredMethodDescriptors == null) {
            declaredMethodDescriptors = buildDeclaredMethodDescriptorsFromClass();
        }
        return declaredMethodDescriptors;
    }

    public MethodDescriptor[] getAllMethodDescriptors() {
        if (!clazz.isStructureFinished) {
            return buildAllMethodDescriptors();
        }
        if (allMethodDescriptors ==  null) {
            allMethodDescriptors = buildAllMethodDescriptors();
        }
        return allMethodDescriptors;
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
        for (FieldNode f : fields) {
            if (AccessUtil.isAccessible(f.getModifier(), clazz, caller)) {
                ret.add(new StandardFieldDescriptor(f, parseType(f.getType())));
            }
        }
        ObjectType superType = clazz.getSuperType();
        if(superType!=null){
            FieldDescriptor[] superFields = superType.getFieldDescriptors(caller);
            ret.addAll(Arrays.asList(superFields));
        }
        return ret.toArray(new FieldDescriptor[0]);
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
            return nullable== NullableKind.NULLABLE || nullable == NullableKind.UNKNOWN || Types.getVoidClassType().equals(this);
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
        return clazz.getModifier();
    }

    protected String getNullableSuffix() {
        if (nullable == NullableKind.NULLABLE) {
            return "?";
        }
        return "";
    }

    protected MethodDescriptor[] buildDeclaredMethodDescriptorsFromClass() {
        MethodNode[] mds = clazz.getDeclaredMethodNodes();
        return CollectionMixin.map(mds, MethodDescriptor.class, m ->
            new StandardMethodDescriptor(
                    m
                    , getParameterDescriptors(m)
                    , parseType(m.getType())
                    , parseTypes(m.getExceptionTypes())
            )
        );
    }

    protected MethodDescriptor[] buildAllMethodDescriptors() {
        Map<String, MethodDescriptor> descMap = new HashMap<>();
        //process interfaces
        for (ObjectType itf: getInterfaces()) {
            collectNonPrivateMethods(itf, descMap);
        }
        //process super type
        ObjectType superType = getSuperType();
        if (superType != null) {
            collectNonPrivateMethods(superType, descMap);
        }

        //process declared methods
        for (MethodDescriptor m : getDeclaredMethodDescriptors()) {
            descMap.put(m.getDeclarationKey(), m);
        }

        //process methods from Object type for interface
        if (ModifierUtil.isInterface(getModifier())) {
            ClassType rootType = Types.getRootType(NullableKind.UNKNOWN);
            collectNonPrivateMethods(rootType, descMap);
        }
        return descMap.values().toArray(new MethodDescriptor[0]);
    }

    private void collectNonPrivateMethods(ObjectType type, Map<String, MethodDescriptor> descMap) {
        for (MethodDescriptor m : type.getAllMethodDescriptors()) {
            if (Modifier.isPrivate(m.getModifier())) {
                continue;
            }
            if (AstUtil.isConstructor(m.getMethodNode())) {
                continue;
            }
            descMap.put(m.getDeclarationKey(), m);
        }
    }

    
}
