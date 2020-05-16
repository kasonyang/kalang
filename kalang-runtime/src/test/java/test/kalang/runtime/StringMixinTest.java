package test.kalang.runtime;

import kalang.mixin.StringMixin;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author KasonYang
 */
public class StringMixinTest {

    @Test
    public void testSearch() {
        assertEquals("kalang", StringMixin.searchFirst("Hello, kalang!", "k[a-z]+"));
    }

}
