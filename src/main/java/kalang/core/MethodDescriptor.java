
package kalang.core;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import kalang.ast.MethodNode;
import kalang.ast.ParameterNode;
/**
 *
 * @author Kason Yang
 */
public class MethodDescriptor extends ExecutableDescriptor {
    
    private final Type returnType;

    public MethodDescriptor(MethodNode method, ParameterDescriptor[] parameterDescriptors, Type returnType) {
        super(method, parameterDescriptors);
        this.returnType = returnType;
    }

    public Type getReturnType() {
        return returnType;
    }

    @Override
    public String toString() {
        List<String> params = new ArrayList();
        for(ParameterDescriptor p:getParameterDescriptors()){
            params.add(String.format("%s %s", p.getType(),p.getName()));
        }
        return String.format("%s %s %s(%s)", Modifier.toString(modifier),returnType.toString(),name,String.join(",", params));
    }
    
    
    
}
