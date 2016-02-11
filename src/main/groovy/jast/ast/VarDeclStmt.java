/*
Don't modify!This file is generated automately.
*/
package jast.ast;
import java.util.*;
import kalang.core.*;
public class VarDeclStmt extends Statement{
    
    public VarObject var;
    
    
    public VarDeclStmt(){
        
    }
    
    
    public VarDeclStmt(VarObject var){
        
        
            this.var = var;
        
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
        
        return ls;
    }
    
    public String toString(){
        String str = "VarDeclStmt{\r\n";
        
        if(var!=null){
            str += "  var:" + var.toString()+"\r\n";
        }
        
        return str+"}";
    }
}