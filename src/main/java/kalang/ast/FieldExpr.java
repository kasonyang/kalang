package kalang.ast;
import java.util.*;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import kalang.FieldNotFoundException;
import kalang.core.*;
import kalang.util.AstUtil;
public abstract class FieldExpr extends AssignableExpr{
    
    @Nonnull
    private FieldNode field;
    
    @Nonnull
    protected static  FieldNode getField(ClassNode clazz,String fieldName,@Nullable ClassNode caller) throws FieldNotFoundException{
        FieldNode field = AstUtil.getField(clazz,fieldName,caller);
        if(field==null){
            throw new FieldNotFoundException(fieldName);
        }
        return field;
    }
    
    public FieldExpr(@Nonnull FieldNode field){
        this.field = field;
    }

    @Override
    public Type getType() {
        return field.getType();
    }
    
    @Nonnull
    public FieldNode getField(){
        return field;
    }

}