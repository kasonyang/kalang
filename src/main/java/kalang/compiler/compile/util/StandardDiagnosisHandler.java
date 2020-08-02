package kalang.compiler.compile.util;

import kalang.compiler.compile.CompileContext;
import kalang.compiler.compile.Diagnosis;
import kalang.compiler.compile.DiagnosisHandler;

import java.io.PrintStream;

/**
 *
 * @author Kason Yang
 */
public class StandardDiagnosisHandler implements DiagnosisHandler {

    private final PrintStream errOut;

    private final PrintStream stdOut;

    private boolean hasError = false;

    public StandardDiagnosisHandler() {
        this(System.out, System.err);
    }

    public StandardDiagnosisHandler(PrintStream stdOut, PrintStream errOut) {
        this.stdOut = stdOut;
        this.errOut = errOut;
    }

    @Override
    public void handleDiagnosis(Diagnosis diagnosis) {
        boolean isError = diagnosis.getKind().isError();
        if (isError) {
            this.hasError = true;
            CompileContext ctx = diagnosis.getContext();
            ctx.stopCompile(ctx.getCompilingPhase().getId());
        }
        PrintStream o = isError ? errOut : stdOut;
        o.println(diagnosis);
    }

    public boolean hasError() {
        return hasError;
    }

}
