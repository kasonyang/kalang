
package kalang.ast;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import kalang.core.FieldDescriptor;
import kalang.core.Type;
/**
 *
 * @author Kason Yang
 */
public class FieldNode extends VarObject implements FieldDescriptor{
    
    private final ClassNode classNode;

    protected FieldNode(ClassNode classNode,Type type,String name,int modifier) {
        this.classNode = classNode;
        this.type = type;
        this.name = name;
        this.modifier = modifier;
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

    public ClassNode getClassNode() {
        return classNode;
    }

}
