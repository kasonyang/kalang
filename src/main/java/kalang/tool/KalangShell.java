package kalang.tool;

import java.io.File;
import java.io.IOException;
import javax.annotation.Nullable;
import kalang.KalangClassLoader;
import kalang.Script;
import kalang.compiler.Configuration;
import kalang.exception.Exceptions;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Kason Yang
 */
public class KalangShell {

    private Configuration configuration;
    
    private ClassLoader parentClassLoader;

    public KalangShell(Configuration configuration,@Nullable ClassLoader parentClassLoader) {
        this.configuration = configuration;
        this.parentClassLoader = parentClassLoader==null ? KalangShell.class.getClassLoader() : parentClassLoader;
    }

    public KalangShell() {
        this(new Configuration(),null);
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
        return new KalangClassLoader(new File[0],this.configuration,this.parentClassLoader);
    }

    private Script createScriptInstance(Class scriptClass) {
        if (Script.class.isAssignableFrom(scriptClass)) {
            try {
                return (Script) scriptClass.newInstance();
            } catch (InstantiationException | IllegalAccessException ex) {
                throw Exceptions.unexceptedException(ex);
            }
        } else {
            throw new NonScriptFileException();
        }
    }

}
