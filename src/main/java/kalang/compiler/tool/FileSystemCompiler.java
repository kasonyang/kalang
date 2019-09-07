package kalang.compiler.tool;

import kalang.compiler.compile.*;
import kalang.compiler.util.ClassNameUtil;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The FileSystemCompiler compile sources from file system.
 *
 * @author Kason Yang
 */
public class FileSystemCompiler {

    private final Map<String, File> sourceFiles = new HashMap<>();

    private final List<URL> classPaths = new LinkedList<>();

    private final List<File> sourcePaths = new LinkedList<>();

    private AstLoader parentAstLoader = AstLoader.BASE_AST_LOADER;

    private String extension = "class";

    private File outputDir;

    private DiagnosisHandler diagnosisHandler;

    private ClassLoader classLoader = FileSystemCompiler.class.getClassLoader();

    private Configuration configuration = new Configuration();

    public FileSystemCompiler() {
        super();
    }

    public void compile() throws IOException {
        if (outputDir == null) {
            throw new IllegalStateException("output diretory is null");
        }
        URLClassLoader pathClassLoader = new URLClassLoader(classPaths.toArray(new URL[classPaths.size()]), this.classLoader);
        AstLoader astLoader = new JavaAstLoader(this.parentAstLoader, pathClassLoader);
        Configuration conf = Configuration.copy(configuration);
        conf.setAstLoader(astLoader);
        KalangCompiler compiler = new KalangCompiler(conf) {
            @Override
            public CodeGenerator createCodeGenerator(CompilationUnit compilationUnit) {
                FileSystemOutputManager om = new FileSystemOutputManager(outputDir, extension);
                return new ClassWriter(om, this.getAstLoader());
            }

        };
        if (diagnosisHandler != null) {
            compiler.setDiagnosisHandler(diagnosisHandler);
        }
        for (Map.Entry<String, File> e : sourceFiles.entrySet()) {
            String className = e.getKey();
            File file = e.getValue();
            compiler.addSource(className, FileUtils.readFileToString(file), file.getName());
        }
        FileSystemSourceLoader sourceLoader = new FileSystemSourceLoader(sourcePaths.toArray(new File[sourcePaths.size()]), new String[]{"kl", "kalang"});
        compiler.setSourceLoader(sourceLoader);
        compiler.compile();
    }

    public void addSource(File srcDir, File file) throws IOException {
        String className = ClassNameUtil.getClassName(srcDir, file);
        sourceFiles.put(className, file);

    }

    public void addSourceDir(File sourceDir) throws IOException {
        Collection<File> files = FileUtils.listFiles(sourceDir, new String[]{"kl"}, true);
        for (File f : files) {
            addSource(sourceDir, f);
        }
    }

    public void addClassPath(File path) {
        try {
            classPaths.add(path.toURI().toURL());
        } catch (MalformedURLException ex) {
            Logger.getLogger(FileSystemCompiler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addSourcePath(File path) {
        sourcePaths.add(path);
    }

    public File getOutputDir() {
        return outputDir;
    }

    public void setOutputDir(File outputDir) {
        this.outputDir = outputDir;
    }

    public DiagnosisHandler getDiagnosisHandler() {
        return diagnosisHandler;
    }

    public void setDiagnosisHandler(DiagnosisHandler diagnosisHandler) {
        this.diagnosisHandler = diagnosisHandler;
    }

    public ClassLoader getClassLoader() {
        return classLoader;
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

}
