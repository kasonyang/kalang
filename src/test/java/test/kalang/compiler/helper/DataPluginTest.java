package test.kalang.compiler.helper;

import kalang.mixin.DataMixin;
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
        DataMixin.writeShortB(shortBuffer, 0, value);
        Assert.assertEquals(value, DataMixin.readShortB(shortBuffer, 0));
        DataMixin.writeShortL(shortBuffer, 0, value);
        Assert.assertEquals(value, DataMixin.readShortL(shortBuffer, 0));
    }

    private void testInt(int value) {
        byte[] intBuffer = new byte[4];
        DataMixin.writeIntB(intBuffer, 0, value);
        Assert.assertEquals(value, DataMixin.readIntB(intBuffer, 0));
        DataMixin.writeIntL(intBuffer, 0, value);
        Assert.assertEquals(value, DataMixin.readIntL(intBuffer, 0));
    }

    private void testLong(long value) {
        byte[] longBuffer = new byte[8];
        DataMixin.writeLongB(longBuffer, 0, value);
        Assert.assertEquals(value, DataMixin.readLongB(longBuffer, 0));
        DataMixin.writeLongL(longBuffer, 0, value);
        Assert.assertEquals(value, DataMixin.readLongL(longBuffer, 0));
    }

}
