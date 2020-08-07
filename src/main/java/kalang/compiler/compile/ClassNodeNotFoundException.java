package kalang.compiler.compile;

public class ClassNodeNotFoundException extends RuntimeException {

    public ClassNodeNotFoundException(String clsName) {
        super(clsName);
    }
    
}
