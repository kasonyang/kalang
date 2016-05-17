package kalang.ast;
import java.util.*;
import javax.annotation.Nullable;
import kalang.core.*;
public class IfStmt extends Statement{
    
    protected ExprNode conditionExpr;
    
    protected Statement trueBody;
    
    protected Statement falseBody;
    
    public IfStmt(ExprNode conditionExpr,@Nullable Statement trueBody,@Nullable Statement falseBody){
        this.conditionExpr = conditionExpr;
        this.trueBody = trueBody == null ? new BlockStmt() : trueBody;
        this.falseBody = falseBody == null ? new BlockStmt() : falseBody;
    }
    
    @Override
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        addChild(ls, conditionExpr);
        addChild(ls, trueBody);
        addChild(ls, falseBody);
        return ls;
    }

    /**
     * @return the conditionExpr
     */
    public ExprNode getConditionExpr() {
        return conditionExpr;
    }

    /**
     * @param conditionExpr the conditionExpr to set
     */
    public void setConditionExpr(ExprNode conditionExpr) {
        Objects.requireNonNull(conditionExpr);
        this.conditionExpr = conditionExpr;
    }

    /**
     * @return the trueBody
     */
    public Statement getTrueBody() {
        return trueBody;
    }

    /**
     * @param trueBody the trueBody to set
     */
    public void setTrueBody(Statement trueBody) {
        Objects.requireNonNull(trueBody);
        this.trueBody = trueBody;
    }

    /**
     * @return the falseBody
     */
    public Statement getFalseBody() {
        return falseBody;
    }

    /**
     * @param falseBody the falseBody to set
     */
    public void setFalseBody(Statement falseBody) {
        Objects.requireNonNull(falseBody);
        this.falseBody = falseBody;
    }
}