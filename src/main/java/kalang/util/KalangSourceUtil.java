
package kalang.util;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import kalang.compiler.KalangSource;
import org.apache.commons.io.FileUtils;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class KalangSourceUtil {
    public static KalangSource create(File dir,File sourceFile) throws IOException{
        String clsName = ClassNameUtil.getClassName(dir, sourceFile);
        KalangSource ks = new KalangSource(clsName,FileUtils.readFileToString(sourceFile),sourceFile.getName());
        return ks;        
    }
}
