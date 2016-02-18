
package kalang.tool;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import kalang.compiler.SourceLoader;
import org.apache.commons.io.FileUtils;
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
    public String loadSource(String className) {
        String fn = className.replace(".", "/") + ".kl";
        File srcFile = new File(srcDir,fn);
        if(srcFile.exists()){
            try {
                return FileUtils.readFileToString(srcFile);
            } catch (IOException ex) {
                Logger.getLogger(FileSystemSourceLoader.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        return null;
    }

}
