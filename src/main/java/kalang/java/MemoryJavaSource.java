package kalang.java;

import java.net.URI;
import javax.tools.SimpleJavaFileObject;

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
