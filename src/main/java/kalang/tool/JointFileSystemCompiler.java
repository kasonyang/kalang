package kalang.tool;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import kalang.ast.ClassNode;
import kalang.AstNotFoundException;
import kalang.compiler.CompilePhase;
import kalang.compiler.JavaAstLoader;
import kalang.compiler.KalangSource;
import kalang.java.MemoryCompiler;
import kalang.java.MemoryFileManager;
import kalang.java.StringJavaSource;
import kalang.java.StringJavaSourceBase;
import kalang.util.ClassNameUtil;
import kalang.util.FilePathUtil;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Kason Yang
 */
public class JointFileSystemCompiler extends FileSystemCompiler{
    
    final Map<String,JavaFileObject> javaFiles = new HashMap<>();
    
    final List<File> javaSourcePath = new LinkedList<>();
    
    final MemoryOutputManager javaStubManager = new MemoryOutputManager();
    private MemoryCompiler javaCompiler;
    
    public void addJavaSourcePath(File path){
        javaSourcePath.add(path);
    }
   
    public void addJavaSourceDir(File sourceDir) throws IOException {
        Collection<File> files = FileUtils.listFiles(sourceDir, new String[]{"java"}, true);
        if(files!=null){
            for(File f:files){
                addJavaSource(sourceDir, f);
            }
        }
    }
    
    public void addKalangOrJavaSource(File dir,File file) throws IOException{
        if(file.getName().endsWith(".java")){
            addJavaSource(dir, file);
        }else{
            addSource(dir, file);
        }
    }
    
    public void addKalangAndJavaSourceDir(File srcDir) throws IOException{
        addSourceDir(srcDir);
        addJavaSourceDir(srcDir);
    }
    
    public void addJavaSource(File srcDir,File file) throws IOException{
        String className = ClassNameUtil.getClassName(srcDir, file);
        javaFiles.put(className,StringJavaSource.loadFromFile(srcDir, file));
    }
    
    private ClassNode createMockClass(String className){
        ClassNode node = new ClassNode();
        node.name = className;
        return node;
    }

    @Override
    public ClassNode loadAst(String className) throws AstNotFoundException {
        //TODO here has a bug,when find a java class for compiling kalang
        try{
            return super.loadAst(className);
        }catch(AstNotFoundException ex){
            try {
                JavaFileObject js = loadJavaSource(className);
                if(js==null) throw ex;
                if(getCurrentCompilePhase()<CompilePhase.PHASE_BUILDAST){
                    return createMockClass(className);
                }
                if(javaCompiler==null) throw ex;
                JavaAstLoader javaAstLoader = new JavaAstLoader(javaCompiler);
                return javaAstLoader.loadAst(className);
            } catch (IOException ex1) {
                //TODO handle ex
                Logger.getLogger(JointFileSystemCompiler.class.getName()).log(Level.SEVERE, null, ex1);
                throw ex;
            }
        }
    }

    @Override
    public void compile() {
        generateJavaStub(javaStubManager);
        JointFileSystemCompiler that = this;
        javaCompiler = new MemoryCompiler(){
            @Override
            protected JavaFileObject loadJavaSource(String className) throws IOException {
                JavaFileObject js = super.loadJavaSource(className);
                if(js!=null){
                    return js;
                }
                return that.loadJavaSource(className);
            }

            @Override
            protected MemoryFileManager createFileManager(StandardJavaFileManager sfm) {
                MemoryFileManager superFm = super.createFileManager(sfm);
                return new MemoryFileManager(superFm){
                    @Override
                    public Iterable<JavaFileObject> list(JavaFileManager.Location location, String packageName, Set<JavaFileObject.Kind> kinds, boolean recurse) throws IOException {
                        Iterable<JavaFileObject> superList = super.list(location, packageName, kinds, recurse);
                        List<JavaFileObject> files = new LinkedList<>();
                        if(superList!=null){
                            superList.forEach(i -> files.add(i));
                        }
                        for(File p:JointFileSystemCompiler.this.sourcePaths){
                            File dir = packageName !=null && !packageName.isEmpty()
                        ? new File(p,packageName.replace('.', '/'))
                        : p;
                            if(dir.exists() && dir.isDirectory()){
                                Collection<File> klFiles = FileUtils.listFiles(dir, new String[]{"kl","kalang"}, recurse);
                                klFiles.forEach(f -> {
                                    String className = ClassNameUtil.getClassName(p, f);
                                    files.add(
                                        new StringJavaSourceBase(className){
                                            @Override
                                            protected CharSequence getContent() {
                                                try {
                                                    return loadJavaSource(className).getCharContent(true);
                                                } catch (IOException ex) {
                                                    //TODO handle ex
                                                    throw new RuntimeException(ex);
                                                }
                                            }
                                        }
                                    );
                                });
                            }
                        }
                        return files;
                    }
                    
                };
            }

        };
        for(URL p:classPaths){
            javaCompiler.addClassPath(p);
        }
        for(Map.Entry<String, JavaFileObject> e:javaFiles.entrySet()){
            //TODO handle ex
            javaCompiler.addSource(e.getValue());
        }
        String[] stubNames = javaStubManager.getClassNames();
        for(String n:stubNames){
            String code = new String(javaStubManager.getBytes(n));
            javaCompiler.addSourceFromString(n, code);
        }
        if(!javaCompiler.compile()){
            DiagnosticCollector<JavaFileObject> dc = javaCompiler.getDiagnosticCollector();
            for(Diagnostic<? extends JavaFileObject> d : dc.getDiagnostics()){
                handleJavaDiagnostic(d);
            }
            return;
        }
        Map<String, byte[]> bytes = javaCompiler.getFileManager().getBytes();
        OutputManager outManager = getOutputManager();
        if(bytes!=null && outManager!=null){
            for(Map.Entry<String, byte[]> e:bytes.entrySet()){
                OutputStream os;
                try {
                    os = outManager.createOutputStream(e.getKey());
                    os.write(e.getValue());
                    os.close();
                } catch (IOException ex) {
                    //TODO handle ex
                    throw new RuntimeException(ex);
                }
            }
        }
        getClassLoader().addClassLoader(javaCompiler);
        super.compile();
    }

    protected void handleJavaDiagnostic(Diagnostic<? extends JavaFileObject> d) {
        JavaFileObject source = d.getSource();
        if(source!=null){
            System.err.println(source.getName() + ":" + d.getLineNumber());
        }
        
        System.err.println(d.getKind() + ":" + d.getMessage(null));
    }
    
    @Nullable
    protected JavaFileObject loadJavaSource(String className) throws IOException{
        //System.out.println("try loading java source:" + className);
        if(javaFiles.containsKey(className)){
            return (javaFiles.get(className));
        }
        for(File p:javaSourcePath){
            if(!p.isDirectory()) continue;
            File f = new File(p,ClassNameUtil.getRelativePathOfClass(className, "java"));
            if(FilePathUtil.existFile(f)){
                StringJavaSource source = StringJavaSource.loadFromFile(p, f);
                javaFiles.put(className, source);
                return source;
            }
        }
        JavaFileObject js = getJavaStub(className);
        if(js!=null) return js;
        KalangSource klSource = getSourceLoader().loadSource(className);
        if(klSource != null){
            addSource(klSource);
            //TODO here may generate stub repeatly
            generateJavaStub(javaStubManager);
            return getJavaStub(className);
        }
        return null;
    }
    
    @Nullable
    protected JavaFileObject getJavaStub(String className){
        byte[] data = javaStubManager.getBytes(className);
        if(data==null) return null;
        String code = new String(data);
        return new StringJavaSource(className, code);
    }
    

}
