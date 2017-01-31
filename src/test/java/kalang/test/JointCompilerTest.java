package kalang.test;

import java.io.File;
import java.io.IOException;
import org.junit.Test;

/**
 *
 * @author Kason Yang <im@kasonyang.com>
 */
public class JointCompilerTest extends JointCompilerTestCase{
    
    @Test
    public void test() throws IOException{
        addSourceDir(new File("TestScript/joint"));
        addJavaSourceDir(new File("TestScript/joint"));
        compile();
    }

}
