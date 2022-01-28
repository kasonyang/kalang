package kalang.compiler.ast;

import java.util.LinkedList;
import java.util.List;
public class ReturnStmt extends Statement{
    
    private ExprNode expr = null;
    
    
    public ReturnStmt(){
        
    }
    
    public ReturnStmt(ExprNode expr){
            this.expr = expr;
    }
    
    @Override
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        if(expr!=null){
            addChild(ls,expr);
        }
        return ls;
    }

    @Override
    public void updateChildren(ChildUpdater childUpdater) {
        expr = doUpdateChild(expr, childUpdater);
    }

    @Override
    public String toString() {
        return "return " + (expr == null ? "" : expr);
    }

    public ExprNode getExpr() {
        return expr;
    }

    public void setExpr(ExprNode expr) {
        this.expr = expr;
    }
}