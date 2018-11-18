package kalang.compiler.compile;

import kalang.lang.Script;

/**
 *
 * @author Kason Yang
 */
public class Configuration {

    private String scriptBaseClass = Script.class.getName();

    private String encoding = "utf8";

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

}
