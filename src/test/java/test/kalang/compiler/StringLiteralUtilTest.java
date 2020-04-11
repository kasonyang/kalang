package test.kalang.compiler;

import kalang.compiler.util.StringLiteralUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Kason Yang 
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
    
    @Test
    public void testInt(){
        assertEquals(0x0, StringLiteralUtil.parseLong("0x0"));
        assertEquals(0x1, StringLiteralUtil.parseLong("0x1"));
        assertEquals(0xF, StringLiteralUtil.parseLong("0xF"));
        assertEquals(0x10, StringLiteralUtil.parseLong("0x10"));
        assertEquals(0xFF, StringLiteralUtil.parseLong("0xFF"));
        assertEquals(0xFFFF,       StringLiteralUtil.parseLong("0xFFFF"));
        assertEquals(0xFFFFFL,     StringLiteralUtil.parseLong("0xFFFFF"));
        assertEquals(0xFFFFFFL,   StringLiteralUtil.parseLong("0xFFFFFF"));
        assertEquals(0xFFFFFFFL, StringLiteralUtil.parseLong("0xFFFFFFF"));
        assertEquals(0xF0000000L, StringLiteralUtil.parseLong("0xF0000000"));
        assertEquals(0xF0_000_000L, StringLiteralUtil.parseLong("0xF0_000_000"));
        
        
        assertEquals(01, StringLiteralUtil.parseLong("01"));
        assertEquals(010, StringLiteralUtil.parseLong("010"));
        assertEquals(011, StringLiteralUtil.parseLong("011"));
        assertEquals(0010, StringLiteralUtil.parseLong("0010"));
        assertEquals(001_0, StringLiteralUtil.parseLong("001_0"));
        
        
    }
    
}
