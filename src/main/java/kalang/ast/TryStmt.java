package kalang.ast;
import java.util.*;
import javax.annotation.Nullable;
import kalang.core.*;
public class TryStmt extends Statement{
    
    protected Statement execStmt;
    
    protected final List<CatchBlock> catchStmts = new LinkedList<>();
    
    @Nullable
    protected Statement finallyStmt;
    
    
    public TryStmt(Statement execStmt,List<CatchBlock> catchStmts,@Nullable Statement finallyStmt){
        if(catchStmts == null) catchStmts = new LinkedList();
        this.execStmt = execStmt;
        this.catchStmts.addAll(catchStmts);
        this.finallyStmt = finallyStmt;
    }
    
    @Override
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        addChild(ls, getExecStmt());
        addChild(ls, getCatchStmts());
        addChild(ls, getFinallyStmt());
        return ls;
    }

    /**
     * @return the execStmt
     */
    public Statement getExecStmt() {
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
    public Statement getFinallyStmt() {
        return finallyStmt;
    }
    
}