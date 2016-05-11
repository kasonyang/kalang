package kalang.java;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import javax.tools.FileObject;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;

/**
 *
 * @author Kason Yang <im@kasonyang.com>
 */
public class MyFileManager implements JavaFileManager{

    @Override
    public ClassLoader getClassLoader(Location location) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterable<JavaFileObject> list(Location location, String packageName, Set<JavaFileObject.Kind> kinds, boolean recurse) throws IOException {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String inferBinaryName(Location location, JavaFileObject file) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isSameFile(FileObject a, FileObject b) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean handleOption(String current, Iterator<String> remaining) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean hasLocation(Location location) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JavaFileObject getJavaFileForInput(Location location, String className, JavaFileObject.Kind kind) throws IOException {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JavaFileObject getJavaFileForOutput(Location location, String className, JavaFileObject.Kind kind, FileObject sibling) throws IOException {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public FileObject getFileForInput(Location location, String packageName, String relativeName) throws IOException {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public FileObject getFileForOutput(Location location, String packageName, String relativeName, FileObject sibling) throws IOException {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void flush() throws IOException {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void close() throws IOException {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int isSupportedOption(String option) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
