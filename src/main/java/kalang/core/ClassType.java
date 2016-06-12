
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

    public ClassType(ClassNode clazz) {
        super(clazz.parent==null?null:Types.getClassType(clazz.parent));
        this.clazz = clazz;
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
    public FieldNode[] getFields() {
        return clazz.fields.toArray(new FieldNode[0]);
    }

    @Override
    public MethodNode[] getMethods() {
        return clazz.getMethods();
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
    
    public MethodDescriptor[] getMethodDescriptors(@Nullable ClassNode caller,boolean recursive){
        MethodNode[] mds = AstUtil.listAccessibleMethods(clazz, caller, recursive);
        MethodDescriptor[] descs = new MethodDescriptor[mds.length];
        for(int i=0;i<descs.length;i++){
            MethodNode mn = mds[i];
            List<ParameterNode> pms = mn.parameters;
            Type[] ptypes = TypeUtil.getMethodActualParameterTypes(this, mn);
            ParameterDescriptor[] pds = new ParameterDescriptor[ptypes.length];
            for(int j=0;j<pds.length;j++){
                pds[j] = new ParameterDescriptor(pms.get(j).name,ptypes[j]);
            }
            descs[i] = new MethodDescriptor(mn, pds, TypeUtil.getMethodActualReturnType(this, mn));    
        }
        return descs;
    }
    
}
