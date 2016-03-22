
package kalang.ast;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import kalang.compiler.FieldNotFoundException;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class StaticFieldExpr extends FieldExpr{
    
    private ClassReference clazz;
    
    public static StaticFieldExpr create(ClassReference clazz,String fieldName) throws FieldNotFoundException{
        FieldNode  field = getField(clazz.getReferencedClassNode(), fieldName);
        return new StaticFieldExpr(clazz, field);
    }

    public StaticFieldExpr(ClassReference clazz, FieldNode field) {
        super(field);
        this.clazz = clazz;
    }

    public ClassReference getClassReference() {
        return clazz;
    }

}
