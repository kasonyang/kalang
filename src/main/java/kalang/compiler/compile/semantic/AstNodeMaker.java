package kalang.compiler.compile.semantic;

import kalang.compiler.ast.AstNode;

/**
 * @author KasonYang
 */
public interface AstNodeMaker<T extends AstNode> {

    T make();

}
