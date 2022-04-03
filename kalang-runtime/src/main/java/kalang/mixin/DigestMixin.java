package kalang.mixin;

import kalang.annotation.MixinMethod;
import lombok.SneakyThrows;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestMixin {

    private static final String MD5 = "MD5";

    private static final String SHA1 = "SHA-1";

    private static final String SHA256 = "SHA-256";

    private static final String SHA512 = "SHA-512";

    @MixinMethod
    public static Digest digestBy(byte[] input, String algorithm) {
        return digestBytes(input, algorithm);
    }

    @MixinMethod
    public static Digest digestBy(String input, String algorithm) {
        return digestBytes(input.getBytes(StandardCharsets.UTF_8), algorithm);
    }

    @MixinMethod
    public static Digest digestBy(InputStream input, String algorithm) {
        return digestInputStream(input, algorithm);
    }

    @MixinMethod
    public static Digest digestBy(File input, String algorithm) throws IOException {
        try (InputStream is = new FileInputStream(input)) {
            return digestBy(is, algorithm);
        }
    }

    @Deprecated
    @MixinMethod
    public static String md5Hex(byte[] input) throws NoSuchAlgorithmException {
        return toHex(digest(input, MD5));
    }

    @Deprecated
    @MixinMethod
    public static String md5Hex(String input) throws NoSuchAlgorithmException {
        return md5Hex(strToBytes(input));
    }

    @Deprecated
    @MixinMethod
    public static byte[] md5(byte[] input) throws NoSuchAlgorithmException {
        return digest(input, MD5);
    }

    @Deprecated
    @MixinMethod
    public static byte[] md5(String input) throws NoSuchAlgorithmException {
        return md5(strToBytes(input));
    }

    @Deprecated
    @MixinMethod
    public static String sha1Hex(byte[] input) throws NoSuchAlgorithmException {
        return toHex(digest(input, SHA1));
    }

    @Deprecated
    @MixinMethod
    public static String sha1Hex(String input) throws NoSuchAlgorithmException {
        return sha1Hex(strToBytes(input));
    }

    @Deprecated
    @MixinMethod
    public static byte[] sha1(byte[] input) throws NoSuchAlgorithmException {
        return digest(input, SHA1);
    }

    @Deprecated
    @MixinMethod
    public static byte[] sha1(String input) throws NoSuchAlgorithmException {
        return sha1(strToBytes(input));
    }

    @Deprecated
    @MixinMethod
    public static String sha256Hex(byte[] input) throws NoSuchAlgorithmException {
        return toHex(digest(input, SHA256));
    }

    @Deprecated
    @MixinMethod
    public static String sha256Hex(String input) throws NoSuchAlgorithmException {
        return sha256Hex(strToBytes(input));
    }

    @Deprecated
    @MixinMethod
    public static byte[] sha256(byte[] input) throws NoSuchAlgorithmException {
        return digest(input, SHA256);
    }

    @Deprecated
    @MixinMethod
    public static byte[] sha256(String input) throws NoSuchAlgorithmException {
        return sha256(strToBytes(input));
    }

    @Deprecated
    @MixinMethod
    public static String sha512Hex(byte[] input) throws NoSuchAlgorithmException {
        return toHex(digest(input, SHA512));
    }

    @Deprecated
    @MixinMethod
    public static String sha512Hex(String input) throws NoSuchAlgorithmException {
        return sha512Hex(strToBytes(input));
    }

    @Deprecated
    @MixinMethod
    public static byte[] sha512(byte[] input) throws NoSuchAlgorithmException {
        return digest(input, SHA512);
    }

    @Deprecated
    @MixinMethod
    public static byte[] sha512(String input) throws NoSuchAlgorithmException {
        return sha512(strToBytes(input));
    }

    @Deprecated
    @MixinMethod
    public static byte[] digest(byte[] input, String algorithm) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(algorithm).digest(input);
    }

    @Deprecated
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

    public static class Digest {

        private byte[] result;

        private Digest(byte[] result) {
            this.result = result;
        }

        public String asHex() {
            return HexMixin.toHexString(result);
        }

        public byte[] asBytes() {
            return result;
        }

    }

    @SneakyThrows
    private static Digest digestInputStream(InputStream input, String algorithm) {
        MessageDigest md = getDigestInstance(algorithm);
        byte[] buff = new byte[1024];
        int len;
        while ((len = input.read(buff)) > -1) {
            md.update(buff, 0, len);
        }
        return new Digest(md.digest());
    }

    private static Digest digestBytes(byte[] input, String algorithm) {
        MessageDigest md = getDigestInstance(algorithm);
        return new Digest(md.digest(input));
    }

    private static MessageDigest getDigestInstance(String algorithm) {
        try {
            return MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
    }

}
