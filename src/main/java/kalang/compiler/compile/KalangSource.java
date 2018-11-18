
package kalang.compiler.compile;

/**
 *
 * @author Kason Yang 
 */
public class KalangSource {
    
    private String className;
    
    private String text;
    
    private String fileName;

    public KalangSource(String className, String text,String fileName) {
        this.className = className;
        this.text = text;
        this.fileName = fileName;
    }

    public String getClassName() {
        return className;
    }

    public String getText() {
        return text;
    }

    public KalangSource(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

}
