package test.kalang.compiler;

import junit.framework.Assert;
import kalang.compiler.compile.DiagnosisHandler;
import kalang.compiler.compile.util.StandardDiagnosisHandler;
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
        this.setDiagnosisHandler(diagnosis -> {
            oldDiagnosisHandler.handleDiagnosis(diagnosis);
            if (diagnosis.getKind().isError()) {
                Assert.fail(Objects.toString(diagnosis));
            }
        });
        this.setOutputDir(new File("build/kalang-test"));
        super.compile();
    }

}
