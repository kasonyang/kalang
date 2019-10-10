package kalang.compiler.ast;

import kalang.compiler.FieldNotFoundException;
import kalang.compiler.core.FieldDescriptor;
import kalang.compiler.core.ObjectType;
import kalang.compiler.core.Type;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;

public abstract class FieldExpr extends AssignableExpr{
    
    @Nonnull
    private FieldDescriptor field;
    
    @Nonnull
    protected static  FieldDescriptor getField(ObjectType type, String fieldName, @Nullable ClassNode caller) throws FieldNotFoundException{
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

    @Override
    public String toString() {
        return Objects.toString(field);
    }
}