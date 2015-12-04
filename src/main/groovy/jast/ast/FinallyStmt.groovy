/*
Don't modify!This file is generated automately.
*/
package jast.ast;
import java.util.*;
public class FinallyStmt extends Statement{
    
    public Statement execStmt;
    
    
    
    public FinallyStmt(Statement execStmt=null){
        
            this.execStmt = execStmt;
        
    }
    
    
    public static FinallyStmt create(){
        FinallyStmt node = new FinallyStmt();
        
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
        
        addChild(ls,execStmt);
        
        return ls;
    }
    
    public String toString(){
        String str = "FinallyStmt{\r\n";
        
        str += "  execStmt:" + execStmt.toString()+"\r\n";
        
        return str+"}";
    }
}