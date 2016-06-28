package kalang.util;

import kalang.compiler.CompilationUnit;
import kalang.compiler.CompileError;
import kalang.compiler.Diagnosis;
import kalang.compiler.KalangSource;

/**
 *
 * @author Kason Yang
 */
public class DiagnosisUtil {
    
    public static Diagnosis createFromCompileError(CompileError error){
        String desc = error.getDescription();
        CompilationUnit cunit = error.getCompilationUnit();
        KalangSource source = null;
        if(cunit!=null){
            source = cunit.getSource();            
        }
        Diagnosis dn = new Diagnosis(Diagnosis.Kind.ERROR,error.getOffset(),desc,source);
        return dn;
    }

}
