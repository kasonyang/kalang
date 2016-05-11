package kalang.tool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import kalang.util.ClassNameUtil;

/**
 *
 * @author Kason Yang <im@kasonyang.com>
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
        return new FileOutputStream(new File(outputDir,relativePath));
    }

}
