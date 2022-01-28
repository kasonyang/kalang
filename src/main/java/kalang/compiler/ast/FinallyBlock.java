package kalang.compiler.ast;

import java.util.Collections;
import java.util.List;

/**
 * @author KasonYang
 */
public class FinallyBlock extends AstNode {

    private BlockStmt execStmt;

    public FinallyBlock(BlockStmt execStmt) {
        this.execStmt = execStmt;
    }

    public BlockStmt getExecStmt() {
        return execStmt;
    }


    @Override
    public List<AstNode> getChildren() {
        return Collections.singletonList(execStmt);
    }

    @Override
    public void updateChildren(ChildUpdater childUpdater) {
        execStmt = doUpdateChild(execStmt, childUpdater);
    }
}
