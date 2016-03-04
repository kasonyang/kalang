/*

*/
package kalang.ast;
import java.util.*;
import kalang.core.*;
public class ExprStmt extends Statement{
    
    protected ExprNode expr;
    
    
    public ExprStmt(){
        
    }
    
    
    public ExprStmt(ExprNode expr){
        
        
            this.expr = expr;
        
    }
    
    
    public static ExprStmt create(){
        ExprStmt node = new ExprStmt();
        
        return node;
    }
    
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        
        addChild(ls, getExpr());
        
        return ls;
    }
    
    public String toString(){
        String str = "ExprStmt{\r\n";
        
        if(getExpr()!=null){
            str += "  expr:" + getExpr().toString()+"\r\n";
        }
        
        return str+"}";
    }

    /**
     * @return the expr
     */
    public ExprNode getExpr() {
        return expr;
    }

    /**
     * @param expr the expr to set
     */
    public void setExpr(ExprNode expr) {
        Objects.requireNonNull(expr);
        this.expr = expr;
    }
}