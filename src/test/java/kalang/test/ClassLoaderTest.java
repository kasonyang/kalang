package kalang.test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kalang.KalangClassLoader;
import kalang.Script;
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
        Class clazz = clsLoader.parseFile("test.HelloKalang", new File("TestScript/source/test/HelloKalang.kl"));
        assertNotNull(clazz);
    }

    @Test
    public void test() throws Exception{
        testClass("test.HelloKalang");
        testClass("test.HelloScript");
    }
    public void testClass(String className) throws Exception{
        KalangClassLoader clsLoader = new KalangClassLoader();
        clsLoader.addClassPath(new File("TestScript/source"));
        //clsLoader.setOutputDir(new File("build/ClassLoaderTest"));
        Class<?> hwCls = clsLoader.loadClass(className);
        Object inst = hwCls.newInstance();
        Method[] mds = hwCls.getDeclaredMethods();
        for(int i=0;i<mds.length;i++){
            Method m = mds[i];
            String methodName = m.getName();
            if((inst instanceof Script) && "execute".equals(methodName)){
                continue;
            }
            Object ret;
            try{
                if(m.getParameterCount()>0) continue;
                if(Modifier.isStatic(m.getModifiers())){
                    ret = m.invoke(null,(Object[]) null);
                }else{
                    ret = m.invoke(inst, (Object[]) null);
                }
            }catch(Exception ex){
                System.err.println("Exception in method:" + m.getName());
                ex.printStackTrace();
                continue;
            }
            assertEquals("result of method[" + methodName + "] should be 6",6, ret);
        }
        //Method md = hwCls.getMethod("test", null);
        //Object ret = md.invoke(null, null);
        //System.out.println(ret);
        
    }
    
}
