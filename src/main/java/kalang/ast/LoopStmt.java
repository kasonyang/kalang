/*

*/
package kalang.ast;
import java.util.*;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import kalang.core.*;
public class LoopStmt extends Statement{
    
    //public final List<Statement> initStmts = new LinkedList<>();

    private BlockStmt loopBody;
    
    @Nullable
    private final ExprNode preConditionExpr;
    
    @Nullable
    private final ExprNode postConditionExpr;

    public LoopStmt(ExprNode preConditionExpr, ExprNode postConditionExpr) {
        this(preConditionExpr, postConditionExpr, null);
    }
    
    public LoopStmt(
            @Nullable ExprNode preConditionExpr, 
            @Nullable ExprNode postConditionExpr, 
            @Nullable BlockStmt loopBody
    ){
        this.loopBody = loopBody==null ? new BlockStmt() : loopBody;
        this.preConditionExpr = preConditionExpr;
        this.postConditionExpr = postConditionExpr;
    }
    
    @Override
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        //addChild(ls,initStmts);
        addChild(ls,loopBody);
        addChild(ls,preConditionExpr);
        addChild(ls,postConditionExpr);
        return ls;
    }

    @Nonnull
    public BlockStmt getLoopBody() {
        return loopBody;
    }

    @Nullable
    public ExprNode getPreConditionExpr() {
        return preConditionExpr;
    }

    @Nullable
    public ExprNode getPostConditionExpr() {
        return postConditionExpr;
    }
    
}