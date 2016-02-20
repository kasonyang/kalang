
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
import kalang.ast.FieldNode;
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
        return clazz.getMethodNodes();
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
    
}
