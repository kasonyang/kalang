package kalang.test;

import java.io.File;
import java.io.IOException;
import kalang.compiler.CompileError;
import kalang.tool.JointFileSystemCompiler;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Kason Yang <im@kasonyang.com>
 */
public class JointCompilerTest extends JointFileSystemCompiler{
    
    @Test
    public void test() throws IOException{
        addSourceDir(new File("TestScript/joint"));
        addJavaSourceDir(new File("TestScript/joint"));
        compile();
    }

    @Override
    public void handleCompileError(CompileError error) {
        Assert.fail(error.toString());
    }
    
    

}
