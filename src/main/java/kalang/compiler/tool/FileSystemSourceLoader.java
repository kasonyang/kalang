
package kalang.compiler.tool;

import kalang.compiler.compile.KalangSource;
import kalang.compiler.compile.SourceLoader;
import kalang.compiler.util.FilePathUtil;
import kalang.compiler.util.KalangSourceUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  The class load source from file system.
 * @author Kason Yang 
 */
public class FileSystemSourceLoader implements SourceLoader {

    private final List<File> srcDirs = new ArrayList<>();
    
    private final List<String> extentions = new ArrayList<>();
    
    public FileSystemSourceLoader(File[] srcDir,String[] extentions) {
        this.srcDirs.addAll(Arrays.asList(srcDir));
        this.extentions.addAll(Arrays.asList(extentions));
    }
    
    public void addSourceDir(File dir){
        srcDirs.add(dir);
    }
    
    public void addExtention(String ext){
        extentions.add(ext);
    }
    
    @Override
    public KalangSource loadSource(String className) {
        for(String e:extentions){
            String fn = className.replace(".", "/") + "." + e;
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
        }
        return null;
    }

}
