/*
Don't modify!This file is generated automately.
*/
package jast.ast;
import java.util.*;
public class IfStmt extends Statement{
    
    public ExprNode conditionExpr;
    
    public Statement trueBody;
    
    public Statement falseBody;
    
    
    
    public IfStmt(ExprNode conditionExpr=null,Statement trueBody=null,Statement falseBody=null){
        
        
            this.conditionExpr = conditionExpr;
        
            this.trueBody = trueBody;
        
            this.falseBody = falseBody;
        
    }
    
    
    public static IfStmt create(){
        IfStmt node = new IfStmt();
        
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
        
        addChild(ls,conditionExpr);
        
        addChild(ls,trueBody);
        
        addChild(ls,falseBody);
        
        return ls;
    }
    
    public String toString(){
        String str = "IfStmt{\r\n";
        
        str += "  conditionExpr:" + conditionExpr.toString()+"\r\n";
        
        str += "  trueBody:" + trueBody.toString()+"\r\n";
        
        str += "  falseBody:" + falseBody.toString()+"\r\n";
        
        return str+"}";
    }
}