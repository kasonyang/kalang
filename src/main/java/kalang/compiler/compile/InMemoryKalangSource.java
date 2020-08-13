
package kalang.compiler.compile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 *
 * @author Kason Yang 
 */
public class InMemoryKalangSource implements KalangSource {


    private String className;

    private byte[] content;

    private String fileName;

    private boolean script;

    public InMemoryKalangSource(String className, byte[] content, String fileName, boolean script) {
        this.className = className;
        this.content = content;
        this.fileName = fileName;
        this.script = script;
    }

    @Override
    public String getClassName() {
        return className;
    }

    @Override
    public InputStream createInputStream() {
        return new ByteArrayInputStream(content);
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public boolean isScript() {
        return script;
    }

}
