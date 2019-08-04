package kalang.helper;

import kalang.annotation.PluginMethod;

import java.io.*;
import java.nio.charset.Charset;

@Deprecated
public class FilePlugin {

    @PluginMethod
    public static byte[] readToBytes(File file) throws IOException {
        try(InputStream isr = new FileInputStream(file)) {
            long fileLen = file.length();
            if (fileLen > Integer.MAX_VALUE) {
                throw new OutOfMemoryError("file is too large");
            }
            int len = (int) fileLen;
            byte[] data = new byte[len];
            isr.read(data);
            return data;
        }
    }

    @PluginMethod
    public static String readToString(File file,String charset) throws IOException {
        return new String(readToBytes(file),charset);
    }

    @PluginMethod
    public static String readToString(File file) throws IOException {
        return readToString(file,Charset.defaultCharset().name());
    }

    @PluginMethod
    public static void write(File file,byte[] data) throws IOException {
        try(FileOutputStream fos = new FileOutputStream(file)){
            fos.write(data);
        }
    }

    @PluginMethod
    public static void append(File file,byte[] data) throws IOException {
        try(FileOutputStream fos = new FileOutputStream(file,true)){
            fos.write(data);
        }
    }

}
