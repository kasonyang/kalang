package kalang.helper;

import kalang.annotation.PluginMethod;

/**
 * plugin for bytes processing
 * @author lbqh
 */
public class DataPlugin {

    /**
     * write long as big-endian
     *
     * @param buffer
     * @param offset
     * @param value
     */
    @PluginMethod
    public static void writeLongB(byte[] buffer, int offset, long value) {
        int i = offset + 7;
        buffer[i--] = (byte) value;
        value >>>= 8;
        buffer[i--] = (byte) value;
        value >>>= 8;
        buffer[i--] = (byte) value;
        value >>>= 8;
        buffer[i--] = (byte) value;
        value >>>= 8;
        buffer[i--] = (byte) value;
        value >>>= 8;
        buffer[i--] = (byte) value;
        value >>>= 8;
        buffer[i--] = (byte) value;
        value >>>= 8;
        buffer[i] = (byte) value;
    }

    /**
     * write long as little endian
     *
     * @param buffer
     * @param offset
     * @param value
     */
    @PluginMethod
    public static void writeLongL(byte[] buffer, int offset, long value) {
        int i = offset;
        buffer[i++] = (byte) value;
        value >>>= 8;
        buffer[i++] = (byte) value;
        value >>>= 8;
        buffer[i++] = (byte) value;
        value >>>= 8;
        buffer[i++] = (byte) value;
        value >>>= 8;
        buffer[i++] = (byte) value;
        value >>>= 8;
        buffer[i++] = (byte) value;
        value >>>= 8;
        buffer[i++] = (byte) value;
        value >>>= 8;
        buffer[i] = (byte) value;
    }

    /**
     * write int as big endian
     *
     * @param buffer
     * @param offset
     * @param value
     */
    @PluginMethod
    public static void writeIntB(byte[] buffer, int offset, int value) {
        int i = offset + 3;
        buffer[i--] = (byte) value;
        value >>>= 8;
        buffer[i--] = (byte) value;
        value >>>= 8;
        buffer[i--] = (byte) value;
        value >>>= 8;
        buffer[i] = (byte) value;
    }

    /**
     * write int as little endian
     *
     * @param buffer
     * @param offset
     * @param value
     */
    @PluginMethod
    public static void writeIntL(byte[] buffer, int offset, int value) {
        int i = offset;
        buffer[i++] = (byte) value;
        value >>>= 8;
        buffer[i++] = (byte) value;
        value >>>= 8;
        buffer[i++] = (byte) value;
        value >>>= 8;
        buffer[i] = (byte) value;
    }


    /**
     * write short as big endian
     *
     * @param buffer
     * @param offset
     * @param value
     */
    @PluginMethod
    public static void writeShortB(byte[] buffer, int offset, short value) {
        buffer[offset + 1] = (byte) value;
        value >>>= 8;
        buffer[offset] = (byte) value;
    }

    /**
     * write short as little endian
     *
     * @param buffer
     * @param offset
     * @param value
     */
    @PluginMethod
    public static void writeShortL(byte[] buffer, int offset, short value) {
        buffer[offset] = (byte) value;
        value >>>= 8;
        buffer[offset + 1] = (byte) value;
    }

    @PluginMethod
    public static long readLongB(byte[] buffer, int offset) {
        long val = buffer[offset++];
        val <<= 8;
        val = val | (0xFF & buffer[offset++]);
        val <<= 8;
        val = val | (0xFF & buffer[offset++]);
        val <<= 8;
        val = val | (0xFF & buffer[offset++]);
        val <<= 8;
        val = val | (0xFF & buffer[offset++]);
        val <<= 8;
        val = val | (0xFF & buffer[offset++]);
        val <<= 8;
        val = val | (0xFF & buffer[offset++]);
        val <<= 8;
        return val | (0xFF & buffer[offset]);
    }

    @PluginMethod
    public static long readLongL(byte[] buffer, int offset) {
        offset += 7;
        long val = buffer[offset--];
        val <<= 8;
        val = val | (0xFF & buffer[offset--]);
        val <<= 8;
        val = val | (0xFF & buffer[offset--]);
        val <<= 8;
        val = val | (0xFF & buffer[offset--]);
        val <<= 8;
        val = val | (0xFF & buffer[offset--]);
        val <<= 8;
        val = val | (0xFF & buffer[offset--]);
        val <<= 8;
        val = val | (0xFF & buffer[offset--]);
        val <<= 8;
        return val | (0xFF & buffer[offset]);
    }

    @PluginMethod
    public static int readIntB(byte[] buffer, int offset) {
        int val = buffer[offset++];
        val <<= 8;
        val = val | (0xFF & buffer[offset++]);
        val <<= 8;
        val = val | (0xFF & buffer[offset++]);
        val <<= 8;
        return val | (0xFF & buffer[offset]);
    }

    @PluginMethod
    public static int readIntL(byte[] buffer, int offset) {
        offset += 3;
        int val = buffer[offset--];
        val <<= 8;
        val = val | (0xFF & buffer[offset--]);
        val <<= 8;
        val = val | (0xFF & buffer[offset--]);
        val <<= 8;
        return val | (0xFF & buffer[offset]);
    }

    @PluginMethod
    public static short readShortB(byte[] buffer, int offset) {
        int val = buffer[offset++];
        val <<= 8;
        return (short) (val | (0xFF & buffer[offset]));
    }

    @PluginMethod
    public static short readShortL(byte[] buffer, int offset) {
        int val = buffer[offset+1];
        val <<= 8;
        return (short)(val | (0xFF & buffer[offset]));
    }

}
