package kalang.compiler.tool;

import kalang.compiler.compile.Configuration;
import kalang.compiler.compile.Diagnosis;
import kalang.compiler.util.Exceptions;
import kalang.lang.Script;
import org.apache.commons.io.FileUtils;

import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Kason Yang
 */
public class KalangShell {

    private Configuration configuration;
    
    private ClassLoader parentClassLoader;

    private final List<File> sourcePaths = new LinkedList<>();

    public KalangShell(Configuration configuration,@Nullable ClassLoader parentClassLoader) {
        this.configuration = configuration;
        this.parentClassLoader = parentClassLoader==null ? KalangShell.class.getClassLoader() : parentClassLoader;
    }

    public KalangShell() {
        this(new Configuration(),null);
    }

    public void addSourcePath(File path) {
        this.sourcePaths.add(path);
    }

    public Class parse(String className, String code, String fileName) {
        KalangClassLoader classLoader = this.createClassLoader();
        return classLoader.parseSource(className, code, fileName);
    }

    public Class parse(File file) throws IOException {
        String className = file.getName().split("\\.")[0];
        return parse(className, FileUtils.readFileToString(file, configuration.getEncoding()), file.getName());
    }

    public Script parseScript(File file) throws IOException {
        String className = file.getName().split("\\.")[0];
        return parseScript(className, file);
    }

    public Script parseScript(String className, File file) throws IOException {
        KalangClassLoader classLoader = this.createClassLoader();
        Class clazz = classLoader.parseFile(className, file);
        return createScriptInstance(clazz);
    }

    public Script parseScript(String className, String code, String fileName) {
        KalangClassLoader classLoader = this.createClassLoader();
        Class clazz = classLoader.parseSource(className, code, fileName);
        return createScriptInstance(clazz);
    }

    private KalangClassLoader createClassLoader() {
        return new KalangClassLoader(sourcePaths.toArray(new File[0]),this.configuration,this.parentClassLoader) {
            @Override
            public void handleDiagnosis(Diagnosis diagnosis) {
                if (diagnosis.getKind().isError()) {
                    super.handleDiagnosis(diagnosis);
                } else {
                    System.err.format("%s:%d: %s: %s\n",
                            diagnosis.getSource().getFileName(),
                            diagnosis.getOffset().startLine,
                            diagnosis.getKind().name(),
                            diagnosis.getDescription()
                    );
                }
            }
        };
    }

    private Script createScriptInstance(Class scriptClass) {
        if (Script.class.isAssignableFrom(scriptClass)) {
            try {
                return (Script) scriptClass.newInstance();
            } catch (InstantiationException | IllegalAccessException ex) {
                throw Exceptions.unexpectedException(ex);
            }
        } else {
            throw new NonScriptFileException();
        }
    }

}
