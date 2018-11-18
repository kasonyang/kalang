package kalang.test;

import kalang.compiler.KalangClassLoader;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertNotNull;

/**
 *
 * @author Kason Yang 
 */
public class ClassLoaderTest {
    
    public ClassLoaderTest() {
    }
    
    @Test
    public void testFiles() throws IOException{
        KalangClassLoader clsLoader = new KalangClassLoader(new File[0],null,null);
        Class clazz = clsLoader.parseFile("HelloKalang", new File("src/test/kalang-snippets/automation/HelloKalang.kl"));
        assertNotNull(clazz);
    }

    
}
