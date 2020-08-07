package test.kalang.compiler.core;

import kalang.compiler.compile.ClassNodeNotFoundException;
import kalang.compiler.ast.ClassNode;
import kalang.compiler.compile.jvm.JvmClassNodeLoader;
import org.junit.Assert;
import org.junit.Test;

public class TypeCompareTest {

    @Test
    public void testEquals() throws ClassNodeNotFoundException {
        JvmClassNodeLoader loader1 = new JvmClassNodeLoader(null,TypeCompareTest.class.getClassLoader());
        JvmClassNodeLoader loader2 = new JvmClassNodeLoader(null, TypeCompareTest.class.getClassLoader().getParent());
        ClassNode t1 = loader1.loadClassNode(String.class.getName());
        ClassNode t2 = loader2.loadClassNode(String.class.getName());
        Assert.assertEquals(t1,t2);
    }

}
