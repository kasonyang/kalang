package kalang.ast;
import java.util.*;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import kalang.compiler.FieldNotFoundException;
import kalang.core.*;
import kalang.util.AstUtil;
public class FieldExpr extends AssignableExpr{
    
    protected ExprNode target;
    
    @Nonnull
    private static FieldExpr create(@Nullable ExprNode target,@Nonnull ClassNode specialClass,String fieldName) throws FieldNotFoundException{
        FieldNode field = AstUtil.getField(specialClass,fieldName);
        if(field==null){
            throw new FieldNotFoundException(fieldName);
        }
        return new FieldExpr(target,field);
    }
    
    @Nonnull
    public static FieldExpr createStaticFieldExpr(@Nonnull ClassNode clazz,String fieldName) throws FieldNotFoundException{
        return create(null, clazz,fieldName);
    }
    
    @Nonnull
    public static FieldExpr create(@Nonnull ExprNode target,String fieldName) throws FieldNotFoundException{
        Type type = target.getType();
        if(!(type instanceof ClassType)){
            throw new UnsupportedOperationException("unsupported type:" + type);
        }
        ClassType classType = (ClassType) type;
        ClassNode clazz = classType.getClassNode();
        return create(target, clazz,fieldName);
    }
    
    @Nonnull
    private FieldNode field;
    
    public FieldExpr(@Nullable ExprNode target,@Nonnull FieldNode field){
        this.target = target;
        this.field = field;
    }
    
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        addChild(ls, getTarget());
        return ls;
    }

    @Override
    public Type getType() {
        return field.getType();
    }
    
    @Nonnull
    public FieldNode getField(){
        return field;
    }

    /**
     * @return the target,null if the field is static
     */
    @Nullable
    public ExprNode getTarget() {
        return target;
    }
    
}