
package kalang.compiler.compile;

/**
 *
 * @author Kason Yang 
 */
public class KalangSource {
    
    private String className;
    
    private String text;
    
    private String fileName;

    private boolean script;

    public KalangSource(String className, String text,String fileName, boolean script) {
        this.className = className;
        this.text = text;
        this.fileName = fileName;
        this.script = script;
    }

    public String getClassName() {
        return className;
    }

    public String getText() {
        return text;
    }

    public String getFileName() {
        return fileName;
    }

    public boolean isScript() {
        return script;
    }

}
