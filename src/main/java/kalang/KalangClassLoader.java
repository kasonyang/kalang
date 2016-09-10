
package kalang;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import kalang.ast.ClassNode;
import kalang.compiler.codegen.Ast2Class;
import kalang.compiler.CodeGenerator;
import kalang.compiler.CompilationUnit;
import kalang.compiler.KalangCompiler;
import kalang.compiler.KalangSource;
import kalang.compiler.SourceLoader;
import kalang.tool.FileSystemSourceLoader;
import kalang.tool.MemoryOutputManager;
import kalang.tool.OutputManager;
import org.apache.commons.io.FileUtils;
/**
 *
 * @author Kason Yang
 */
public class KalangClassLoader extends URLClassLoader implements CodeGenerator{

    private final KalangCompiler compiler;
    
    private final HashMap<String,Class> loadedClasses = new HashMap<>();
    private final FileSystemSourceLoader sourceLoader;
    private final MemoryOutputManager outputManager = new MemoryOutputManager();

    public KalangClassLoader() {
        this(new File[0]);
    }

    public KalangClassLoader(File[] sourceDir) {
        super(new URL[0]);
        sourceLoader = new FileSystemSourceLoader(sourceDir,new String[]{"kl","kalang"});
        CodeGenerator cg = this;
        compiler = new KalangCompiler(){
            @Override
            public SourceLoader getSourceLoader() {
                return sourceLoader;
            }

            @Override
            public CodeGenerator createCodeGenerator(CompilationUnit compilationUnit) {
                return cg;
            }
            
        };
    }
    
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz = loadedClasses.get(name);
        if(clazz!=null) return clazz;
        KalangSource src = sourceLoader.loadSource(name);
        if(src!=null){
            compiler.addSource(src);
            compiler.compile();
        }
        clazz = loadedClasses.get(name);
        if(clazz!=null) return clazz;
        return super.findClass(name);
    }

    @Override
    public void generate(ClassNode classNode) {
        Ast2Class ast2Class = new Ast2Class(this.outputManager);
        ast2Class.generate(classNode);
        String name = classNode.name;
        byte[] bs = this.outputManager.getBytes(name);
        if(bs!=null){
            Class<?> clazz = defineClass(name, bs,0,bs.length);
           loadedClasses.put(name, clazz);
        }    
    }

    public void addClassPath(File path) {
        try {
            super.addURL(path.toURI().toURL());
        } catch (MalformedURLException ex) {
            Logger.getLogger(KalangClassLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        sourceLoader.addSourceDir(path);
    }
    
    public Class parseSource(String className,String code,String fileName){
        compiler.addSource(className, code, fileName);
        compiler.compile();
        return loadedClasses.get(className);
    }
    
    public Class parseFile(String className,File file) throws IOException{
        String code = FileUtils.readFileToString(file);
        return parseSource(className, code, file.getName());
    }
    
}
