package test.kalang.compiler.util;

import kalang.compiler.core.ClassType;
import kalang.compiler.core.Type;
import kalang.compiler.core.Types;
import kalang.compiler.util.TypeUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author KasonYang
 */
public class TypeUtilTest {

    @Test
    public void testCommonType() {
        ClassType hashMapType = Types.getClassType(HashMap.class.getName());
        ClassType treeMapType = Types.getClassType(TreeMap.class.getName());
        Type commonType = TypeUtil.getCommonType(hashMapType, treeMapType);
        Assert.assertEquals(AbstractMap.class.getName(), commonType.getName());
    }

}
