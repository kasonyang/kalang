package kalang.java;

import java.io.File;
import java.io.IOException;
import javax.tools.SimpleJavaFileObject;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Kason Yang <im@kasonyang.com>
 */
public class FileJavaSource extends SimpleJavaFileObject {

    private final File file;

    public FileJavaSource(File file) {
        super(file.toURI(), SimpleJavaFileObject.Kind.SOURCE);
        this.file = file;
    }

    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
        return FileUtils.readFileToString(file, "utf-8");
    }
}
