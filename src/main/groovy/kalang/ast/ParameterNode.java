
package kalang.ast;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class ParameterNode extends VarObject{
    
    public final MethodNode method;

    private ParameterNode(MethodNode method) {
        this.method = method;
    }
    
    public static ParameterNode create(MethodNode method){
        ParameterNode pn = new ParameterNode(method);
        return pn;
    }

}
