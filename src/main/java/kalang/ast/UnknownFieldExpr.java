
package kalang.ast;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import kalang.core.Type;
import kalang.core.Types;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class UnknownFieldExpr extends ExprNode{

    private ExprNode target;
    
    private String fieldName;
    
    private ClassNode specialClass;

    public UnknownFieldExpr(ExprNode target,ClassNode specialClass, String fieldName) {
        this.target = target;
        this.fieldName = fieldName;
        this.specialClass = specialClass;
    }

    public ExprNode getTarget() {
        return target;
    }

    public String getFieldName() {
        return fieldName;
    }
    
    @Override
    public Type getType() {
        return Types.ROOT_TYPE;
    }

    @Override
    public List<AstNode> getChildren() {
        return Collections.singletonList(target);
    }

    public ClassNode getSpecialClass() {
        return specialClass;
    }
    

}
