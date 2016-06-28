package kalang.compiler;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author Kason Yang
 */
public interface CompileErrorHandler {
    
    void handleCompileError(CompileError error);

}
