package kalang.mixin;

import kalang.annotation.MixinMethod;

import java.io.*;
import java.nio.charset.Charset;

public class IOMixin {

    @MixinMethod
    public static byte[] readToBytes(InputStream is) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        readTo(is, bos);
        return bos.toByteArray();
    }

    @MixinMethod
    public static byte[] readToBytes(File file) throws IOException {
        long fileLen = file.length();
        if (fileLen > Integer.MAX_VALUE) {
            throw new OutOfMemoryError("file is too large");
        }
        try (InputStream isr = new FileInputStream(file)) {
            int len = (int) fileLen;
            byte[] data = new byte[len];
            isr.read(data);
            return data;
        }
    }

    @MixinMethod
    public static String readToString(InputStream is, String charset) throws IOException {
        return new String(readToBytes(is), charset);
    }

    @MixinMethod
    public static String readToString(File file, String charset) throws IOException {
        return new String(readToBytes(file), charset);
    }

    @MixinMethod
    public static String readToString(File file) throws IOException {
        return readToString(file, Charset.defaultCharset().name());
    }

    @MixinMethod
    public static void write(File file, byte[] data) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(data);
        }
    }

    @MixinMethod
    public static void append(File file, byte[] data) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(file, true)) {
            fos.write(data);
        }
    }

    @MixinMethod
    public static void readTo(InputStream is, OutputStream os) throws IOException {
        byte[] bs = new byte[4096];
        int len = 0;
        while ((len = is.read(bs)) > 0) {
            os.write(bs, 0, len);
        }
    }

    @MixinMethod
    public static void readTo(InputStream is, File destFile, boolean append) throws IOException {
        try (FileOutputStream os = new FileOutputStream(destFile, append)) {
            readTo(is, os);
        }
    }

    @MixinMethod
    public static void readTo(InputStream is, File destFile) throws IOException {
        readTo(is, destFile,false);
    }

    @MixinMethod
    public static void writeFrom(OutputStream os, InputStream is) throws IOException {
        readTo(is, os);
    }

    @MixinMethod
    public static void writeFrom(OutputStream os, File file) throws IOException {
        try (BufferedInputStream is = new BufferedInputStream(new FileInputStream(file))) {
            writeFrom(os, is);
        }
    }
    
}
