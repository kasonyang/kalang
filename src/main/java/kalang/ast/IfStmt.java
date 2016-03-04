/*

*/
package kalang.ast;
import java.util.*;
import kalang.core.*;
public class IfStmt extends Statement{
    
    protected ExprNode conditionExpr;
    
    protected Statement trueBody;
    
    protected Statement falseBody;
    
    
    public IfStmt(){
        
    }
    
    
    public IfStmt(ExprNode conditionExpr,Statement trueBody,Statement falseBody){
        
        
            this.conditionExpr = conditionExpr;
        
            this.trueBody = trueBody;
        
            this.falseBody = falseBody;
        
    }
    
    
    public static IfStmt create(){
        IfStmt node = new IfStmt();
        
        return node;
    }
    
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        
        addChild(ls, getConditionExpr());
        
        addChild(ls, getTrueBody());
        
        addChild(ls, getFalseBody());
        
        return ls;
    }
    
    public String toString(){
        String str = "IfStmt{\r\n";
        
        if(getConditionExpr()!=null){
            str += "  conditionExpr:" + getConditionExpr().toString()+"\r\n";
        }
        
        if(getTrueBody()!=null){
            str += "  trueBody:" + getTrueBody().toString()+"\r\n";
        }
        
        if(getFalseBody()!=null){
            str += "  falseBody:" + getFalseBody().toString()+"\r\n";
        }
        
        return str+"}";
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