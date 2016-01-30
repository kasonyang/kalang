/*
Don't modify!This file is generated automately.
*/
package jast.ast;
import java.util.*;
public class MultiStmtExpr extends ExprNode{
    
    public List<Statement> stmts;
    
    public ExprNode reference;
    
    
    public MultiStmtExpr(){
        
            if(stmts == null) stmts = new LinkedList();
        
    }
    
    
    public MultiStmtExpr(List<Statement> stmts,ExprNode reference){
        
            if(stmts == null) stmts = new LinkedList();
        
        
            this.stmts = stmts;
        
            this.reference = reference;
        
    }
    
    
    public static MultiStmtExpr create(){
        MultiStmtExpr node = new MultiStmtExpr();
        
        node.stmts = new LinkedList();
        
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
        
        addChild(ls,stmts);
        
        return ls;
    }
    
    public String toString(){
        String str = "MultiStmtExpr{\r\n";
        
        if(stmts!=null){
            str += "  stmts:" + stmts.toString()+"\r\n";
        }
        
        if(reference!=null){
            str += "  reference:" + reference.toString()+"\r\n";
        }
        
        return str+"}";
    }
}