package test.kalang.tool;

import kalang.compiler.shell.Kalangc;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author Kason Yang
 */
public class KalangcTest {

    public KalangcTest() {
    }

    @Test
    public void test() {
        String[] args = new String[]{
            "-h"
        };
        Assert.assertEquals(0, new Kalangc().run(args));
    }

    //@Test
    public void testCompile() throws FileNotFoundException {
        File projectDir = new File("src/test/kalang-snippets/projects/colorful-console");
        if (!projectDir.exists()) {
            throw new FileNotFoundException(projectDir.getAbsolutePath());
        }
        String outDir = new File("build/kalang-test/projects").getAbsolutePath();
        String libpath = new File(projectDir,"jansi-1.14.jar").getAbsolutePath();
        String[] args = new String[] {
                "--output-dir",outDir,"--classpath",libpath,projectDir.getAbsolutePath()
        };
        int result = new Kalangc().run(args);
        Assert.assertEquals(0,result);
    }

}
