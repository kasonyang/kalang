
package kalang;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import kalang.core.ObjectType;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class MethodNotFoundException extends Exception{

    public MethodNotFoundException(String message) {
        super(message);
    }

    public MethodNotFoundException(ObjectType type,String methodName) {
        super("method not found:" + type + "." + methodName);
    }
    
}
