
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
    
    public static FieldNode create(ClassNode clazz){
        FieldNode fn = new FieldNode(clazz);
        return fn;
    }

}
