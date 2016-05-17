package kalang.ast;
import java.util.*;
import javax.annotation.Nullable;
import kalang.core.*;
public class TryStmt extends Statement{
    
    public Statement execStmt;
    
    public final List<CatchBlock> catchStmts = new LinkedList<>();
    
    @Nullable
    public Statement finallyStmt;
    
    
    public TryStmt(Statement execStmt,List<CatchBlock> catchStmts,@Nullable Statement finallyStmt){
        if(catchStmts == null) catchStmts = new LinkedList();
        this.execStmt = execStmt;
        this.catchStmts.addAll(catchStmts);
        this.finallyStmt = finallyStmt;
    }
    
    @Override
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        addChild(ls,execStmt);
        addChild(ls,catchStmts);
        addChild(ls,finallyStmt);
        return ls;
    }
    
}