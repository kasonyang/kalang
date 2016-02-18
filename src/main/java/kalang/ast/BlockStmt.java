/*
Don't modify!This file is generated automately.
*/
package kalang.ast;
import java.util.*;
import kalang.core.*;
public class BlockStmt extends Statement{
    
    public List<Statement> statements;
    
    
    public BlockStmt(){
        
            if(statements == null) statements = new LinkedList();
        
    }
    
    
    public BlockStmt(List<Statement> statements){
        
            if(statements == null) statements = new LinkedList();
        
        
            this.statements = statements;
        
    }
    
    
    public static BlockStmt create(){
        BlockStmt node = new BlockStmt();
        
        node.statements = new LinkedList();
        
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
        
        addChild(ls,statements);
        
        return ls;
    }
    
    public String toString(){
        String str = "BlockStmt{\r\n";
        
        if(statements!=null){
            str += "  statements:" + statements.toString()+"\r\n";
        }
        
        return str+"}";
    }
}