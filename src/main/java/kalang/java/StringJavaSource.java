package kalang.java;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import kalang.util.ClassNameUtil;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Kason Yang 
 */
public class StringJavaSource extends MemoryJavaSource {

    private final String content;

    public StringJavaSource(String className, String content) {
        super(URI.create(className.replace(".", "/") + ".java"), JavaFileObject.Kind.SOURCE,className);
        this.content = content;
    }

    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
        return content;
    }
    
    public static StringJavaSource loadFromFile(File root,File file) throws IOException{
        String clsName = ClassNameUtil.getClassName(root, file);
        return new StringJavaSource(clsName, FileUtils.readFileToString(file, "utf-8"));
    }

}
