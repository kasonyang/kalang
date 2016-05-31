
package kalang.ast;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import kalang.FieldNotFoundException;
import kalang.core.ClassType;
import kalang.core.Type;
import kalang.util.AstUtil;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class ObjectFieldExpr extends FieldExpr{
    
    protected ExprNode target;

    public ObjectFieldExpr(ExprNode target, FieldNode field) {
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
        if(!(type instanceof ClassType)){
            throw new UnsupportedOperationException("unsupported type:" + type);
        }
        ClassType classType = (ClassType) type;
        ClassNode clazz = classType.getClassNode();
        FieldNode field = getField(clazz, fieldName,caller);
        if(AstUtil.isStatic(field.modifier)){
            throw new FieldNotFoundException(fieldName + " is static");
        }
        return new ObjectFieldExpr(target,field);
    }

    @Override
    public List<AstNode> getChildren() {
        return Collections.singletonList(target);
    }
    
    

}
