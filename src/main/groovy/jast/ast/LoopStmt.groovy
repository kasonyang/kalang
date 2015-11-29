/*
Don't modify!This file is generated automately.
*/
package jast.ast;
import java.util.*;
public class LoopStmt extends Statement{
    
    public List<Statement> initStmts;
    
    public Statement loopBody;
    
    public ExprNode preConditionExpr;
    
    public ExprNode postConditionExpr;
    
    
    
    public LoopStmt(List<Statement> initStmts=null,Statement loopBody=null,ExprNode preConditionExpr=null,ExprNode postConditionExpr=null){
        
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
        
        str += "  initStmts:" + initStmts.toString()+"\r\n";
        
        str += "  loopBody:" + loopBody.toString()+"\r\n";
        
        str += "  preConditionExpr:" + preConditionExpr.toString()+"\r\n";
        
        str += "  postConditionExpr:" + postConditionExpr.toString()+"\r\n";
        
        return str+"}";
    }
}