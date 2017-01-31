package kalang.test;

import java.io.File;
import java.io.IOException;
import junit.framework.Assert;
import kalang.compiler.Diagnosis;
import kalang.compiler.DiagnosisHandler;
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
        super();
        final DiagnosisHandler oldHandler = super.diagnosisHandler;
        this.setDiagnosisHandler(new DiagnosisHandler() {
            @Override
            public void handleDiagnosis(Diagnosis diagnosis) {
                oldHandler.handleDiagnosis(diagnosis);
                if(diagnosis.getKind().isError()){
                    DebugTest.this.hasError = true;
                }
            }
        });
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
