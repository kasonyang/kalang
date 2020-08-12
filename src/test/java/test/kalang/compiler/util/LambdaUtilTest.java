package test.kalang.compiler.util;

import kalang.compiler.core.ClassType;
import kalang.compiler.core.MethodDescriptor;
import kalang.compiler.core.Types;
import kalang.compiler.util.LambdaUtil;
import org.junit.Test;

import java.util.Comparator;

/**
 * @author KasonYang
 */
public class LambdaUtilTest {

    @Test
    public void testFunctionMethod() {
        ClassType comparatorClass = Types.getClassType(Comparator.class.getName());
        MethodDescriptor funcMethod = LambdaUtil.getFunctionalMethod(comparatorClass);
        assert funcMethod != null;
    }

}
