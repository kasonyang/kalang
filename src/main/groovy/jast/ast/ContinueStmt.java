/*
Don't modify!This file is generated automately.
*/
package jast.ast;
import java.util.*;
import kalang.core.*;
public class ContinueStmt extends Statement{
    
    
    public ContinueStmt(){
        
    }
    
    
    
    public static ContinueStmt create(){
        ContinueStmt node = new ContinueStmt();
        
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
        String str = "ContinueStmt{\r\n";
        
        return str+"}";
    }
}