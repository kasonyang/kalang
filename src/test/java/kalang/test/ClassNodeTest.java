package kalang.test;

import kalang.ast.ClassNode;
import kalang.compiler.AstLoader;
import kalang.AstNotFoundException;
import kalang.core.ArrayType;
import kalang.core.ClassType;
import kalang.core.Types;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class ClassNodeTest {
    
    public ClassNodeTest() {
    }
    
    @Test
    public void test() throws AstNotFoundException{
        AstLoader astLoader = new AstLoader();
        ClassNode listClass = astLoader.loadAst("java.util.List");
        ClassNode arrayListClass = astLoader.loadAst("java.util.ArrayList");
        assertTrue(arrayListClass.isSubclassOf(listClass));
        assertFalse(listClass.isSubclassOf(listClass));
        
        
        ClassType listType = Types.getClassType(listClass);
        ArrayType listArrayType = Types.getArrayType(listType);
        ClassType arrayListType = Types.getClassType(arrayListClass);
        ArrayType arrayListArrayType = Types.getArrayType(arrayListType);
        assertTrue(arrayListType.isSubTypeOf(listType));
        assertTrue(arrayListArrayType.isSubTypeOf(listArrayType));
        //assertTrue(listType.isSubTypeOf(Types.getRootType()));
    }
    
}
