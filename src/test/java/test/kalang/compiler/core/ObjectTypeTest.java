package test.kalang.compiler.core;

import kalang.compiler.compile.ClassNodeNotFoundException;
import kalang.compiler.ast.ClassNode;
import kalang.compiler.core.ClassType;
import kalang.compiler.core.ObjectType;
import kalang.compiler.core.Types;
import org.junit.Test;

import static org.junit.Assert.*;

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
  public void test() throws ClassNodeNotFoundException {
    ClassType type = Types.getClassType(ObjectTypeTest.class.getName());
    ClassNode classNode = type.getClassNode();
    ObjectType rootType = Types.getRootType();
    ClassNode rootClassNode = rootType.getClassNode();
    assertNull(type.getFieldDescriptor(rootClassNode, "privateField"));
    assertNull(type.getFieldDescriptor(rootClassNode, "protectedField"));
    assertNotEquals(null, type.getFieldDescriptor(rootClassNode, "publicField"));
    assertNotEquals(null,type.getFieldDescriptor(classNode, "privateField"));
    assertNotEquals(null,type.getFieldDescriptor(classNode, "protectedField"));
    assertNotEquals(null, type.getFieldDescriptor(classNode, "publicField"));
  }
  
}
