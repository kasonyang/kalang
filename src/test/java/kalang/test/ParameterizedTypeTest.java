package kalang.test;

import java.util.Arrays;
import kalang.AstNotFoundException;
import kalang.core.ObjectType;
import kalang.core.MethodDescriptor;
import kalang.core.ClassType;
import kalang.core.Type;
import kalang.core.Types;
import org.junit.Test;
import static org.junit.Assert.*;

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
//        MethodDescriptor[] mds = supType.getMethodDescriptors(null, true);
//        for(int i=0;i<mds.length;i++){
//            System.out.println(mds[i]);
//        }
        //System.out.print(Arrays.toString(mds));
    }
    
}
