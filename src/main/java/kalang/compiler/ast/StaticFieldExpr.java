
package kalang.compiler.ast;

import kalang.compiler.compile.semantic.FieldNotFoundException;
import kalang.compiler.core.FieldDescriptor;
import kalang.compiler.core.Types;
import kalang.compiler.util.AstUtil;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Kason Yang 
 */
public class StaticFieldExpr extends FieldExpr{
    
    private ClassReference clazz;
    
    public static StaticFieldExpr create(ClassReference clazz,String fieldName,@Nullable ClassNode caller) throws FieldNotFoundException{
        FieldDescriptor  field = getField(Types.getClassType(clazz.getReferencedClassNode()),fieldName,caller);
        if(!AstUtil.isStatic(field.getModifier())){
            throw new FieldNotFoundException(fieldName + " is not static");
        }
        return new StaticFieldExpr(clazz, field);
    }

    public StaticFieldExpr(ClassReference clazz, FieldDescriptor field) {
        super(field);
        if(!AstUtil.isStatic(field.getModifier())){
            throw new IllegalArgumentException("static field required");
        }
        this.clazz = clazz;
    }

    public ClassReference getClassReference() {
        return clazz;
    }

    @Override
    public List<AstNode> getChildren() {
        return Collections.emptyList();
    }

    @Override
    public void updateChildren(ChildUpdater childUpdater) {
        
    }
}
