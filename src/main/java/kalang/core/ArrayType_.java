
package kalang.core;
import kalang.ast.ExprNode;
import kalang.ast.MethodNode;
import kalang.ast.VarObject;
import java.io.*;
import java.lang.reflect.Modifier;
import java.nio.*;
import java.net.*;
import java.util.*;
import kalang.ast.FieldNode;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class ArrayType_ extends Type{

    private Type componentType;
    private FieldNode[] fields;

    public ArrayType_(Type componentType) {
        super(Types.ROOT_TYPE);
        this.componentType = componentType;
        FieldNode field = FieldNode.create(null);
        field.modifier = Modifier.PUBLIC;
        field.type = Types.INT_TYPE;
        field.name = "length";
        //TODO here may be bug
        fields = new FieldNode[]{
            field
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

//    @Override
//    public ExprNode cast(Type targetType, ExprNode from) {
//        return from;
//    }

    @Override
    public FieldNode[] getFields() {
        return fields;
    }

    @Override
    public MethodNode[] getMethods() {
        return null;
    }

//    @Override
//    public boolean isSubTypeOf(Type targetType) {
//        if(targetType instanceof ArrayType){
//            return componentType.isSubTypeOf(targetType);
//        }
//        return false;
//    }

    @Override
    public boolean isAssignedFrom(Type type) {
        if(super.isAssignedFrom(type)) return true;
        if(type instanceof ArrayType_){
            return componentType.isAssignedFrom(((ArrayType_)type).getComponentType());
        }
        return false;
    }

    @Override
    public boolean isSubTypeOf(Type targetType) {
        if(targetType.equals(superType)) return true;
        if(targetType instanceof ArrayType_){
            return componentType.isSubTypeOf(((ArrayType_)targetType).componentType);
        }
        return false;
    }


}
