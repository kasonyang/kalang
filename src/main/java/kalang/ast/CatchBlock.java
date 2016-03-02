package kalang.ast;

import java.util.*;
import kalang.core.*;

public class CatchBlock extends AstNode {

    public LocalVarNode catchVar;

    public Statement execStmt;

    public CatchBlock(LocalVarNode catchVar, Statement execStmt) {
        this.catchVar = catchVar;
        this.execStmt = execStmt;
    }

    public List<AstNode> getChildren() {
        List<AstNode> ls = new LinkedList();
        addChild(ls, catchVar);
        addChild(ls, execStmt);
        return ls;
    }

}
