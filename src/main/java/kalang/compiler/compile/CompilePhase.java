
package kalang.compiler.compile;

/**
 * @author Kason Yang
 */
public interface CompilePhase {

    String getId();

    boolean isBefore(CompilePhase other);

    CompilePhase nextPhase();

    boolean isLastPhase();

    void process(CompilationUnit compilationUnit);

}
