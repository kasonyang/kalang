package kalang.compiler;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import kalang.util.DiagnosisUtil;

/**
 *
 * @author Kason Yang
 */
public class StandardCompileHandler implements CompileErrorHandler{
    
    public static StandardCompileHandler INSTANCE = new StandardCompileHandler();

    private final PrintStream out;

    public StandardCompileHandler() {
        out = System.out;
    }

    public StandardCompileHandler(PrintStream out) {
        this.out = out;
    }

    @Override
    public void handleCompileError(CompileError error) {
        reportDiagnosis(DiagnosisUtil.createFromCompileError(error));
    }
    
    protected void reportDiagnosis(Diagnosis dn){
        out.println(dn);
    }

}
