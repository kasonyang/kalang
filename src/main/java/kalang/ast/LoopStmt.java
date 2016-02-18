/*
Don't modify!This file is generated automately.
*/
package kalang.ast;
import java.util.*;
import kalang.core.*;
public class LoopStmt extends Statement{
    
    public List<Statement> initStmts;
    
    public Statement loopBody;
    
    public ExprNode preConditionExpr;
    
    public ExprNode postConditionExpr;
    
    
    public LoopStmt(){
        
            if(initStmts == null) initStmts = new LinkedList();
        
    }
    
    
    public LoopStmt(List<Statement> initStmts,Statement loopBody,ExprNode preConditionExpr,ExprNode postConditionExpr){
        
            if(initStmts == null) initStmts = new LinkedList();
        
        
            this.initStmts = initStmts;
        
            this.loopBody = loopBody;
        
            this.preConditionExpr = preConditionExpr;
        
            this.postConditionExpr = postConditionExpr;
        
    }
    
    
    public static LoopStmt create(){
        LoopStmt node = new LoopStmt();
        
        node.initStmts = new LinkedList();
        
        return node;
    }
    
    private void addChild(List<AstNode> list,List nodes){
        if(nodes!=null) list.addAll(nodes);
    }
    
    private void addChild(List<AstNode> list,AstNode node){
        if(node!=null) list.add(node);
    }
    
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        
        addChild(ls,initStmts);
        
        addChild(ls,loopBody);
        
        addChild(ls,preConditionExpr);
        
        addChild(ls,postConditionExpr);
        
        return ls;
    }
    
    public String toString(){
        String str = "LoopStmt{\r\n";
        
        if(initStmts!=null){
            str += "  initStmts:" + initStmts.toString()+"\r\n";
        }
        
        if(loopBody!=null){
            str += "  loopBody:" + loopBody.toString()+"\r\n";
        }
        
        if(preConditionExpr!=null){
            str += "  preConditionExpr:" + preConditionExpr.toString()+"\r\n";
        }
        
        if(postConditionExpr!=null){
            str += "  postConditionExpr:" + postConditionExpr.toString()+"\r\n";
        }
        
        return str+"}";
    }
}