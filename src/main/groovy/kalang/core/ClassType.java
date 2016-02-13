
package kalang.core;
import jast.ast.CastExpr;
import jast.ast.ClassNode;
import jast.ast.ExprNode;
import jast.ast.MethodNode;
import jast.ast.VarObject;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class ClassType extends Type{
    
    private ClassNode clazz;

    public ClassType(ClassNode clazz) {
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

    @Override
    public boolean isCastableTo(Type targetType) {
        if(Types.isNumber(this)){
            PrimitiveType pt = Types.getPrimitiveType(this);
            return pt.isCastableTo(targetType);
        }else{
            return isSubclassTypeOf(targetType);
        }
    }

    @Override
    public ExprNode cast(Type targetType, ExprNode from) {
        return new CastExpr(targetType, from);
    }

    public boolean isSubclassTypeOf(Type targetType){
        if(targetType instanceof ClassType){
            ClassType tt = (ClassType) targetType;
            ClassNode targetClass = tt.getClassNode();
            ClassNode mc = clazz;
            while(mc!=null){
                if(mc==targetClass) return true;
                mc = mc.parent;
            }
            return false;
        }
        return false;
    }

    public ClassNode getClassNode() {
        return clazz;
    }

    @Override
    public VarObject[] getFields() {
        return clazz.fields.toArray(new VarObject[0]);
    }

    @Override
    public MethodNode[] getMethods() {
        return clazz.methods.toArray(new MethodNode[0]);
    }
    
}
