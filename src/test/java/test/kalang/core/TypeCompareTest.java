package test.kalang.core;

import kalang.compiler.AstNotFoundException;
import kalang.compiler.ast.ClassNode;
import kalang.compiler.compile.JavaAstLoader;
import kalang.compiler.core.Type;
import org.junit.Assert;
import org.junit.Test;

public class TypeCompareTest {

    @Test
    public void testEquals() throws AstNotFoundException {
        JavaAstLoader loader1 = new JavaAstLoader(null,TypeCompareTest.class.getClassLoader());
        JavaAstLoader loader2 = new JavaAstLoader(null, TypeCompareTest.class.getClassLoader().getParent());
        ClassNode t1 = loader1.loadAst(String.class.getName());
        ClassNode t2 = loader2.loadAst(String.class.getName());
        Assert.assertEquals(t1,t2);
    }

}
