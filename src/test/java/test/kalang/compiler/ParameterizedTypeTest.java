package test.kalang.compiler;

import kalang.compiler.compile.AstNotFoundException;
import kalang.compiler.core.ClassType;
import kalang.compiler.core.ObjectType;
import kalang.compiler.core.Type;
import kalang.compiler.core.Types;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Kason Yang
 */
public class ParameterizedTypeTest {
    
    @Test
    public void test() throws AstNotFoundException{
        //TODO optimize
        ClassType pt = Types.getClassType(Types.getClassType("java.util.LinkedList").getClassNode(),new Type[]{Types.getIntClassType()});
        ObjectType supType = pt.getSuperType();
        assertTrue(supType instanceof ClassType);        
        assertEquals("java.util.AbstractSequentialList<java.lang.Integer>", supType.toString());
        //MethodDescriptor[] mds = supType.getMethodDescriptors(null, true,true);
        //System.out.print(Arrays.toString(mds));
    }
    
}
