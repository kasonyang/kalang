package kalang.test;

import junit.framework.Assert;
import kalang.compiler.CompileError;
import kalang.compiler.CompileErrorHandler;
import kalang.tool.JointFileSystemCompiler;

/**
 *
 * @author Kason Yang <im@kasonyang.com>
 */
public class JointCompilerTestCase extends JointFileSystemCompiler{

    public JointCompilerTestCase() {
        setCompileErrorHandler(new CompileErrorHandler(){
            @Override
            public void handleCompileError(CompileError error) {
                Assert.fail(error.toString());
            }
            
        });
    }
    
    

}
