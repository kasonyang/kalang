package kalang.ast;
import java.util.*;
import kalang.core.*;
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

}