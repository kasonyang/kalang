package test.kalang.compiler.tool;

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
        Class script = shell.parse("Test", "println(\"test\");", "Test.kls");
        ClassExecutor.executeMain(script, new String[0]);
    }
    
}
