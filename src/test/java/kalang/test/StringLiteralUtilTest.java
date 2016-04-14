package kalang.test;

import kalang.util.StringLiteralUtil;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kason Yang <im@kasonyang.com>
 */
public class StringLiteralUtilTest {
    
    public StringLiteralUtilTest() {
    }
    
    @Test
    public void test(){
        String literal = "\\b\\t\\n\\f\\r\\\"\\\'\\\\";
        String str = "\b\t\n\f\r\"\'\\";
        assertEquals(str, StringLiteralUtil.parse(literal));
    }
    
}
