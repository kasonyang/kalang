package kalang.compiler;

public class AstNotFoundException extends RuntimeException {

    public AstNotFoundException(String clsName) {
        super(clsName);
    }
    
}
