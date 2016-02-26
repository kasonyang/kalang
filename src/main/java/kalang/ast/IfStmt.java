/*
Don't modify!This file is generated automately.
*/
package kalang.ast;
import java.util.*;
import kalang.core.*;
public class IfStmt extends Statement{
    
    public ExprNode conditionExpr;
    
    public Statement trueBody;
    
    public Statement falseBody;
    
    
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
        
        addChild(ls,conditionExpr);
        
        addChild(ls,trueBody);
        
        addChild(ls,falseBody);
        
        return ls;
    }
    
    public String toString(){
        String str = "IfStmt{\r\n";
        
        if(conditionExpr!=null){
            str += "  conditionExpr:" + conditionExpr.toString()+"\r\n";
        }
        
        if(trueBody!=null){
            str += "  trueBody:" + trueBody.toString()+"\r\n";
        }
        
        if(falseBody!=null){
            str += "  falseBody:" + falseBody.toString()+"\r\n";
        }
        
        return str+"}";
    }
}