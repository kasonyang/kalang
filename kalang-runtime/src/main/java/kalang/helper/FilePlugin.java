package kalang.helper;

import kalang.annotation.Nullable;
import kalang.annotation.PluginMethod;

import java.io.*;

public class FilePlugin {

    public static String DEFAULT_ENCODING = "utf-8";

    @PluginMethod
    public static String readToString(File file, @Nullable String charset) throws IOException {
        try(InputStream isr = new FileInputStream(file)) {
            long fileLen = file.length();
            if (fileLen > Integer.MAX_VALUE) {
                throw new OutOfMemoryError("file is too large");
            }
            int len = (int) fileLen;
            byte[] data = new byte[len];
            isr.read(data);
            return new String(data, charset);
        }
    }

    @PluginMethod
    public static String readToString(File file) throws IOException {
        return readToString(file, DEFAULT_ENCODING);
    }

    @PluginMethod
    public static void write(File file, String data, @Nullable String charset,boolean append) throws IOException {
        try(FileOutputStream fos = new FileOutputStream(file,append)){
            fos.write(data.getBytes(charset));
        }
    }

    @PluginMethod
    public static void write(File file, String data, @Nullable String charset) throws IOException {
        write(file,data,charset,false);
    }

    @PluginMethod
    public static void write(File file, String data) throws IOException {
        write(file, data, DEFAULT_ENCODING);
    }

}
