package kalang.test;

import junit.framework.Assert;
import kalang.compiler.compile.Diagnosis;
import kalang.compiler.compile.DiagnosisHandler;
import kalang.compiler.compile.StandardDiagnosisHandler;
import kalang.compiler.tool.FileSystemCompiler;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 *
 * @author Kason Yang
 */
public class CompilerTestCase extends FileSystemCompiler {

    public CompilerTestCase() {
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
