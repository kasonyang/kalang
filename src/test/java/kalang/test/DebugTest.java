package kalang.test;

import kalang.compiler.shell.Kalangc;
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
    public void testShell() throws IOException {
        File debugFile = new File("debug/debug.kl");
        if (debugFile.exists()) {
            int result = new Kalangsh().run(new String[]{"--profile-out","@stderr",debugFile.getCanonicalPath()});
            Assert.assertEquals(0,result);
        }
    }

    @Test
    public void testCompile() throws IOException {
        File debugFile = new File("debug/debug.kl");
        if (debugFile.exists()) {
            File outputDir = new File("build/kalang-debug");
            if (!outputDir.exists() && !outputDir.mkdirs()) {
                throw new IOException("failed to to create output directory for debug:" + outputDir);
            }
            int result = new Kalangc().run(new String[]{
                    "--output-dir", outputDir.getCanonicalPath(),
                    "--profile-out", "@stderr"
                    ,debugFile.getCanonicalPath()
            });
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
