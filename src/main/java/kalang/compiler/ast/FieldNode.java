
package kalang.compiler.ast;
import kalang.compiler.core.FieldDescriptor;
import kalang.compiler.core.Type;
/**
 *
 * @author Kason Yang
 */
public class FieldNode extends VarObject implements FieldDescriptor{
    
    private final ClassNode classNode;

    protected FieldNode(ClassNode classNode,Type type,String name,int modifier) {
        super(modifier,type,name);
        this.classNode = classNode;
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
