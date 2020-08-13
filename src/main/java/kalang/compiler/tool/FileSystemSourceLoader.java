
package kalang.compiler.tool;

import kalang.compiler.compile.KalangSource;
import kalang.compiler.compile.SourceLoader;
import kalang.compiler.util.FilePathUtil;
import kalang.compiler.util.KalangSourceUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  The class load source from file system.
 * @author Kason Yang 
 */
public class FileSystemSourceLoader implements SourceLoader {

    private final List<File> srcDirs = new ArrayList<>();
    
    private final List<String> extensions = new ArrayList<>();

    private final String encoding;
    
    public FileSystemSourceLoader(File[] srcDir, String[] extensions, String encoding) {
        this.srcDirs.addAll(Arrays.asList(srcDir));
        this.extensions.addAll(Arrays.asList(extensions));
        this.encoding = encoding;
    }
    
    public void addSourceDir(File dir){
        srcDirs.add(dir);
    }
    
    public void addExtention(String ext){
        extensions.add(ext);
    }
    
    @Override
    public KalangSource loadSource(String className) {
        for(String e: extensions){
            String fn = className.replace(".", "/") + "." + e;
            for(File s:srcDirs){
                File srcFile = new File(s,fn);
                if(FilePathUtil.existFile(srcFile)){
                    return KalangSourceUtil.create(s, srcFile);
                }
            }
        }
        return null;
    }

}
