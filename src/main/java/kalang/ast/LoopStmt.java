/*

*/
package kalang.ast;
import java.util.*;
import javax.annotation.Nullable;
import kalang.core.*;
public class LoopStmt extends Statement{
    
    public final List<Statement> initStmts = new LinkedList<>();
    
    @Nullable
    public Statement loopBody;
    
    @Nullable
    public ExprNode preConditionExpr;
    
    @Nullable
    public ExprNode postConditionExpr;
    
    
    public LoopStmt(@Nullable List<Statement> initStmts,@Nullable Statement loopBody,@Nullable ExprNode preConditionExpr,@Nullable ExprNode postConditionExpr){
        if(initStmts!=null){
            this.initStmts.addAll(initStmts);
        }
        this.loopBody = loopBody;
        this.preConditionExpr = preConditionExpr;
        this.postConditionExpr = postConditionExpr;
    }
    
    @Override
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        addChild(ls,initStmts);
        addChild(ls,loopBody);
        addChild(ls,preConditionExpr);
        addChild(ls,postConditionExpr);
        return ls;
    }
    
}