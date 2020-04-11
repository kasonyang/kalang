package kalang.compiler.compile;

public class AstNotFoundException extends RuntimeException {

    public AstNotFoundException(String clsName) {
        super(clsName);
    }
    
}
