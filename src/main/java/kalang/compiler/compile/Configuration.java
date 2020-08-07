package kalang.compiler.compile;

import kalang.compiler.compile.jvm.JvmClassNodeLoader;
import kalang.lang.Script;

/**
 *
 * @author Kason Yang
 */
public class Configuration {

    private String scriptBaseClass = Script.class.getName();

    private String encoding = "utf8";

    private ClassNodeLoader classNodeLoader = new JvmClassNodeLoader();

    public static Configuration copy(Configuration other) {
        Configuration conf = new Configuration();
        conf.scriptBaseClass = other.scriptBaseClass;
        conf.encoding = other.encoding;
        conf.classNodeLoader = other.classNodeLoader;
        return conf;
    }

    public String getScriptBaseClass() {
        return scriptBaseClass;
    }

    public void setScriptBaseClass(String scriptBaseClass) {
        this.scriptBaseClass = scriptBaseClass;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public ClassNodeLoader getClassNodeLoader() {
        return classNodeLoader;
    }

    public void setClassNodeLoader(ClassNodeLoader classNodeLoader) {
        this.classNodeLoader = classNodeLoader;
    }

}
