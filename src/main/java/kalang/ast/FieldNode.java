
package kalang.ast;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import kalang.core.FieldDescriptor;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class FieldNode extends VarObject implements FieldDescriptor{
    
    public final ClassNode classNode;

    private FieldNode(ClassNode classNode) {
        this.classNode = classNode;
    }
    
    public static FieldNode create(ClassNode clazz){
        FieldNode fn = new FieldNode(clazz);
        return fn;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getModifier() {
        return modifier;
    }

    @Override
    public FieldNode getFieldNode() {
        return this;
    }

}
