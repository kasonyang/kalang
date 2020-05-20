
package kalang.compiler.tool;

import kalang.compiler.compile.*;
import kalang.compiler.compile.codegen.Ast2Class;
import kalang.compiler.compile.jvm.JvmAstLoader;
import kalang.compiler.util.FilePathUtil;
import kalang.mixin.CollectionMixin;
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
public class KalangClassLoader extends URLClassLoader implements DiagnosisHandler{

    private final KalangCompiler compiler;
    
    private final HashMap<String,Class> loadedClasses = new HashMap<>();

    private final FileSystemSourceLoader sourceLoader;

    final MemoryOutputManager outputManager = new MemoryOutputManager();

    public KalangClassLoader() {
        this(new File[0],null,null);
    }

    public KalangClassLoader(File[] sourceDir,@Nullable Configuration config,@Nullable ClassLoader parentClassLoader) {
        super(
          CollectionMixin.map(sourceDir, URL.class, FilePathUtil::toURL),
          parentClassLoader == null ? (parentClassLoader = KalangClassLoader.class.getClassLoader()) : parentClassLoader
        );
        Configuration conf = config == null ? new Configuration() : Configuration.copy(config);
        sourceLoader = new FileSystemSourceLoader(sourceDir, new String[]{"kl","kalang"}, conf.getEncoding());
        conf.setAstLoader(new JvmAstLoader(conf.getAstLoader(), parentClassLoader));
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
        Ast2Class ast2Class = new Ast2Class(outputManager, compiler.getAstLoader(), compilationUnit);
        ast2Class.generateCode();
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
