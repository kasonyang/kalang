
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

    public UnknownFieldExpr(ExprNode target, String fieldName) {
        this.target = target;
        this.fieldName = fieldName;
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

}
