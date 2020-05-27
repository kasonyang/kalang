package kalang.mixin;


import java.io.*;
import java.util.Properties;

/**
 * @author KasonYang
 */
public class PropertiesMixin {

    public static Properties loadProperties(InputStream inputStream) throws IOException {
        Properties props = new Properties();
        props.load(inputStream);
        return props;
    }

    public static Properties loadProperties(File file) throws IOException {
        try (FileInputStream fis = new FileInputStream(file)) {
            return loadProperties(fis);
        }
    }

}
