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
        String desc = error.getDescription();
        CompilationUnit cunit = error.getCompilationUnit();
        KalangSource source = null;
        if(cunit!=null){
            source = cunit.getSource();            
        }
        Diagnosis dn = new Diagnosis(Diagnosis.Kind.ERROR,error.offset,desc,source);
        reportDiagnosis(dn);
    }
    
    protected void reportDiagnosis(Diagnosis dn){
        out.println(dn);
    }

}
