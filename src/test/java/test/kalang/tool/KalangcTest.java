package test.kalang.tool;

import junit.framework.Assert;
import kalang.shell.Kalangc;
import org.junit.Test;

/**
 *
 * @author Kason Yang
 */
public class KalangcTest {

    public KalangcTest() {
    }

    @Test
    public void test() {
        String[] args = new String[]{
            "-h"
        };
        Assert.assertEquals(0, new Kalangc().run(args));
    }

}
