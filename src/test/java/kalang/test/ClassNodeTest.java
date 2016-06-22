package kalang.test;

import kalang.ast.ClassNode;
import kalang.compiler.AstLoader;
import kalang.AstNotFoundException;
import kalang.core.ArrayType;
import kalang.core.ObjectType;
import kalang.core.Type;
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
        
        Type[] paramTypes = new Type[]{Types.getRootType()};
        ObjectType listType = Types.getClassType(listClass,paramTypes );
        ArrayType listArrayType = Types.getArrayType(listType);
        ObjectType arrayListType = Types.getClassType(arrayListClass,paramTypes );
        ArrayType arrayListArrayType = Types.getArrayType(arrayListType);
        assertTrue(arrayListType.isSubTypeOf(listType));
        assertTrue(listArrayType.isAssignedFrom(arrayListArrayType));
        //assertTrue(listType.isSubTypeOf(Types.getRootType()));
    }
    
}
