/*
Don't modify!This file is generated automately.
*/
package jast.ast;
import java.util.*;
public class CatchStmt extends Statement{
    
    public VarDeclStmt catchVarDecl;
    
    public Statement execStmt;
    
    
    
    public CatchStmt(VarDeclStmt catchVarDecl=null,Statement execStmt=null){
        
        
            this.catchVarDecl = catchVarDecl;
        
            this.execStmt = execStmt;
        
    }
    
    
    public static CatchStmt create(){
        CatchStmt node = new CatchStmt();
        
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
        
        addChild(ls,catchVarDecl);
        
        addChild(ls,execStmt);
        
        return ls;
    }
    
    public String toString(){
        String str = "CatchStmt{\r\n";
        
        str += "  catchVarDecl:" + catchVarDecl.toString()+"\r\n";
        
        str += "  execStmt:" + execStmt.toString()+"\r\n";
        
        return str+"}";
    }
}