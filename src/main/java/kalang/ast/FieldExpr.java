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
    private FieldDescriptor field;
    
    @Nonnull
    protected static  FieldDescriptor getField(ObjectType type,String fieldName,@Nullable ClassNode caller) throws FieldNotFoundException{
        FieldDescriptor field = type.getFieldDescriptor(caller,fieldName);
        if(field==null){
            throw new FieldNotFoundException(fieldName);
        }
        return field;
    }
    
    public FieldExpr(@Nonnull FieldDescriptor field){
        this.field = field;
    }

    @Override
    public Type getType() {
        return field.getType();
    }
    
    @Nonnull
    public FieldDescriptor getField(){
        return field;
    }

}