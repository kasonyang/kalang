package kalang.ast;
import java.util.*;
import javax.annotation.Nullable;
import kalang.core.*;
import kalang.util.AstUtil;
public class FieldExpr extends AssignableExpr{
    
    protected ExprNode target;
    
    private static FieldExpr create(ExprNode target,ClassNode specialClass,String fieldName){
        FieldNode field = AstUtil.getField(specialClass,fieldName);
        return new FieldExpr(target,field);
    }
    
    //TODO shold throw field not found
    public static FieldExpr createStaticFieldExpr(ClassNode clazz,String fieldName){
        return create(null, clazz,fieldName);
    }
    
    public static FieldExpr create(ExprNode target,String fieldName){
        Type type = target.getType();
        if(!(type instanceof ClassType)){
            throw new UnsupportedOperationException("unsupported type:" + type);
        }
        ClassType classType = (ClassType) type;
        ClassNode clazz = classType.getClassNode();
        return create(target, clazz,fieldName);
    }
    
    private FieldNode field;
    
    public FieldExpr(ExprNode target,FieldNode field){
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