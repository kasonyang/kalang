package kalang.mixin;

import kalang.annotation.MixinMethod;

public class HexMixin {

    private  static char[] DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    @MixinMethod
    public static String toHexString(byte[] bytes) {
        return toHexString(bytes, 0, bytes.length);
    }

    @MixinMethod
    public static String toHexString(byte[] bytes, int offset, int len) {
        char[] chars = new char[len << 1];
        int ci = 0;
        int end = offset + len;
        for (int i = offset; i < end; i++) {
            byte b = bytes[i];
            chars[ci++] = DIGITS[(b & 0xF0) >>> 4];
            chars[ci++] = DIGITS[b & 0xF];
        }
        return new String(chars);
    }


}
