
package kalang;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import kalang.ast.ClassNode;
import kalang.compiler.codegen.Ast2Class;
import kalang.compiler.CodeGenerator;
import kalang.compiler.CompilationUnit;
import kalang.compiler.Configuration;
import kalang.compiler.Diagnosis;
import kalang.compiler.DiagnosisHandler;
import kalang.compiler.JavaAstLoader;
import kalang.compiler.KalangCompiler;
import kalang.compiler.KalangSource;
import kalang.compiler.OffsetRange;
import kalang.compiler.SourceLoader;
import kalang.tool.FileSystemSourceLoader;
import kalang.tool.MemoryOutputManager;
import org.apache.commons.io.FileUtils;
/**
 *
 * @author Kason Yang
 */
public class KalangClassLoader extends URLClassLoader implements CodeGenerator,DiagnosisHandler{

    private final KalangCompiler compiler;
    
    private final HashMap<String,Class> loadedClasses = new HashMap<>();
    private final FileSystemSourceLoader sourceLoader;
    private Configuration configuration;
    private ClassLoader parentClassLoader = KalangClassLoader.class.getClassLoader();

    public KalangClassLoader() {
        this(new File[0],null,null);
    }

    public KalangClassLoader(File[] sourceDir,@Nullable Configuration config,@Nullable ClassLoader parentClassLoader) {
        super(new URL[0],parentClassLoader==null ? (parentClassLoader = KalangClassLoader.class.getClassLoader()) : parentClassLoader);
        this.configuration = config == null ? new Configuration() : config;
        this.parentClassLoader = parentClassLoader;
        sourceLoader = new FileSystemSourceLoader(sourceDir,new String[]{"kl","kalang"});
        CodeGenerator cg = this;
        compiler = new KalangCompiler(new JavaAstLoader(null, parentClassLoader)){
            @Override
            public SourceLoader getSourceLoader() {
                return sourceLoader;
            }

            @Override
            public CodeGenerator createCodeGenerator(CompilationUnit compilationUnit) {
                return cg;
            }
            
        };
        compiler.setConfiguration(this.configuration);
        compiler.setDiagnosisHandler(this);
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
        final MemoryOutputManager outputManager = new MemoryOutputManager();
        Ast2Class ast2Class = new Ast2Class(outputManager);
        ast2Class.generate(classNode);
        String[] names = outputManager.getClassNames();
        for(String name:names){
            byte[] bs = outputManager.getBytes(name);
            if(bs!=null){
                Class<?> clazz = defineClass(name, bs,0,bs.length);
                loadedClasses.put(name, clazz);
            }    
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

    @Override
    public void handleDiagnosis(Diagnosis diagnosis) {
        if(diagnosis.getKind().isError()){
            KalangSource source = diagnosis.getSource();
            OffsetRange offset = diagnosis.getOffset();
            throw new CompileException(String.format("%s:%s\n%s"
                    , source.getFileName(),offset.startLine
                    , diagnosis.getDescription())
            );
        }
    }
    
}
