package test.kalang.helper;

import kalang.helper.DataPlugin;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author lbqh
 */
public class DataPluginTest {

    @Test
    public void test() {
        byte[] buffer = new byte[8];
        Long value = 0x1234567890ABCDEFL;
        DataPlugin.writeLongB(buffer, 0, value);
        Assert.assertEquals(value.longValue(), DataPlugin.readLongB(buffer, 0));
        DataPlugin.writeLongL(buffer, 0, value);
        Assert.assertEquals(value.longValue(), DataPlugin.readLongL(buffer, 0));

        DataPlugin.writeIntB(buffer, 0, value.intValue());
        Assert.assertEquals(value.intValue(), DataPlugin.readIntB(buffer, 0));
        DataPlugin.writeIntL(buffer, 0, value.intValue());
        Assert.assertEquals(value.intValue(), DataPlugin.readIntL(buffer, 0));

        DataPlugin.writeShortB(buffer, 0, value.shortValue());
        Assert.assertEquals(value.shortValue(), DataPlugin.readShortB(buffer, 0));
        DataPlugin.writeShortL(buffer, 0, value.shortValue());
        Assert.assertEquals(value.shortValue(), DataPlugin.readShortL(buffer, 0));

    }

}
