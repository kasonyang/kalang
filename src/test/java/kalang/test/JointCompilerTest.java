package kalang.test;

import java.io.File;
import java.io.IOException;
import kalang.tool.JointFileSystemCompiler;
import org.junit.Test;

/**
 *
 * @author Kason Yang <im@kasonyang.com>
 */
public class JointCompilerTest extends JointFileSystemCompiler{
    
    @Test
    public void test() throws IOException{
        addSourceDir(new File("TestScript/joint"));
        compile();
    }

}
