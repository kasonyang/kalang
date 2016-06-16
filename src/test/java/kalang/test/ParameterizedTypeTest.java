package kalang.test;

import java.util.Arrays;
import kalang.AstNotFoundException;
import kalang.core.ClassType;
import kalang.core.MethodDescriptor;
import kalang.core.ParameterizedType;
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
        ParameterizedType pt = new ParameterizedType(Types.getClassType("java.util.LinkedList"),Types.getIntClassType());
        ClassType supType = pt.getSuperType();
        assertTrue(supType instanceof ParameterizedType);        
//        MethodDescriptor[] mds = supType.getMethodDescriptors(null, true);
//        for(int i=0;i<mds.length;i++){
//            System.out.println(mds[i]);
//        }
        //System.out.print(Arrays.toString(mds));
    }
    
}
