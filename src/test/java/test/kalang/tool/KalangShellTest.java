package test.kalang.tool;

import kalang.lang.Script;
import kalang.tool.KalangShell;
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
    public void test(){
        KalangShell shell = new KalangShell();
        Script script = shell.parseScript("Test", "println(\"test\");", "Test.kl");
        assertEquals(Script.SUCCESS, script.run());
    }
    
}
