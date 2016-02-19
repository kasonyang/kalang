
package kalang.util;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import org.apache.commons.io.FilenameUtils;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class ClassNameUtil {
    
    public static String getClassName(File dir,File file){
        String dirPath = FilenameUtils.normalizeNoEndSeparator(dir.getAbsolutePath());
        String fname =FilenameUtils.normalizeNoEndSeparator(file.getAbsolutePath());
        String ext = FilenameUtils.getExtension(fname);
        String clsName = fname.substring(dirPath.length() + 1, fname.length() - ext.length()+1).replace(File.separator, ".");
        return clsName;
    }

}
