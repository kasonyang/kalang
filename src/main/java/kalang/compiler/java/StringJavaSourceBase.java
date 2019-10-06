package kalang.compiler.java;

import javax.tools.JavaFileObject;
import java.net.URI;

/**
 *
 * @author Kason Yang
 */
public abstract class StringJavaSourceBase extends MemoryJavaSource{

    public StringJavaSourceBase(String className) {
        super(URI.create(className.replace('.', '/') + ".java"), JavaFileObject.Kind.SOURCE, className);
    }

    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors) {
        return getContent();
    }

    protected abstract CharSequence getContent();    

}
