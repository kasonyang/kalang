package kalang.compiler.ast;

import java.util.LinkedList;
import java.util.List;

public class CatchBlock extends AstNode {

    public LocalVarNode catchVar;

    public BlockStmt execStmt;

    public CatchBlock(LocalVarNode catchVar, BlockStmt execStmt) {
        this.catchVar = catchVar;
        this.execStmt = execStmt;
    }

    @Override
    public List<AstNode> getChildren() {
        List<AstNode> ls = new LinkedList();
        addChild(ls, catchVar);
        addChild(ls, execStmt);
        return ls;
    }

}
