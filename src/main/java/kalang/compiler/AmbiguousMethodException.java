
package kalang.compiler;

import kalang.compiler.core.ExecutableDescriptor;

import java.util.Collection;

/**
 *
 * @author Kason Yang 
 */
public class AmbiguousMethodException extends Exception{

    public AmbiguousMethodException(Collection<? extends ExecutableDescriptor> methods){
        this(methods.toArray(new ExecutableDescriptor[methods.size()]));
    }
    
    public static String[] getExecutableDescriptorStrings(ExecutableDescriptor... methods){
        String[] strs = new String[methods.length];
        for(int i=0;i<strs.length;i++){
            strs[i] = methods[i].toString();
        }
        return strs;
    }
    
    public AmbiguousMethodException(ExecutableDescriptor... methods){
        this("the method is ambiguous:\n" + String.join("\n", getExecutableDescriptorStrings(methods)));
    }
    
    public AmbiguousMethodException(String message) {
        super(message);
    }

    public AmbiguousMethodException() {
    }

}
