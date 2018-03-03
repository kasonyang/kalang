package kalang.compiler;

import kalang.Script;

/**
 *
 * @author Kason Yang
 */
public class Configuration {

    private String scriptBaseClass = Script.class.getName();

    public String getScriptBaseClass() {
        return scriptBaseClass;
    }

    public void setScriptBaseClass(String scriptBaseClass) {
        this.scriptBaseClass = scriptBaseClass;
    }

}
