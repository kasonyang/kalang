
package kalang.compiler.compile.semantic;

import kalang.compiler.core.MethodDescriptor;

import java.util.Collection;

/**
 *
 * @author Kason Yang 
 */
public class AmbiguousMethodException extends RuntimeException{

    public AmbiguousMethodException(Collection<? extends MethodDescriptor> methods){
        this(methods.toArray(new MethodDescriptor[0]));
    }
    
    public static String[] getMethodDescriptorStrings(MethodDescriptor... methods){
        String[] strs = new String[methods.length];
        for(int i=0;i<strs.length;i++){
            strs[i] = methods[i].toString();
        }
        return strs;
    }
    
    public AmbiguousMethodException(MethodDescriptor... methods){
        this("the method is ambiguous:\n" + String.join("\n", getMethodDescriptorStrings(methods)));
    }
    
    public AmbiguousMethodException(String message) {
        super(message);
    }

    public AmbiguousMethodException() {
    }

}
