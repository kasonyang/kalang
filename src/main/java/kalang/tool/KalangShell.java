package kalang.tool;

import java.io.File;
import java.io.IOException;
import kalang.KalangClassLoader;
import kalang.Script;
import kalang.compiler.Configuration;
import kalang.exception.Exceptions;

/**
 *
 * @author Kason Yang
 */
public class KalangShell {

    private Configuration configuration;

    public KalangShell(Configuration configuration) {
        this.configuration = configuration;
    }

    public KalangShell() {
        this(new Configuration());
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
        return new KalangClassLoader(this.configuration);
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
