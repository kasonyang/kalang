package test.kalang.tool;

import kalang.lang.Script;
import kalang.tool.KalangShell;
import kalang.util.ClassExecutor;
import org.junit.Test;
import static org.junit.Assert.*;

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
