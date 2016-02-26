
package kalang.compiler;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class CompilePhase {
        public final static int 
            PHASE_INITIALIZE = 0,
            PHASE_PARSING = 1,
            PHASE_BUILDAST = 2,
            PHASE_SEMANTIC = 3,
            PHASE_CLASSGEN = 4,
            PHASE_ALL = 5;
}
