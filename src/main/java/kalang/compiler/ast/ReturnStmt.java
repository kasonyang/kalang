package kalang.compiler.ast;

import java.util.LinkedList;
import java.util.List;
public class ReturnStmt extends Statement{
    
    public ExprNode expr = null;
    
    
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
    public String toString() {
        return "return " + (expr == null ? "" : expr);
    }
}