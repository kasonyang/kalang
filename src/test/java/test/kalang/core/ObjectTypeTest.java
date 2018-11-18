package test.kalang.core;

import kalang.compiler.AstNotFoundException;
import kalang.compiler.ast.ClassNode;
import kalang.compiler.core.ClassType;
import kalang.compiler.core.ObjectType;
import kalang.compiler.core.Types;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 *
 * @author Kason Yang
 */
public class ObjectTypeTest {
  
  private int privateField;
  
  protected int protectedField;
  
  public int publicField;
  
  public ObjectTypeTest() {
  }
  
  @Test
  public void test() throws AstNotFoundException{
    ClassType type = Types.getClassType(ObjectTypeTest.class.getName());
    ClassNode classNode = type.getClassNode();
    ObjectType rootType = Types.getRootType();
    ClassNode rootClassNode = rootType.getClassNode();
    assertEquals(null,type.getFieldDescriptor(rootClassNode, "privateField"));
    assertEquals(null,type.getFieldDescriptor(rootClassNode, "protectedField"));
    assertNotEquals(null, type.getFieldDescriptor(rootClassNode, "publicField"));
    assertNotEquals(null,type.getFieldDescriptor(classNode, "privateField"));
    assertNotEquals(null,type.getFieldDescriptor(classNode, "protectedField"));
    assertNotEquals(null, type.getFieldDescriptor(classNode, "publicField"));
  }
  
}
