
package kalang.compiler.util;

import kalang.compiler.compile.KalangSource;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
/**
 *
 * @author Kason Yang 
 */
public class KalangSourceUtil {
    public static KalangSource create(File dir,File sourceFile) throws IOException{
        String clsName = ClassNameUtil.getClassName(dir, sourceFile);
        KalangSource ks = new KalangSource(clsName,FileUtils.readFileToString(sourceFile),sourceFile.getName());
        return ks;        
    }
}
