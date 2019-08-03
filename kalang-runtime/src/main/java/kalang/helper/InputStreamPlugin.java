package kalang.helper;

import kalang.annotation.PluginMethod;

import java.io.*;

/**
 * @author lbqh
 */
public class InputStreamPlugin {

    @PluginMethod
    public static void writeTo(InputStream is, OutputStream os) throws IOException {
        byte[] bs = new byte[4096];
        int len = 0;
        while ((len = is.read(bs)) > 0) {
            os.write(bs, 0, len);
        }
    }

    @PluginMethod
    public static void writeTo(InputStream is, File destFile, boolean append) throws IOException {
        try (FileOutputStream os = new FileOutputStream(destFile, append)) {
            writeTo(is, os);
        }
    }

    @PluginMethod
    public static void writeTo(InputStream is, File destFile) {
        writeTo(is, destFile);
    }

}
