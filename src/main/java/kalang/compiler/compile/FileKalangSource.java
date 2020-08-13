package kalang.compiler.compile;

import java.io.*;

/**
 * @author KasonYang
 */
public class FileKalangSource implements KalangSource {

    private String className;

    private File file;

    private boolean isScript;

    public FileKalangSource(String className, File file, boolean isScript) {
        this.className = className;
        this.file = file;
        this.isScript = isScript;
    }

    @Override
    public String getClassName() {
        return className;
    }

    @Override
    public InputStream createInputStream() throws IOException {
        return new FileInputStream(file);
    }

    @Override
    public String getFileName() {
        return file.getAbsolutePath();
    }

    @Override
    public boolean isScript() {
        return isScript;
    }

    public File getFile() {
        return file;
    }

}
