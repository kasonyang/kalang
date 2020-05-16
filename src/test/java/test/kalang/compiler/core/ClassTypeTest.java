package test.kalang.compiler.core;

import kalang.compiler.core.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author KasonYang
 */
public class ClassTypeTest {

    @Test
    public void testListMethod() {
        ClassType listCls = Types.getClassType(List.class.getName());
        ClassType intListCls = Types.getClassType(listCls.getClassNode(), new Type[]{ Types.getIntClassType() });
        MethodDescriptor[] mds = intListCls.getMethodDescriptors(null, "sort", false, false);
        assertEquals(1, mds.length);
        Type[] paramTypes = mds[0].getParameterTypes();
        assertEquals(1, paramTypes.length);
        ClassType ct = (ClassType) paramTypes[0];
        assertEquals(NullableKind.UNKNOWN, ct.getNullable());
    }

}
