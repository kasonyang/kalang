package kalang.compiler.ast;

import javax.annotation.Nullable;
import java.util.LinkedList;
import java.util.List;
public class TryStmt extends Statement{
    
    protected BlockStmt execStmt;
    
    protected final List<CatchBlock> catchStmts = new LinkedList<>();
    
    @Nullable
    protected FinallyBlock finallyBlock;
    
    public TryStmt(BlockStmt execStmt,List<CatchBlock> catchStmts,@Nullable FinallyBlock finallyBlock){
        if(catchStmts == null) catchStmts = new LinkedList<>();
        this.execStmt = execStmt;
        this.catchStmts.addAll(catchStmts);
        this.finallyBlock = finallyBlock;
    }
    
    @Override
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList<>();
        addChild(ls, execStmt);
        addChild(ls, catchStmts);
        addChild(ls, finallyBlock);
        return ls;
    }

    /**
     * @return the execStmt
     */
    public BlockStmt getExecStmt() {
        return execStmt;
    }

    /**
     * @return the catchStmts
     */
    public List<CatchBlock> getCatchStmts() {
        return catchStmts;
    }

    /**
     * @return the finallyStmt
     */
    public FinallyBlock getFinallyBlock() {
        return finallyBlock;
    }
    
}