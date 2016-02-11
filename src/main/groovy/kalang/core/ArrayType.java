
package kalang.core;
import jast.ast.ExprNode;
import jast.ast.MethodNode;
import jast.ast.VarObject;
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

    @Override
    public boolean castable(Type targetType) {
        if(targetType instanceof ArrayType){
            return componentType.castable(((ArrayType)targetType).getComponentType());
        }
        return false;
    }

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


}