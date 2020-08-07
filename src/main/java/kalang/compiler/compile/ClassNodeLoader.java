package kalang.compiler.compile;

import kalang.compiler.ast.ClassNode;

/**
 * @author KasonYang
 */
public interface ClassNodeLoader {

    default ClassNode loadClassNode(String className) {
        ClassNode cn = getClassNode(className);
        if (cn == null) {
            throw new ClassNodeNotFoundException(className);
        }
        return cn;
    }

    ClassNode getClassNode(String className);

}
