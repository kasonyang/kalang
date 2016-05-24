package kalang.java;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.tools.FileObject;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import kalang.tool.JointFileSystemCompiler;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Kason Yang <im@kasonyang.com>
 */
public class FileSystemFileManager implements JavaFileManager{
    
    protected JavaFileManager fm;
    
    protected final List<File> sourcePaths = new LinkedList();

    public FileSystemFileManager(JavaFileManager fm) {
        this.fm = fm;
    }
    
    public void addSourcePath(File path){
        sourcePaths.add(path);
    }
    
    @Override
    public boolean hasLocation(Location location) {
        return fm.hasLocation(location)
                ||  (location == StandardLocation.SOURCE_PATH && sourcePaths.size() > 0);
    }

    @Override
    public Iterable<JavaFileObject> list(Location location, String packageName, Set<JavaFileObject.Kind> kinds, boolean recurse) throws IOException {
        Iterable<JavaFileObject> superList = fm.list(location, packageName, kinds, recurse);
        if(location==StandardLocation.SOURCE_PATH){
            List<JavaFileObject> list = new LinkedList<>();
            for(File p:sourcePaths){
                Collection<File> files = FileUtils.listFiles(p, new String[]{"java"}, recurse);
                if(files!=null) for(File f:files) list.add(StringJavaSource.loadFromFile(p,f));
            }
            if(superList!=null){
                superList.forEach(i -> list.add(i));
            }
            return list;
        }else{
            return superList;
        }
    }

    @Override
    public String inferBinaryName(Location location, JavaFileObject file) {
        if(file instanceof MemoryJavaSource){
            return ((MemoryJavaSource)file).getClassName();
        }else{
            return fm.inferBinaryName(location, file);
        }
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
    public ClassLoader getClassLoader(Location location) {
        return fm.getClassLoader(location);
    }

    @Override
    public JavaFileObject getJavaFileForInput(Location location, String className, JavaFileObject.Kind kind) throws IOException {
        return fm.getJavaFileForInput(location, className, kind);
    }

    @Override
    public JavaFileObject getJavaFileForOutput(Location location, String className, JavaFileObject.Kind kind, FileObject sibling) throws IOException {
        return fm.getJavaFileForOutput(location, className, kind, sibling);
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

}
