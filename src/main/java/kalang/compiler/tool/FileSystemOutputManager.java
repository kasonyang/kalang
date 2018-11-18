package kalang.compiler.tool;

import kalang.compiler.util.ClassNameUtil;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author Kason Yang 
 */
public class FileSystemOutputManager implements OutputManager{
    
    File outputDir;
    
    String extention;

    public FileSystemOutputManager(File outputDir, String extention) {
        this.outputDir = outputDir;
        this.extention = extention;
    }

    @Override
    public OutputStream createOutputStream(String className) throws IOException{
        String relativePath = ClassNameUtil.getRelativePathOfClass(className, extention);
        File outputFile = new File(outputDir,relativePath);
        return FileUtils.openOutputStream(outputFile, false);
    }

}
