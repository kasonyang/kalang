package kalang.test;

import java.io.File;
import java.io.IOException;
import kalang.tool.FileSystemCompiler;
import org.junit.Test;

/**
 *
 * @author Kason Yang <im@kasonyang.com>
 */
public class JavaStubTest extends FileSystemCompiler{
    
    @Test
    public void test() throws IOException{
        addSourceDir(new File("examples"));
        //generateJavaStub(null);
    }

}
