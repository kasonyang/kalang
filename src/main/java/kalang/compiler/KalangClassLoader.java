
package kalang.compiler;

import kalang.compiler.ast.ClassNode;
import kalang.compiler.compile.*;
import kalang.compiler.compile.codegen.Ast2Class;
import kalang.compiler.tool.FileSystemSourceLoader;
import kalang.compiler.tool.MemoryOutputManager;
import org.apache.commons.io.FileUtils;

import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Kason Yang
 */
public class KalangClassLoader extends URLClassLoader implements CodeGenerator,DiagnosisHandler{

    private final KalangCompiler compiler;
    
    private final HashMap<String,Class> loadedClasses = new HashMap<>();
    private final FileSystemSourceLoader sourceLoader;
    private ClassLoader parentClassLoader = KalangClassLoader.class.getClassLoader();
    final MemoryOutputManager outputManager = new MemoryOutputManager();

    public KalangClassLoader() {
        this(new File[0],null,null);
    }

    public KalangClassLoader(File[] sourceDir,@Nullable Configuration config,@Nullable ClassLoader parentClassLoader) {
        super(new URL[0],parentClassLoader==null ? (parentClassLoader = KalangClassLoader.class.getClassLoader()) : parentClassLoader);
        Configuration conf = config == null ? new Configuration() : Configuration.copy(config);
        this.parentClassLoader = parentClassLoader;
        sourceLoader = new FileSystemSourceLoader(sourceDir,new String[]{"kl","kalang"});
        CodeGenerator cg = this;
        conf.setAstLoader(new JavaAstLoader(conf.getAstLoader(), parentClassLoader));
        compiler = new KalangCompiler(conf){
            @Override
            public SourceLoader getSourceLoader() {
                return sourceLoader;
            }

            @Override
            public CodeGenerator createCodeGenerator(CompilationUnit compilationUnit) {
                return cg;
            }

        };
        compiler.setDiagnosisHandler(this);
    }
    
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz = loadedClasses.get(name);
        if(clazz!=null) return clazz;
        clazz = this.tryLoadGeneratedClass(name);
        if (clazz!=null) {
            return clazz;
        }
        KalangSource src = sourceLoader.loadSource(name);
        if(src!=null){
            compiler.addSource(src);
            compiler.compile();
            clazz = tryLoadGeneratedClass(name);
            if (clazz!=null) {
                return clazz;
            }
        }
        clazz = loadedClasses.get(name);
        if(clazz!=null) return clazz;
        return super.findClass(name);
    }

    @Override
    public void generate(ClassNode classNode) {
        Ast2Class ast2Class = new Ast2Class(outputManager);
        ast2Class.generate(classNode);
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
        //TODO result maybe null
        return tryLoadGeneratedClass(className);
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
            throw new CompileException(String.format("%s @%s:%s"
                    , diagnosis.getDescription()
                    , source.getFileName(),offset.startLine)
            );
        }
    }

    @Nullable
    private Class tryLoadGeneratedClass(String name) {
        byte[] bs = outputManager.getBytes(name);
        if(bs!=null){
            Class<?> clazz = defineClass(name, bs, 0, bs.length);
            loadedClasses.put(name, clazz);
            return clazz;
        }
        return null;
    }
    
}
