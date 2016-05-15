package kalang.tool;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaFileObject;
import kalang.ast.ClassNode;
import kalang.AstNotFoundException;
import kalang.java.MemoryCompiler;
import kalang.java.MemoryFileManager;
import kalang.util.ClassNameUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Kason Yang <im@kasonyang.com>
 */
public class JointFileSystemCompiler extends FileSystemCompiler{
    
    final Map<String,File> javaFiles = new HashMap<>();
   
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
    
    public void addJavaSource(File srcDir,File file){
        String className = ClassNameUtil.getClassName(srcDir, file);
        javaFiles.put(className,file);
    }
    
    private ClassNode createMockClass(String className){
        ClassNode node = new ClassNode();
        node.name = className;
        return node;
    }

    @Override
    protected ClassNode findAst(String className) throws AstNotFoundException {
        try{
            return super.findAst(className);
        }catch(AstNotFoundException ex){
            if(javaFiles.containsKey(className)){
                return createMockClass(className);
            }
            throw ex;
        }
    }
    
    

    @Override
    public void compile() {
        MemoryOutputManager om = new MemoryOutputManager();
        generateJavaStub(om);
        MemoryCompiler javaCompiler = new MemoryCompiler();
        for(File f:javaFiles.values()){
            javaCompiler.addSourceFromFile(f);
        }
        String[] stubNames = om.getClassNames();
        for(String n:stubNames){
            String code = new String(om.getBytes(n));
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
        classLoader.addClassLoader(javaCompiler);
        super.compile();
    }

    protected void handleJavaDiagnostic(Diagnostic<? extends JavaFileObject> d) {
        JavaFileObject source = d.getSource();
        if(source!=null){
            System.err.println(source.getName() + ":" + d.getLineNumber());
        }
        
        System.err.println(d.getKind() + ":" + d.getMessage(null));
    }
    
    

}
