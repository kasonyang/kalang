package test.kalang.tool;

import kalang.compiler.tool.KalangShell;
import kalang.compiler.util.ClassExecutor;
import org.junit.Test;

/**
 *
 * @author Kason Yang
 */
public class KalangShellTest {
    
    public KalangShellTest() {
    }
    
    @Test
    public void test() throws Throwable{
        KalangShell shell = new KalangShell();
        Class script = shell.parse("Test", "println(\"test\");", "Test.kl");
        ClassExecutor.executeMain(script, new String[0]);
    }
    
}
