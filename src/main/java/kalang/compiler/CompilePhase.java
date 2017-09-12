
package kalang.compiler;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author Kason Yang 
 */
public class CompilePhase {
        public final static int 
            PHASE_INITIALIZE = 1,
            PHASE_PARSING = 2,
            PHASE_BUILDAST = 3,
            PHASE_SEMANTIC = 4,
            PHASE_CLASSGEN = 5,
            PHASE_ALL = 6;
}
