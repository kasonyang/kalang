package kalang.compiler.tool;

/**
 * @author Kason Yang
 */

public class CompileException extends RuntimeException {


    private String description;

    private String fileName;

    private int line;


    public CompileException(String description, String fileName, int line) {
        super(formatMsg(description, fileName, line));
        this.description = description;
        this.fileName = fileName;
        this.line = line;
    }

    public String getDescription() {
        return description;
    }

    public String getFileName() {
        return fileName;
    }

    public int getLine() {
        return line;
    }

    private static String formatMsg(String description, String fileName, int line) {
        return String.format("%s @%s:%s", description, fileName, line);
    }

}
