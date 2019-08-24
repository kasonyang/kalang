package kalang.mixin;

import kalang.annotation.MixinMethod;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestMixin {

    private static final String MD5 = "MD5";

    private static final String SHA1 = "SHA-1";

    private static final String SHA256 = "SHA-256";

    private static final String SHA512 = "SHA-512";


    @MixinMethod
    public static String md5Hex(byte[] input) throws NoSuchAlgorithmException {
        return toHex(digest(input, MD5));
    }

    @MixinMethod
    public static String md5Hex(String input) throws NoSuchAlgorithmException {
        return md5Hex(input.getBytes(StandardCharsets.UTF_8));
    }

    @MixinMethod
    public static String sha1Hex(byte[] input) throws NoSuchAlgorithmException {
        return toHex(digest(input, SHA1));
    }

    @MixinMethod
    public static String sha1Hex(String input) throws NoSuchAlgorithmException {
        return sha1Hex(input.getBytes(StandardCharsets.UTF_8));
    }

    @MixinMethod
    public static String sha256Hex(byte[] input) throws NoSuchAlgorithmException {
        return toHex(digest(input, SHA256));
    }

    @MixinMethod
    public static String sha256Hex(String input) throws NoSuchAlgorithmException {
        return sha256Hex(input.getBytes(StandardCharsets.UTF_8));
    }

    @MixinMethod
    public static String sha512Hex(byte[] input) throws NoSuchAlgorithmException {
        return toHex(digest(input, SHA512));
    }

    @MixinMethod
    public static String sha512Hex(String input) throws NoSuchAlgorithmException {
        return sha512Hex(input.getBytes(StandardCharsets.UTF_8));
    }

    @MixinMethod
    public static byte[] digest(byte[] input, String algorithm) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(algorithm).digest(input);
    }

    @MixinMethod
    public static String digestHex(byte[] input, String algorithm) throws NoSuchAlgorithmException {
        return toHex(digest(input, algorithm));
    }

    private static String toHex(byte[] bytes) {
        char[] digits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] chars = new char[bytes.length << 1];
        int ci = 0;
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            chars[ci++] = digits[(b & 0xF0) >>> 4];
            chars[ci++] = digits[b & 0xF];
        }
        return new String(chars);
    }

}
