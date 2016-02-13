
package kalang.core;
import jast.ast.AstNode;
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
public abstract class Type {
    
    public abstract String getName();
    
    public abstract boolean isPrimitiveType();
    
    public abstract boolean isArray();
    
    public abstract Type getComponentType();
    
    public abstract boolean isCastableTo(Type targetType);
    
    public abstract ExprNode cast(Type targetType,ExprNode from);
    
    public abstract VarObject[] getFields();
    
    public abstract MethodNode[] getMethods();
    
    public VarObject getField(String name){
        //TODO low performance
        for(VarObject f:getFields()){
            if(f.name.equals(name)) return f;
        }
        return null;
    }

    @Override
    public String toString() {
        return getName();
    }
    
    

}
