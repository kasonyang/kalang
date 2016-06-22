
package kalang.core;
import kalang.ast.CastExpr;
import kalang.ast.ClassNode;
import kalang.ast.ExprNode;
import kalang.ast.MethodNode;
import kalang.ast.VarObject;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import javax.annotation.Nullable;
import kalang.ast.FieldNode;
import kalang.ast.ParameterNode;
import kalang.util.AstUtil;
import kalang.util.MethodUtil;
import kalang.util.TypeUtil;
/**
 *
 * @author Kason Yang
 */
public class ClassType extends Type{
    
    private ClassNode clazz;
    
    protected NullableKind nullable;
    
    @Nullable
    protected ClassType superType;

    public ClassType(ClassNode clazz,@Nullable ClassType superType,NullableKind nullable) {
        this.clazz = clazz;
        this.superType = superType;
        this.nullable = nullable;
    }

    @Override
    public String getName() {
        return clazz.name;
    }

    public ClassNode getClassNode() {
        return clazz;
    }
  
    @Override
    public boolean isSubTypeOf(Type targetType) {
        if(targetType instanceof ClassType){
            return clazz.isSubclassOf(
                    ((ClassType)targetType).clazz
                    );
        }
        return false;
    }
    
    private ParameterDescriptor[] getParameterDescriptors(MethodNode method){
        List<ParameterNode> pms = method.parameters;
        Type[] ptypes = parseTypes(MethodUtil.getParameterTypes(method));
        ParameterDescriptor[] pds = new ParameterDescriptor[ptypes.length];
        for(int j=0;j<pds.length;j++){
            pds[j] = new ParameterDescriptor(pms.get(j).name,ptypes[j]);
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
    
    //TODO cache 
    public MethodDescriptor[] getMethodDescriptors(@Nullable ClassNode caller,boolean recursive){
        Map<String,MethodDescriptor> descs = new HashMap();
        if(recursive && superType!=null){
            MethodDescriptor[] ms = superType.getMethodDescriptors(caller, recursive);
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
    
    //TODO cache 
    //TODO cache 
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
    
    //TODO cache
    public FieldDescriptor[] getFieldDescriptors(ClassNode caller){
        List<FieldNode> fields = clazz.fields;
        List<FieldDescriptor>ret = new ArrayList(fields.size());
        for(FieldNode f:fields){
            ret.add(new StandardFieldDescriptor(f,parseType(f.type)));
        }
        return ret.toArray(new FieldDescriptor[ret.size()]);
    }

    @Nullable
    public ClassType getSuperType() {
        return superType;
    }

    public NullableKind getNullable() {
        return nullable;
    }

    @Override
    public boolean isAssignedFrom(Type type) {
        if(type.equals(this)) return true;
        if(!super.isAssignedFrom(type)) return false;
        if(!(type instanceof ClassType)) return false;        
        ClassType other = (ClassType) type;
        NullableKind otherNullable = other.getNullable();
        if(!nullable.isAssignedFrom(otherNullable)) return false;
        return other.getClassNode().isSubclassOf(clazz);
    }
    
    
    
}
