package kalang.test;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import junit.framework.Assert;
import kalang.compiler.Diagnosis;
import kalang.compiler.DiagnosisHandler;
import kalang.compiler.StandardDiagnosisHandler;
import kalang.tool.FileSystemCompiler;

/**
 *
 * @author Kason Yang
 */
public class JointCompilerTestCase extends FileSystemCompiler {

    public JointCompilerTestCase() {
        super();
    }

    @Override
    public void compile() throws IOException {
        final DiagnosisHandler oldDiagnosisHandler = StandardDiagnosisHandler.INSTANCE;
        this.setDiagnosisHandler(new DiagnosisHandler() {
            @Override
            public void handleDiagnosis(Diagnosis diagnosis) {
                oldDiagnosisHandler.handleDiagnosis(diagnosis);
                if (diagnosis.getKind().isError()) {
                    Assert.fail(Objects.toString(diagnosis));
                }
            }
        });
        this.setOutputDir(new File("build/kalang-test"));
        super.compile();
    }

}
