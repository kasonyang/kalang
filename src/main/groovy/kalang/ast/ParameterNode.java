
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
    
    public static ParameterNode create(MethodNode method,VarObject vo){
        ParameterNode pn = new ParameterNode(method);
        pn.initExpr = vo.initExpr;
        pn.modifier = vo.modifier;
        pn.name = vo.name;
        pn.offset = vo.offset;
        pn.type = vo.type;
        return pn;
    }

}
