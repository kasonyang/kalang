package kalang.test;

import java.util.Objects;
import junit.framework.Assert;
import kalang.compiler.Diagnosis;
import kalang.compiler.DiagnosisHandler;
import kalang.tool.JointFileSystemCompiler;

/**
 *
 * @author Kason Yang
 */
public class JointCompilerTestCase extends JointFileSystemCompiler {

    public JointCompilerTestCase() {
        super();
        final DiagnosisHandler oldDiagnosisHandler = super.diagnosisHandler;
        this.diagnosisHandler = new DiagnosisHandler() {
            @Override
            public void handleDiagnosis(Diagnosis diagnosis) {
                oldDiagnosisHandler.handleDiagnosis(diagnosis);
                if (diagnosis.getKind().isError()) {
                    Assert.fail(Objects.toString(diagnosis));
                }
            }
        };
    }

}
