package kalang.compiler.util;

import lombok.SneakyThrows;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOCase;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 *
 * @author Kason Yang 
 */
public class FilePathUtil {

    public static boolean existFile(File srcFile) {
        String absPath = srcFile.getAbsolutePath();
        if (srcFile.exists()) {
            String canonicalPath;
            try {
                canonicalPath = srcFile.getCanonicalPath();
            } catch (IOException ex) {
                return false;
            }
            return FilenameUtils.equals(canonicalPath, absPath, true, IOCase.SENSITIVE);
        }
        return false;
    }

    @SneakyThrows
    public static URL toURL(File file) {
        return file.toURI().toURL();
    }
    
}
