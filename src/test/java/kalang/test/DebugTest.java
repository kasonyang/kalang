package kalang.test;

import kalang.compiler.shell.Kalangsh;
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

}
