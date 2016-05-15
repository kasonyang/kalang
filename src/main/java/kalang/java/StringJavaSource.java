package kalang.java;

import java.io.IOException;
import java.net.URI;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;

/**
 *
 * @author Kason Yang <im@kasonyang.com>
 */
public class StringJavaSource extends SimpleJavaFileObject {

    private final String content;

    public StringJavaSource(String className, String content) {
        super(URI.create(className.replace(".", "/") + ".java"), JavaFileObject.Kind.SOURCE);
        this.content = content;
    }

    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
        return content;
    }

}
