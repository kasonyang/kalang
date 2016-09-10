package kalang.test;

import java.io.File;
import java.io.IOException;
import junit.framework.Assert;
import kalang.compiler.Diagnosis;
import kalang.compiler.codegen.Ast2Class;
import kalang.tool.MemoryOutputManager;
import org.junit.Test;

/**
 *
 * @author Kason Yang
 */
public class DebugTest extends JointCompilerTestCase {
    
    boolean hasError = false;
    
    public DebugTest() {
    }

    @Override
    protected void reportDiagnosis(Diagnosis diagnosis) {
        System.err.print(diagnosis);
        this.hasError = true;
    }
    
    
    
    @Test
    public void test() throws IOException{
        File debugDir = new File("debug");
        if(debugDir.exists()){
            this.addKalangAndJavaSourceDir(debugDir);
            this.setCodeGenerator(new Ast2Class(new MemoryOutputManager()));
            compile();
        }
        if(this.hasError) Assert.fail("compile error");
    }
    
}
