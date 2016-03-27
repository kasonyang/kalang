
package kalang.ast;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import kalang.compiler.FieldNotFoundException;
import kalang.util.AstUtil;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class StaticFieldExpr extends FieldExpr{
    
    private ClassReference clazz;
    
    public static StaticFieldExpr create(ClassReference clazz,String fieldName) throws FieldNotFoundException{
        FieldNode  field = getField(clazz.getReferencedClassNode(), fieldName);
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
