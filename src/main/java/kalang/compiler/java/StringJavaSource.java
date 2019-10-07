package kalang.compiler.java;

import kalang.compiler.util.ClassNameUtil;
import org.apache.commons.io.FileUtils;

import javax.tools.JavaFileObject;
import java.io.File;
import java.io.IOException;
import java.net.URI;

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
    public CharSequence getCharContent(boolean ignoreEncodingErrors) {
        return content;
    }
    
    public static StringJavaSource loadFromFile(File root,File file) throws IOException{
        String clsName = ClassNameUtil.getClassName(root, file);
        return new StringJavaSource(clsName, FileUtils.readFileToString(file, "utf-8"));
    }

}
