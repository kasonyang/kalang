package kalang.java;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import kalang.util.ClassNameUtil;
import kalang.util.FilePathUtil;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Kason Yang
 */
public class MemoryCompiler extends ClassLoader{
    
    protected final List<JavaFileObject> sources = new LinkedList<>();    
    protected final List<URL> classPaths = new LinkedList<>();
    
    protected MemoryFileManager fileManager;
    
    private  DiagnosticCollector<JavaFileObject> diagnosticCollector = new DiagnosticCollector<>();
    
    protected final List<File> sourcePaths = new LinkedList<>();
    private final JavaCompiler compiler;

    public MemoryCompiler() {
        compiler = ToolProvider.getSystemJavaCompiler();
    }
    
    public void addSourcePath(File path){
        sourcePaths.add(path);
    }
    
    public void addSourceFromFile(String className,File file) throws IOException{
        addSourceFromString(className, FileUtils.readFileToString(file, "utf-8"));
    }
    
    public void addSourceFromFile(File root,File file) throws IOException{
        String className = ClassNameUtil.getClassName(root, file);
        addSourceFromFile(className, file);
    }
    
    public void addSourceFromString(String className,String content){
        SimpleJavaFileObject s =new StringJavaSource(className,content);
        sources.add(s);
    }
    
    protected boolean compile(Collection<JavaFileObject> javaFileObjects){
        StandardJavaFileManager sfm = compiler.getStandardFileManager(null, null, null);
        fileManager = createFileManager(sfm);
        List<String> options = new LinkedList<>();
        String classPath = buildClassPathOption();
        if(classPath!=null && !classPath.isEmpty()){
            options.add("-classpath");
            options.add(classPath);
        }
        diagnosticCollector = new DiagnosticCollector();
        CompilationTask task = compiler.getTask(null, fileManager, diagnosticCollector,options, null, javaFileObjects);
        return task.call();
    }

    public  boolean compile() {
        return compile(sources);
    }
    
    protected MemoryFileManager createFileManager(StandardJavaFileManager sfm){
        FileSystemFileManager fsfm = new FileSystemFileManager(sfm);
        sourcePaths.forEach(p -> fsfm.addSourcePath(p));
        return new MemoryFileManager(fsfm);
    }
    
    protected JavaFileObject loadJavaSource(String className) throws IOException{
        String relativePath = ClassNameUtil.getRelativePathOfClass(className, "java");
        for(File p:sourcePaths){
            File sf = new File(p,relativePath);
            if(FilePathUtil.existFile(sf)){
                return new StringJavaSource(className, FileUtils.readFileToString(sf,"utf-8"));
            }
        }
        return null;
    }

    @Nullable
    public MemoryFileManager getFileManager() {
        return fileManager;
    }

    public DiagnosticCollector<JavaFileObject> getDiagnosticCollector() {
        return diagnosticCollector;
    }
    
    public void printDiagnostic(){
        //TODO modify diagnostic 
        if (diagnosticCollector != null) {
            for (Diagnostic<? extends JavaFileObject> d : diagnosticCollector.getDiagnostics()) {
                JavaFileObject source = d.getSource();
                if (source != null) {
                    System.err.println(source.getName() + ":" + d.getLineNumber());
                }
                System.err.println(d.getKind() + ":" + d.getMessage(null));
            }
        }
    }
    
    public void writeClassesToFile(File outputDir) throws IOException{
        if(fileManager!=null){
            for(Map.Entry<String, byte[]> e:fileManager.getBytes().entrySet()){
                String clsName = e.getKey();
                byte[] data = e.getValue();
                String relativePath = ClassNameUtil.getRelativePathOfClass(clsName, "class");
                File of = new File(outputDir,relativePath);
                FileUtils.writeByteArrayToFile(of, data, false);
            }
        }
    }
    
    protected Class getLoadedClass(String name){
         if(fileManager!=null){
            Map<String, byte[]> bs = fileManager.getBytes();
            if(bs!=null){
                byte[] data = bs.get(name);
                if(data!=null){
                    return defineClass(name, data,0,data.length);
                }
            }
         }
         return null;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz = getLoadedClass(name);
        if(clazz==null){
            JavaFileObject source;
            try {
                source = loadJavaSource(name);
            } catch (IOException ex) {
                source = null;
            }
            if(source!=null){
                //TODO here may modify diagnotisc
                if(!compile(Collections.singleton(source))){
                    printDiagnostic();
                }
                clazz = getLoadedClass(name);
            }
        }
        if(clazz!=null) return clazz;
        //TODO set classLoader
        return super.findClass(name);
    }
    
    protected String buildClassPathOption(){
        List<String> paths = new ArrayList<>(classPaths.size());
        for(URL cp:classPaths){
            try {
                paths.add(new File(cp.toURI()).getAbsolutePath());
            } catch (URISyntaxException ex) {
                Logger.getLogger(MemoryCompiler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return String.join(";", paths);
    }
    
    public void addClassPath(URL path){
        classPaths.add(path);
    }

    public void addSource(JavaFileObject value) {
        sources.add(value);
    }
    
}

