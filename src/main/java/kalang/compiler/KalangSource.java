
package kalang.compiler;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class KalangSource {
    
    private String className;
    
    private String text;

    public KalangSource(String className, String text) {
        this.className = className;
        this.text = text;
    }

    public String getClassName() {
        return className;
    }

    public String getText() {
        return text;
    }

}
