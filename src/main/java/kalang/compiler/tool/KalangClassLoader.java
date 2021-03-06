
package kalang.compiler.tool;

import kalang.compiler.compile.*;
import kalang.compiler.compile.codegen.Ast2Class;
import kalang.compiler.compile.jvm.JvmClassNodeLoader;
import kalang.compiler.util.FilePathUtil;
import kalang.mixin.CollectionMixin;
import org.apache.commons.io.FileUtils;

import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Objects;
/**
 *
 * @author Kason Yang
 */
public class KalangClassLoader extends URLClassLoader implements DiagnosisHandler{

    private final KalangCompiler compiler;
    
    private final HashMap<String,Class> loadedClasses = new HashMap<>();

    private final SourceLoader sourceLoader;

    final MemoryOutputManager outputManager = new MemoryOutputManager();

    private final Configuration conf;

    public KalangClassLoader() {
        this(new File[0],null,null);
    }

    public KalangClassLoader(File[] sourceDir,@Nullable Configuration config,@Nullable ClassLoader parentClassLoader) {
        super(
          CollectionMixin.map(sourceDir, URL.class, FilePathUtil::toURL),
          parentClassLoader == null ? (parentClassLoader = KalangClassLoader.class.getClassLoader()) : parentClassLoader
        );
        conf = config == null ? new Configuration() : Configuration.copy(config);
        sourceLoader = new CachedSourceLoader(
                new FileSystemSourceLoader(sourceDir, KalangSource.EXTENSION_STANDARD, conf.getEncoding())
        );
        conf.setClassNodeLoader(
            new CachedClassNodeLoader(
                new JvmClassNodeLoader(conf.getClassNodeLoader(), parentClassLoader)
            )
        );
        compiler = new KalangCompiler(conf){
            @Override
            public SourceLoader getSourceLoader() {
                return sourceLoader;
            }

            @Override
            public CodeGenerator createCodeGenerator(CompilationUnit compilationUnit) {
                return () -> generateClasses(compilationUnit);
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

    private void generateClasses(CompilationUnit compilationUnit) {
        Ast2Class ast2Class = new Ast2Class(outputManager, compiler.getClassNodeLoader(), compilationUnit);
        ast2Class.generateCode();
    }
    
    public Class<?> parseSource(String className,String code,String fileName){
        compiler.addSource(className, code, fileName);
        compiler.compile();
        return Objects.requireNonNull(tryLoadGeneratedClass(className));
    }
    
    public Class parseFile(String className,File file) throws IOException{
        String code = FileUtils.readFileToString(file, conf.getEncoding());
        return parseSource(className, code, file.getCanonicalPath());
    }

    @Override
    public void handleDiagnosis(Diagnosis diagnosis) {
        if(diagnosis.getKind().isError()){
            KalangSource source = diagnosis.getSource();
            OffsetRange offset = diagnosis.getOffset();
            throw new CompileException(diagnosis.getDescription(), source.getFileName(),offset.startLine);
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
