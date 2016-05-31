
package kalang.ast;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import javax.annotation.Nullable;
import kalang.FieldNotFoundException;
import kalang.util.AstUtil;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class StaticFieldExpr extends FieldExpr{
    
    private ClassReference clazz;
    
    public static StaticFieldExpr create(ClassReference clazz,String fieldName,@Nullable ClassNode caller) throws FieldNotFoundException{
        FieldNode  field = getField(clazz.getReferencedClassNode(), fieldName,caller);
        if(!AstUtil.isStatic(field.modifier)){
            throw new FieldNotFoundException(fieldName + " is not static");
        }
        return new StaticFieldExpr(clazz, field);
    }

    public StaticFieldExpr(ClassReference clazz, FieldNode field) {
        super(field);
        if(!AstUtil.isStatic(field.modifier)){
            throw new IllegalArgumentException("static field required");
        }
        this.clazz = clazz;
    }

    public ClassReference getClassReference() {
        return clazz;
    }

}
