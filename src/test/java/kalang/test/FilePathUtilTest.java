package kalang.test;

import java.io.File;
import kalang.util.FilePathUtil;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class FilePathUtilTest {
    
    public FilePathUtilTest() {
    }
    @Test
    public void test(){
        File f = new File("SRC");
        File f2 = new File("src");
        assertFalse(FilePathUtil.existFile(f));
        assertTrue(FilePathUtil.existFile(f2));
    }
    
}
