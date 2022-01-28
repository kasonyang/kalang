package kalang.compiler.ast;

/**
 * @author KasonYang
 */
public interface ChildUpdater {

    <T extends AstNode> T update(T child);

}
