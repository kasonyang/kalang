
package kalang.compiler.ast;

import kalang.compiler.core.Type;
import kalang.compiler.core.Types;

import java.util.Collections;
import java.util.List;
/**
 *
 * @author Kason Yang 
 */
public class UnknownFieldExpr extends AssignableExpr{

    private AstNode target;
    
    private String fieldName;
    
    private ClassNode specialClass;

    public UnknownFieldExpr(AstNode target,ClassNode specialClass, String fieldName) {
        this.target = target;
        this.fieldName = fieldName;
        this.specialClass = specialClass;
    }

    public AstNode getTarget() {
        return target;
    }

    public String getFieldName() {
        return fieldName;
    }
    
    @Override
    public Type getType() {
        return Types.getRootType();
    }

    @Override
    public List<AstNode> getChildren() {
        return Collections.singletonList(target);
    }

    public ClassNode getSpecialClass() {
        return specialClass;
    }
    

}
