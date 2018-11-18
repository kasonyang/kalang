package kalang.compiler.util;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOCase;

import java.io.File;
import java.io.IOException;

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
    
}
