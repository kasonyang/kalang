
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
    
    
    public abstract String getName();
    
    public abstract boolean isPrimitiveType();
    
    public abstract boolean isArray();
    
    public String getDeclarationKey(){
        return getName();
    }
    
    public abstract Type getComponentType();
    
    public boolean isSubTypeOf(Type targetType){
        return false;
    }
    
    public boolean isAssignedFrom(Type type){
        if(equals(type)) return true;
        return type.isSubTypeOf(this);
    }
     
    @Override
    public String toString() {
        return getName();
    }

}
