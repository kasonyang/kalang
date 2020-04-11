package test.kalang.compiler.core;

import kalang.compiler.compile.AstNotFoundException;
import kalang.compiler.ast.ClassNode;
import kalang.compiler.compile.jvm.JvmAstLoader;
import org.junit.Assert;
import org.junit.Test;

public class TypeCompareTest {

    @Test
    public void testEquals() throws AstNotFoundException {
        JvmAstLoader loader1 = new JvmAstLoader(null,TypeCompareTest.class.getClassLoader());
        JvmAstLoader loader2 = new JvmAstLoader(null, TypeCompareTest.class.getClassLoader().getParent());
        ClassNode t1 = loader1.loadAst(String.class.getName());
        ClassNode t2 = loader2.loadAst(String.class.getName());
        Assert.assertEquals(t1,t2);
    }

}
