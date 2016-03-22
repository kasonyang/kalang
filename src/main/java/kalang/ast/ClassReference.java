
package kalang.ast;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import kalang.core.Type;
import kalang.core.Types;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class ClassReference extends AstNode{
    
    private ClassNode referencedClassNode;

    public ClassReference(ClassNode referencedClassNode) {
        this.referencedClassNode = referencedClassNode;
    }

    public ClassNode getReferencedClassNode() {
        return referencedClassNode;
    }
    
}
