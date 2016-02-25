package kalang.test;

import java.io.File;
import java.lang.reflect.Method;
import kalang.KalangClassLoader;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class ClassLoaderTest {
    
    public ClassLoaderTest() {
    }

    @Test
    public void test() throws Exception{
        KalangClassLoader clsLoader = new KalangClassLoader(new File("TestScript/source"));
        clsLoader.setOutputDir(new File("build/ClassLoaderTest"));
        Class<?> hwCls = clsLoader.loadClass("test.HelloKalang");
        Object inst = hwCls.newInstance();
        Method[] mds = hwCls.getDeclaredMethods();
        for(int i=0;i<mds.length;i++){
            Method m = mds[i];
            Object ret;
            try{
                ret = m.invoke(inst, null);
            }catch(Exception ex){
                System.err.println("Exception in method:" + m.getName());
                ex.printStackTrace();
                continue;
            }
            assertEquals(6, ret);
        }
        //Method md = hwCls.getMethod("test", null);
        //Object ret = md.invoke(null, null);
        //System.out.println(ret);
        
    }
    
}
