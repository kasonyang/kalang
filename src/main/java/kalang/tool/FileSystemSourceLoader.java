
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
public class FileSystemSourceLoader implements SourceLoader {

    private final List<File> srcDirs = new ArrayList<>();

    public FileSystemSourceLoader() {
    }
    
    public FileSystemSourceLoader(File[] srcDir) {
        this.srcDirs.addAll(Arrays.asList(srcDir));
    }
    
    public void addSourceDir(File dir){
        srcDirs.add(dir);
    }
    
    @Override
    public KalangSource loadSource(String className) {
        String fn = className.replace(".", "/") + ".kl";
        for(File s:srcDirs){
            File srcFile = new File(s,fn);
            if(FilePathUtil.existFile(srcFile)){
                try {
                    return KalangSourceUtil.create(s,srcFile);
                } catch (IOException ex) {
                    Logger.getLogger(FileSystemSourceLoader.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                }
            }
        }
        return null;
    }

}
