package kalang.test;

import java.io.File;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kason Yang
 */
public class JointClassLoaderTest extends JointCompilerTestCase{
    
    @Test
    public void test() throws IOException{
        File path = new File("TestScript/joint");
        addSource(path,new File(path,"KalangClass.kl"));
        addSourcePath(path);
        addJavaSourcePath(path);
        compile();
    }
    
}
