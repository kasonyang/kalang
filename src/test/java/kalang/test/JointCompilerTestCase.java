package kalang.test;

import java.util.Objects;
import junit.framework.Assert;
import kalang.compiler.CompileError;
import kalang.compiler.CompileErrorHandler;
import kalang.compiler.Diagnosis;
import kalang.tool.JointFileSystemCompiler;

/**
 *
 * @author Kason Yang <im@kasonyang.com>
 */
public class JointCompilerTestCase extends JointFileSystemCompiler{

    public JointCompilerTestCase() {
        
    }

    @Override
    protected void reportDiagnosis(Diagnosis diagnosis) {
        super.reportDiagnosis(diagnosis);
        if(diagnosis.getKind().isError()){
            Assert.fail(Objects.toString(diagnosis));
        }
    }
    
    

}
