
package kalang.compiler;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import kalang.ast.ClassNode;
/**
 *
 * @author Kason Yang 
 */
public interface CodeGenerator {
    
    void generate(ClassNode classNode);
    
}
