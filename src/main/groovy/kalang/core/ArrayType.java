
package kalang.core;
import kalang.ast.ExprNode;
import kalang.ast.MethodNode;
import kalang.ast.VarObject;
import java.io.*;
import java.lang.reflect.Modifier;
import java.nio.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class ArrayType extends Type{

    private Type componentType;
    private VarObject[] fields;

    public ArrayType(Type componentType) {
        super(Types.ROOT_TYPE);
        this.componentType = componentType;
        fields = new VarObject[]{
            new VarObject(Modifier.PUBLIC, Types.INT_TYPE, "length", null)
        };
    }
    
    @Override
    public String getName() {
        return componentType.getName() + "[]";
    }

    @Override
    public boolean isPrimitiveType() {
        return componentType.isPrimitiveType();
    }

    @Override
    public boolean isArray() {
        return true;
    }

    @Override
    public Type getComponentType() {
        return componentType;
    }

//    @Override
//    public boolean isCastableTo(Type targetType) {
//        if(targetType instanceof ArrayType){
//            return componentType.isCastableTo(((ArrayType)targetType).getComponentType());
//        }
//        return false;
//    }

    @Override
    public ExprNode cast(Type targetType, ExprNode from) {
        return from;
    }

    @Override
    public VarObject[] getFields() {
        return fields;
    }

    @Override
    public MethodNode[] getMethods() {
        return null;
    }

//    @Override
//    public boolean isSubclassTypeOf(Type targetType) {
//        if(targetType instanceof ArrayType){
//            return componentType.isSubclassTypeOf(targetType);
//        }
//        return false;
//    }

    @Override
    public boolean isAssignedFrom(Type type) {
        if(super.isAssignedFrom(type)) return true;
        if(type instanceof ArrayType){
            return componentType.isAssignedFrom(((ArrayType)type).getComponentType());
        }
        return false;
    }


}
