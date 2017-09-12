package kalang.tool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import kalang.util.ClassNameUtil;
import org.apache.commons.io.FileUtils;

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
