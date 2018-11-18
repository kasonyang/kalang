package test.kalang.runtime;

import kalang.runtime.dynamic.FieldVisitor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Kason Yang 
 */
public class FieldVisitorTest {
    public String name = "test";
    @Test
    public void test() throws Exception{
        FieldVisitorTest test = new FieldVisitorTest();
        assertEquals(FieldVisitor.get(test, "name"), "test");
        FieldVisitor.set(test, "name", "hello");
        assertEquals(FieldVisitor.get(test, "name"), "hello");
    }
}
