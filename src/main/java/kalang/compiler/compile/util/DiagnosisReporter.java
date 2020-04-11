package kalang.compiler.compile.util;

import kalang.compiler.compile.*;

/**
 *
 * @author Kason Yang
 */
public class DiagnosisReporter {

    private final CompileContext compilationUnit;

    private final KalangSource kalangSource;

    public DiagnosisReporter(CompilationUnit compilationUnit) {
        this.compilationUnit = compilationUnit.getCompileContext();
        this.kalangSource = compilationUnit.getSource();
    }
    
    public void report(Diagnosis.Kind kind, String message, OffsetRange offset){
        Diagnosis diagnosis = new Diagnosis(compilationUnit, kind, offset, message, kalangSource);
        compilationUnit.getDiagnosisHandler().handleDiagnosis(diagnosis);
    }

}
