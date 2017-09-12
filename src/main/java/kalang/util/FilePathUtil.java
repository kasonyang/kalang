package kalang.util;

import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOCase;

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
