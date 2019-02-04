package kalang.test;

import kalang.compiler.shell.Kalangsh;
import kalang.compiler.tool.KalangShell;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

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
            int result = new Kalangsh().run(new String[]{debugFile.getCanonicalPath()});
            Assert.assertEquals(0,result);
        }
    }

    @Test
    public void testParse() throws IOException {
        File debugFile = new File("debug/debug.kl");
        if (debugFile.exists()) {
            KalangShell shell = new KalangShell();
            Class clz = shell.parse(debugFile);
            System.out.println(clz);
        }
    }

}
