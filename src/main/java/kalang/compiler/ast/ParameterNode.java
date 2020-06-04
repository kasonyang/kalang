
package kalang.compiler.ast;
import kalang.compiler.core.Type;
/**
 *
 * @author Kason Yang 
 */
public class ParameterNode extends VarObject {
    
    private final MethodNode method;

    protected ParameterNode(MethodNode method,Type type,String name) {
        this(method,0,type,name);
    }

    protected ParameterNode(MethodNode method,int modifier,Type type ,String name) {
        super(modifier,type,name);
        this.method = method;
    }

    public MethodNode getMethod() {
        return method;
    }

}
