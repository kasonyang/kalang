
package kalang.compiler.core;

import kalang.compiler.ast.MethodNode;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kason Yang
 */
public class MethodDescriptor extends ExecutableDescriptor {
    
    

    public MethodDescriptor(MethodNode method, ParameterDescriptor[] parameterDescriptors, Type returnType,Type[] exceptionTypes) {
        super(method, parameterDescriptors,returnType,exceptionTypes);
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
