package kalang.test;

import java.io.File;
import java.io.IOException;
import kalang.compiler.DiagnosisHandler;
import kalang.tool.KalangShell;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Kason Yang
 */
public class DebugTest {

    public DebugTest() {

    }

    @Test
    public void test() throws IOException {
        File debugFile = new File("debug/debug.kl");
        if (debugFile.exists()) {
            KalangShell shell = new KalangShell();
            Class clz = shell.parse(debugFile);
            Assert.assertNotNull(clz);
        }
    }

}
