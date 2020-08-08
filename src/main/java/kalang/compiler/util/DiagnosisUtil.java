package kalang.compiler.util;

import kalang.compiler.compile.Diagnosis;
import kalang.compiler.compile.KalangSource;
import kalang.compiler.compile.OffsetRange;

/**
 * @author KasonYang
 */
public class DiagnosisUtil {

    public static String toPrintString(Diagnosis diagnosis) {
        KalangSource source = diagnosis.getSource();
        Diagnosis.Kind kind = diagnosis.getKind();
        OffsetRange offset = diagnosis.getOffset();
        String description = diagnosis.getDescription();
        String fileName =  source == null ? "UNKNOWN SOURCE" : source.getFileName();
        return String.format("%s:%s :%s :%s",fileName, offset.startLine, kind, description);
    }

}
