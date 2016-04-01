
package kalang.tool;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import kalang.compiler.KalangSource;
import kalang.compiler.SourceLoader;
import kalang.util.FilePathUtil;
import kalang.util.KalangSourceUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOCase;
/**
 *  The class load source from file system.
 * @author Kason Yang <i@kasonyang.com>
 */
class FileSystemSourceLoader implements SourceLoader {

    private final File srcDir;
    
    FileSystemSourceLoader(File srcDir) {
        this.srcDir = srcDir;
    }
    
    @Override
    public KalangSource loadSource(String className) {
        String fn = className.replace(".", "/") + ".kl";
        File srcFile = new File(srcDir,fn);
        if(FilePathUtil.existFile(srcFile)){
            try {
                return KalangSourceUtil.create(srcDir,srcFile);
            } catch (IOException ex) {
                Logger.getLogger(FileSystemSourceLoader.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        return null;
    }

}
