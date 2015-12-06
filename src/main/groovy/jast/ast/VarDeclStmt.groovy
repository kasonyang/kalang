/*
Don't modify!This file is generated automately.
*/
package jast.ast;
import java.util.*;
public class VarDeclStmt extends Statement{
    
    public Integer varId;
    
    public String varName;
    
    public String type;
    
    public ExprNode initExpr;
    
    
    
    public VarDeclStmt(Integer varId=null,String varName=null,String type=null,ExprNode initExpr=null){
        
        
            this.varId = varId;
        
            this.varName = varName;
        
            this.type = type;
        
            this.initExpr = initExpr;
        
    }
    
    
    public static VarDeclStmt create(){
        VarDeclStmt node = new VarDeclStmt();
        
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
        
        addChild(ls,initExpr);
        
        return ls;
    }
    
    public String toString(){
        String str = "VarDeclStmt{\r\n";
        
        str += "  varId:" + varId.toString()+"\r\n";
        
        str += "  varName:" + varName.toString()+"\r\n";
        
        str += "  type:" + type.toString()+"\r\n";
        
        str += "  initExpr:" + initExpr.toString()+"\r\n";
        
        return str+"}";
    }
}