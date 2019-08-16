package test.kalang.automation;

import kalang.compiler.tool.KalangShell;
import kalang.lang.Script;
import org.junit.Test;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.Assert.*;

public class SnippetsTest {

    public int testField = 1;

    @Test
    public void testExamples() throws Exception {
        File examplesSrcDir = new File("src/test/kalang-snippets/examples");
        testAll(examplesSrcDir,false);
    }

    @Test
    public void testAutomation() throws Exception {
        File automationSrcDir = new File("src/test/kalang-snippets/automation");
        testAll(automationSrcDir,true);
    }

    private void testAll(File file,boolean checkReturnValue) throws Exception {
        if (file.isDirectory()) {
            File[] children = file.listFiles();
            for (File c : children) {
                testAll(c,checkReturnValue);
            }
            return;
        }
        if (!file.isFile()) {
            return;
        }
        KalangShell shell = new KalangShell();
        shell.addSourcePath(file.getParentFile());
        Class<?> hwCls = shell.parse(file);
        if(!checkReturnValue) {
            return;
        }
        Object inst = hwCls.newInstance();
        Method[] mds = hwCls.getDeclaredMethods();
        for (int i = 0; i < mds.length; i++) {
            Method m = mds[i];
            String methodName = m.getName();
            if ((inst instanceof Script) && "execute".equals(methodName)) {
                continue;
            }
            String fullMethodName = inst.getClass().getName() + ":" + methodName;
            Object ret;
            try {
                if (m.getParameterCount() > 0) continue;
                if (Modifier.isStatic(m.getModifiers())) {
                    ret = m.invoke(null, (Object[]) null);
                } else {
                    ret = m.invoke(inst, (Object[]) null);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                fail("Exception in method:" + m.getName());
                continue;
            }
            System.out.println("result of method[" + fullMethodName + "]:" + ret );
            if (ret instanceof Boolean) {
                assertTrue("result of method[" + fullMethodName + "] should be true",(Boolean) ret);
            } else {
                assertEquals("result of method[" + fullMethodName + "] should be 6", 6, ret);
            }

        }

    }

}
