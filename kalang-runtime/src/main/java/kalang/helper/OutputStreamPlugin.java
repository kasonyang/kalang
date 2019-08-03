package kalang.helper;


import kalang.annotation.PluginMethod;

import java.io.*;

/**
 * @author lbqh
 */
public class OutputStreamPlugin {

    @PluginMethod
    public static void writeFrom(OutputStream os, InputStream is) throws IOException {
        InputStreamPlugin.writeTo(is, os);
    }

    @PluginMethod
    public static void writeFrom(OutputStream os, File file) throws IOException {
        try (BufferedInputStream is = new BufferedInputStream(new FileInputStream(file))) {
            writeFrom(os, is);
        }

    }

}
