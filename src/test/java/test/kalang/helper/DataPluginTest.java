package test.kalang.helper;

import kalang.helper.DataPlugin;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

/**
 * @author lbqh
 */
public class DataPluginTest {

    @Test
    public void test() {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            testLong(random.nextLong());
            testInt(random.nextInt());
            testShort((short) random.nextInt());
        }
    }

    private void testShort(short value) {
        byte[] shortBuffer = new byte[2];
        DataPlugin.writeShortB(shortBuffer, 0, value);
        Assert.assertEquals(value, DataPlugin.readShortB(shortBuffer, 0));
        DataPlugin.writeShortL(shortBuffer, 0, value);
        Assert.assertEquals(value, DataPlugin.readShortL(shortBuffer, 0));
    }

    private void testInt(int value) {
        byte[] intBuffer = new byte[4];
        DataPlugin.writeIntB(intBuffer, 0, value);
        Assert.assertEquals(value, DataPlugin.readIntB(intBuffer, 0));
        DataPlugin.writeIntL(intBuffer, 0, value);
        Assert.assertEquals(value, DataPlugin.readIntL(intBuffer, 0));
    }

    private void testLong(long value) {
        byte[] longBuffer = new byte[8];
        DataPlugin.writeLongB(longBuffer, 0, value);
        Assert.assertEquals(value, DataPlugin.readLongB(longBuffer, 0));
        DataPlugin.writeLongL(longBuffer, 0, value);
        Assert.assertEquals(value, DataPlugin.readLongL(longBuffer, 0));
    }

}
