package kalang.compiler.compile;

import kalang.compiler.ast.AstNode;

/**
 * @author KasonYang
 */
public class MalformedAstException extends RuntimeException {

    private AstNode malformedNode;

    public MalformedAstException(String message, AstNode malformedNode) {
        super(message);
        this.malformedNode = malformedNode;
    }

    public AstNode getMalformedNode() {
        return malformedNode;
    }

}
