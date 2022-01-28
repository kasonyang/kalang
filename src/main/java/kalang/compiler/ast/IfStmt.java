package kalang.compiler.ast;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
public class IfStmt extends Statement{
    
    protected ExprNode conditionExpr;
    
    protected BlockStmt trueBody;
    
    protected BlockStmt falseBody;

    public IfStmt(ExprNode conditionExpr,@Nullable BlockStmt trueBody,@Nullable BlockStmt falseBody) {
        if(trueBody==null) trueBody = new BlockStmt();
        if(falseBody==null) falseBody = new BlockStmt();
        this.conditionExpr = conditionExpr;
        this.trueBody = trueBody;
        this.falseBody = falseBody;
    }
    
    public IfStmt(ExprNode conditionExpr){
        this(conditionExpr,null,null);
    }
    
    @Override
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        addChild(ls, conditionExpr);
        addChild(ls, trueBody);
        addChild(ls, falseBody);
        return ls;
    }

    @Override
    public void updateChildren(ChildUpdater childUpdater) {
        conditionExpr = doUpdateChild(conditionExpr, childUpdater);
        trueBody = doUpdateChild(trueBody, childUpdater);
        falseBody = doUpdateChild(falseBody, childUpdater);
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
    @Nonnull
    public BlockStmt getTrueBody() {
        return trueBody;
    }


    /**
     * @return the falseBody
     */
    @Nonnull
    public BlockStmt getFalseBody() {
        return falseBody;
    }

}