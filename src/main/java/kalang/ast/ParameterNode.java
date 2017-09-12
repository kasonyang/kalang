
package kalang.ast;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import kalang.core.Type;
/**
 *
 * @author Kason Yang 
 */
public class ParameterNode extends VarObject{
    
    private final MethodNode method;

    protected ParameterNode(MethodNode method,Type type,String name) {
        //TODO add modifier parameter
        super(0,type,name);
        this.method = method;
    }

    public MethodNode getMethod() {
        return method;
    }

}
