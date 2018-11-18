package kalang.compiler.java;

import javax.tools.SimpleJavaFileObject;
import java.net.URI;

/**
 *
 * @author Kason Yang
 */
public abstract class MemoryJavaSource extends SimpleJavaFileObject{
    
    protected final String className;

    public MemoryJavaSource(URI uri, Kind kind,String className) {
        super(uri, kind);
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

}
