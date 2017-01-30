package kalang.compiler;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 *
 * @author Kason Yang
 */
public class StandardDiagnosisHandler implements DiagnosisHandler{
    
    public static StandardDiagnosisHandler INSTANCE = new StandardDiagnosisHandler();

    private final PrintStream out;

    public StandardDiagnosisHandler() {
        out = System.out;
    }

    public StandardDiagnosisHandler(PrintStream out) {
        this.out = out;
    }

    
    protected void reportDiagnosis(Diagnosis dn){
        out.println(dn);
    }

    @Override
    public void handleDiagnosis(Diagnosis diagnosis) {
        this.reportDiagnosis(diagnosis);
    }

}
