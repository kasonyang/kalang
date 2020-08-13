
package kalang.compiler.util;

import kalang.annotation.Nullable;
import kalang.compiler.compile.FileKalangSource;
import kalang.compiler.compile.KalangSource;

import java.io.File;
/**
 *
 * @author Kason Yang 
 */
public class KalangSourceUtil {

    public static KalangSource create(File dir,File sourceFile) {
        String clsName = ClassNameUtil.getClassName(dir, sourceFile);
        boolean script = isScriptFile(sourceFile.getName());
        return new FileKalangSource(clsName,sourceFile, script);
    }

    public static boolean isScriptFile(@Nullable String fileName) {
        if (fileName == null) {
            return false;
        }
        for (String ext : KalangSource.EXTENSION_SCRIPT) {
            if (fileName.endsWith("." + ext)) {
                return true;
            }
        }
        return false;
    }

}
