
package kalang.ast;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import kalang.core.Type;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class ParameterNode extends VarObject{
    
    public final MethodNode method;

    protected ParameterNode(MethodNode method,Type type,String name) {
        this.method = method;
        this.type = type;
        this.name = name;
    }

}
