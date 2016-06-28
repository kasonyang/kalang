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
    
    //TODO call with compiler so that stop compile
    void handleCompileError(CompileError error);

}
