
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
import kalang.compiler.AstLoader;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class ArrayType extends ClassType{

    private Type componentType;

    public ArrayType(Type componentType) {
        //TODO should not hard code
        super(AstLoader.BASE_AST_LOADER.getAst("java.lang.Object"));
        this.componentType = componentType;
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
        return new FieldNode[0];
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
        if(type instanceof ArrayType){
            return componentType.isAssignedFrom(((ArrayType)type).getComponentType());
        }
        return false;
    }

    @Override
    public boolean isSubTypeOf(Type targetType) {
        if(targetType.equals(superType)) return true;
        if(targetType instanceof ArrayType){
            return componentType.isSubTypeOf(((ArrayType)targetType).componentType);
        }
        return false;
    }


}
