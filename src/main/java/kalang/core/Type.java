
package kalang.core;
import kalang.ast.AstNode;
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
public abstract class Type {
    
    protected Type superType;

    public Type(Type superType) {
        this.superType = superType;
    }
    
    public abstract String getName();
    
    public abstract boolean isPrimitiveType();
    
    public abstract boolean isArray();
    
    public abstract Type getComponentType();
    
    public boolean isSubTypeOf(Type targetType){
        Type t = this;
        while(t!=null){
            if(t.equals(targetType)) return true;
            t = t.getSuperType();
        }
        return false;
    }
    
    public boolean isAssignedFrom(Type type){
        if(equals(type)) return true;
        return type.isSubTypeOf(this);
    }
    
    //public abstract boolean isCastableTo(Type targetType);
    
    //public abstract ExprNode cast(Type targetType,ExprNode from);
    
    public abstract FieldNode[] getFields();
    
    public abstract MethodNode[] getMethods();
    
    public FieldNode getField(String name){
        for(FieldNode f:getFields()){
            if(f.name.equals(name)) return f;
        }
        return null;
    }

    @Override
    public String toString() {
        return getName();
    }

    public Type getSuperType() {
        return superType;
    }

}
