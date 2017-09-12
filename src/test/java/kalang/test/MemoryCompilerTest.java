package kalang.test;

import java.io.File;
import junit.framework.Assert;
import kalang.java.MemoryCompiler;
import kalang.java.MemoryFileManager;
import org.junit.Test;

/**
 *
 * @author Kason Yang 
 */
public class MemoryCompilerTest {
    
    @Test
    public void testSourcePath() throws ClassNotFoundException{
        MemoryCompiler cp = new MemoryCompiler();
        cp.addSourcePath(new File("TestScript/java"));
        Class<?> clazz = cp.loadClass("Helloworld");
        Assert.assertNotNull(clazz);
    }
    
    @Test
    public void test() throws ClassNotFoundException {
        MemoryCompiler cp = new MemoryCompiler();
        cp.addSourceFromString("Helloworld", "public class Helloworld{}");
        cp.compile();
        MemoryFileManager fm = cp.getFileManager();
        Assert.assertNotNull(fm.getBytes());
        Class clazz = cp.loadClass("Helloworld");
        Assert.assertNotNull(clazz);
    }

}
