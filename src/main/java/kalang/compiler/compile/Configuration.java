package kalang.compiler.compile;

import kalang.compiler.compile.jvm.JvmAstLoader;
import kalang.lang.Script;

/**
 *
 * @author Kason Yang
 */
public class Configuration {

    private String scriptBaseClass = Script.class.getName();

    private String encoding = "utf8";

    private AstLoader astLoader = new JvmAstLoader();

    public static Configuration copy(Configuration other) {
        Configuration conf = new Configuration();
        conf.scriptBaseClass = other.scriptBaseClass;
        conf.encoding = other.encoding;
        conf.astLoader = other.astLoader;
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

    public AstLoader getAstLoader() {
        return astLoader;
    }

    public void setAstLoader(AstLoader astLoader) {
        this.astLoader = astLoader;
    }

}
