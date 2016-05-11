package kalang.test;

import kalang.java.MemoryCompiler;
import kalang.java.MemoryFileManager;
import org.junit.Test;

/**
 *
 * @author Kason Yang <im@kasonyang.com>
 */
public class MemoryCompilerTest {
    
    @Test
    public void test() throws ClassNotFoundException {
        MemoryCompiler cp = new MemoryCompiler();
        cp.addSourceFromString("Helloworld", "public class Helloworld{}");
        cp.compile();
        MemoryFileManager fm = cp.getFileManager();
        System.out.println(fm.getBytes());
        Class clazz = cp.loadClass("Helloworld");
        System.out.println(clazz);
        
    }

}
