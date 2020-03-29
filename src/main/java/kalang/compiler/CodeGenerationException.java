package kalang.compiler;

import kalang.compiler.ast.ClassNode;

/**
 * @author KasonYang
 */
public class CodeGenerationException extends RuntimeException {

    private ClassNode classNode;

    public CodeGenerationException(String message, ClassNode classNode, Throwable cause) {
        super(message, cause);
        this.classNode = classNode;
    }

    public ClassNode getClassNode() {
        return classNode;
    }

}
