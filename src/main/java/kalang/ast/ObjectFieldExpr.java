
package kalang.ast;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import kalang.FieldNotFoundException;
import kalang.core.ObjectType;
import kalang.core.FieldDescriptor;
import kalang.core.Type;
import kalang.util.AstUtil;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class ObjectFieldExpr extends FieldExpr{
    
    protected ExprNode target;

    public ObjectFieldExpr(ExprNode target, FieldDescriptor field) {
        super(field);
        //TODO check non-static
        this.target = target;
    }
    
    /**
     * @return the target,null if the field is static
     */
    @Nullable
    public ExprNode getTarget() {
        return target;
    }
    
    @Nonnull
    public static FieldExpr create(@Nonnull ExprNode target,String fieldName,@Nullable ClassNode caller) throws FieldNotFoundException{
        Type type = target.getType();
        if(!(type instanceof ObjectType)){
            throw new UnsupportedOperationException("unsupported type:" + type);
        }
        ObjectType classType = (ObjectType) type;
        FieldDescriptor field = getField(classType, fieldName,caller);
        if(AstUtil.isStatic(field.getModifier())){
            throw new FieldNotFoundException(fieldName + " is static");
        }
        return new ObjectFieldExpr(target,field);
    }

    @Override
    public List<AstNode> getChildren() {
        return Collections.singletonList(target);
    }
    
    

}
