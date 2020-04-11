package test.kalang.compiler;

import kalang.compiler.util.FilePathUtil;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Kason Yang 
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
