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
        return md5Hex(strToBytes(input));
    }

    @MixinMethod
    public static byte[] md5(byte[] input) throws NoSuchAlgorithmException {
        return digest(input, MD5);
    }

    @MixinMethod
    public static byte[] md5(String input) throws NoSuchAlgorithmException {
        return md5(strToBytes(input));
    }

    @MixinMethod
    public static String sha1Hex(byte[] input) throws NoSuchAlgorithmException {
        return toHex(digest(input, SHA1));
    }

    @MixinMethod
    public static String sha1Hex(String input) throws NoSuchAlgorithmException {
        return sha1Hex(strToBytes(input));
    }

    @MixinMethod
    public static byte[] sha1(byte[] input) throws NoSuchAlgorithmException {
        return digest(input, SHA1);
    }

    @MixinMethod
    public static byte[] sha1(String input) throws NoSuchAlgorithmException {
        return sha1(strToBytes(input));
    }

    @MixinMethod
    public static String sha256Hex(byte[] input) throws NoSuchAlgorithmException {
        return toHex(digest(input, SHA256));
    }

    @MixinMethod
    public static String sha256Hex(String input) throws NoSuchAlgorithmException {
        return sha256Hex(strToBytes(input));
    }

    @MixinMethod
    public static byte[] sha256(byte[] input) throws NoSuchAlgorithmException {
        return digest(input, SHA256);
    }

    @MixinMethod
    public static byte[] sha256(String input) throws NoSuchAlgorithmException {
        return sha256(strToBytes(input));
    }

    @MixinMethod
    public static String sha512Hex(byte[] input) throws NoSuchAlgorithmException {
        return toHex(digest(input, SHA512));
    }

    @MixinMethod
    public static String sha512Hex(String input) throws NoSuchAlgorithmException {
        return sha512Hex(strToBytes(input));
    }

    @MixinMethod
    public static byte[] sha512(byte[] input) throws NoSuchAlgorithmException {
        return digest(input, SHA512);
    }

    @MixinMethod
    public static byte[] sha512(String input) throws NoSuchAlgorithmException {
        return sha512(strToBytes(input));
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
        return HexMixin.toHexString(bytes);
    }

    private static byte[] strToBytes(String str) {
        return str.getBytes(StandardCharsets.UTF_8);
    }

}
