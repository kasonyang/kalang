
package kalang.ast;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class FieldNode extends VarObject{
    
    public final ClassNode classNode;

    private FieldNode(ClassNode classNode) {
        this.classNode = classNode;
    }
    
    public static FieldNode create(ClassNode clazz,VarObject vo){
        FieldNode fn = new FieldNode(clazz);
        fn.initExpr = vo.initExpr;
        fn.modifier = vo.modifier;
        fn.name = vo.name;
        fn.offset = vo.offset;
        fn.type = vo.type;
        return fn;
    }

}
