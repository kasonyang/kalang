package kalang.test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kalang.KalangClassLoader;
import kalang.lang.Script;
import org.junit.Test;
import static org.junit.Assert.*;

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
