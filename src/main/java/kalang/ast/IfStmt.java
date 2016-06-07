package kalang.ast;
import java.util.*;
import javax.annotation.Nullable;
import kalang.core.*;
public class IfStmt extends Statement{
    
    protected ExprNode conditionExpr;
    
    protected BlockStmt trueBody;
    
    protected BlockStmt falseBody;
    
    public IfStmt(ExprNode conditionExpr,@Nullable BlockStmt trueBody,@Nullable BlockStmt falseBody){
        this.conditionExpr = conditionExpr;
        this.trueBody = trueBody;
        this.falseBody = falseBody;
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
    @Nullable
    public BlockStmt getTrueBody() {
        return trueBody;
    }

    /**
     * @param trueBody the trueBody to set
     */
    public void setTrueBody(BlockStmt trueBody) {
        Objects.requireNonNull(trueBody);
        this.trueBody = trueBody;
    }

    /**
     * @return the falseBody
     */
    @Nullable
    public BlockStmt getFalseBody() {
        return falseBody;
    }

    /**
     * @param falseBody the falseBody to set
     */
    public void setFalseBody(BlockStmt falseBody) {
        Objects.requireNonNull(falseBody);
        this.falseBody = falseBody;
    }
}