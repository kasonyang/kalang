package kalang.java;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.tools.FileObject;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;

/**
 *
 * @author Kason Yang <im@kasonyang.com>
 */
public class MemoryFileManager implements JavaFileManager{
    
    protected JavaFileManager fm;
    
    protected Map<String,ByteArrayOutputStream> opss = new HashMap<>();

    public MemoryFileManager(JavaFileManager fm) {
        this.fm = fm;
    }

    @Override
    public ClassLoader getClassLoader(Location location) {
        return fm.getClassLoader(location);
    }

    @Override
    public Iterable<JavaFileObject> list(Location location, String packageName, Set<JavaFileObject.Kind> kinds, boolean recurse) throws IOException {
        return fm.list(location, packageName, kinds, recurse);
    }

    @Override
    public String inferBinaryName(Location location, JavaFileObject file) {
        return fm.inferBinaryName(location, file);
    }

    @Override
    public boolean isSameFile(FileObject a, FileObject b) {
        return fm.isSameFile(a, b);
    }

    @Override
    public boolean handleOption(String current, Iterator<String> remaining) {
        return fm.handleOption(current, remaining);
    }

    @Override
    public boolean hasLocation(Location location) {
        return fm.hasLocation(location);
    }

    @Override
    public JavaFileObject getJavaFileForInput(Location location, String className, JavaFileObject.Kind kind) throws IOException {
        return fm.getJavaFileForInput(location, className, kind);
    }

    @Override
    public JavaFileObject getJavaFileForOutput(Location location, String className, JavaFileObject.Kind kind, FileObject sibling) throws IOException {
        return new SimpleJavaFileObject(URI.create(location.getName()),JavaFileObject.Kind.CLASS){
            @Override
            public OutputStream openOutputStream() throws IOException {
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                opss.put(className, os);
                return os;
            }
        };
    }

    @Override
    public FileObject getFileForInput(Location location, String packageName, String relativeName) throws IOException {
        return fm.getFileForInput(location, packageName, relativeName);
    }

    @Override
    public FileObject getFileForOutput(Location location, String packageName, String relativeName, FileObject sibling) throws IOException {
        return fm.getFileForOutput(location, packageName, relativeName, sibling);
    }

    @Override
    public void flush() throws IOException {
        fm.flush();
    }

    @Override
    public void close() throws IOException {
        fm.close();
    }

    @Override
    public int isSupportedOption(String option) {
        return fm.isSupportedOption(option);
    }
    
    public Map<String,byte[]> getBytes(){
        Map<String,byte[]> result = new HashMap();
        for(Map.Entry<String, ByteArrayOutputStream> o:opss.entrySet()){
            result.put(o.getKey(), o.getValue().toByteArray());
        }
        return result;
    }

}
