
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
import kalang.util.TypeUtil;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class ClassType extends Type{
    
    private ClassNode clazz;
    protected ClassType superType;
    
    

    public ClassType(ClassNode clazz,ClassType superType) {
        this.clazz = clazz;
        this.superType = superType;
    }

    @Override
    public String getName() {
        return clazz.name;
    }

    @Override
    public boolean isPrimitiveType() {
        return false;
    }

    @Override
    public boolean isArray() {
        return false;
    }

    @Override
    public Type getComponentType() {
        return null;
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
        Type[] ptypes = TypeUtil.getMethodActualParameterTypes(this, method);
        ParameterDescriptor[] pds = new ParameterDescriptor[ptypes.length];
        for(int j=0;j<pds.length;j++){
            pds[j] = new ParameterDescriptor(pms.get(j).name,ptypes[j]);
        }
        return pds;
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
            MethodDescriptor md = new MethodDescriptor(mds[i],getParameterDescriptors(mds[i]), TypeUtil.getMethodActualReturnType(this,mds[i]),mds[i].exceptionTypes.toArray(new Type[0]));
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
            ConstructorDescriptor md = new ConstructorDescriptor(mds[i],getParameterDescriptors(mds[i]),mds[i].exceptionTypes.toArray(new Type[0]));
            descs.put(md.getDeclarationKey(), md);
        }
        return descs.values().toArray(new ConstructorDescriptor[descs.size()]);
    }
    
    //TODO cache
    public FieldDescriptor[] getFieldDescriptors(){
        List<FieldNode> fields = clazz.fields;
        FieldDescriptor[] ret = new FieldDescriptor[fields.size()];
        for(int i=0;i<ret.length;i++){
            FieldNode f = fields.get(i);
            ret[i] = new FieldDescriptor(f.name,f.type, f.modifier);
        }
        return ret;
    }

    public ClassType getSuperType() {
        return superType;
    }
    
}
