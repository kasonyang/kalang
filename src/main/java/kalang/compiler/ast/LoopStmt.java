/*

*/
package kalang.compiler.ast;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.LinkedList;
import java.util.List;
public class LoopStmt extends Statement{
    
    //public final List<Statement> initStmts = new LinkedList<>();

    private BlockStmt loopBody;
    
    private BlockStmt updateStmt;
    
    @Nullable
    private ExprNode preConditionExpr;
    
    @Nullable
    private ExprNode postConditionExpr;

    public LoopStmt(ExprNode preConditionExpr, ExprNode postConditionExpr) {
        this(preConditionExpr, postConditionExpr, null,null);
    }
    
    public LoopStmt(
            @Nullable ExprNode preConditionExpr, 
            @Nullable ExprNode postConditionExpr, 
            @Nullable BlockStmt loopBody,
            @Nullable BlockStmt updateStmt
    ){
        this.loopBody = loopBody==null ? new BlockStmt() : loopBody;
        this.preConditionExpr = preConditionExpr;
        this.postConditionExpr = postConditionExpr;
        this.updateStmt = updateStmt == null ? new BlockStmt() : updateStmt;
    }
    
    @Override
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        //addChild(ls,initStmts);
        addChild(ls,preConditionExpr);
        addChild(ls,loopBody);
        addChild(ls,updateStmt);
        addChild(ls,postConditionExpr);
        return ls;
    }

    @Override
    public void updateChildren(ChildUpdater childUpdater) {
        preConditionExpr = doUpdateChild(preConditionExpr, childUpdater);
        loopBody = doUpdateChild(loopBody, childUpdater);
        updateStmt = doUpdateChild(updateStmt, childUpdater);
        postConditionExpr = doUpdateChild(postConditionExpr, childUpdater);
    }

    @Nonnull
    public BlockStmt getLoopBody() {
        return loopBody;
    }

    @Nonnull
    public BlockStmt getUpdateStmt() {
        return updateStmt;
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