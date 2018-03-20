package kalang.test;

import java.io.File;
import java.io.IOException;
import kalang.compiler.DiagnosisHandler;
import org.junit.Test;

/**
 *
 * @author Kason Yang
 */
public class DebugTest extends JointCompilerTestCase {

    DiagnosisHandler oldHandler;

    public DebugTest() {

    }

    @Test
    public void test() throws IOException {
        File debugDir = new File("debug");
        if (debugDir.exists()) {
            addSourceDir(debugDir);
            compile();
        }
    }

}
