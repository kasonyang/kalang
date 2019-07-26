
package kalang.compiler.compile;

/**
 *
 * @author Kason Yang 
 */
public class CompilePhase {
        public final static int 
            PHASE_INITIALIZE = 1,
            PHASE_PARSING = 2,
            PHASE_BUILDAST = 3,
            PHASE_SEMANTIC = 4,//unused
            PHASE_CLASSGEN = 5,
            PHASE_ALL = 6;
}
