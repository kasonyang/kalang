package kalang.compiler.compile;

import kalang.compiler.profile.Profiler;
import kalang.compiler.profile.Span;

/**
 * @author KasonYang
 */
public class CompilationUnitController {

    private CompilationUnit compilationUnit;

    private CompilePhase currentPhase;

    public CompilationUnitController(CompilationUnit compilationUnit, CompilePhase startPhase) {
        this.compilationUnit = compilationUnit;
        this.currentPhase = startPhase;
    }

    public CompilationUnit getCompilationUnit() {
        return compilationUnit;
    }

    public void compileToPhase(CompilePhase stopPhase) {
        while (!currentPhase.isLastPhase() && currentPhase.isBefore(stopPhase)) {
            currentPhase = currentPhase.nextPhase();
            Span span = Profiler.getInstance().beginSpan("compilationPhase@" + currentPhase.getId());
            currentPhase.process(compilationUnit);
            Profiler.getInstance().endSpan(span);
        }
    }

}
