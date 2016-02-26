/*
Don't modify!This file is generated automately.
*/
package kalang.ast;
import java.util.*;
import kalang.core.*;
public class CatchStmt extends Statement{
    
    public VarDeclStmt catchVarDecl;
    
    public Statement execStmt;
    
    
    public CatchStmt(){
        
    }
    
    
    public CatchStmt(VarDeclStmt catchVarDecl,Statement execStmt){
        
        
            this.catchVarDecl = catchVarDecl;
        
            this.execStmt = execStmt;
        
    }
    
    
    public static CatchStmt create(){
        CatchStmt node = new CatchStmt();
        
        return node;
    }
        
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        
        addChild(ls,catchVarDecl);
        
        addChild(ls,execStmt);
        
        return ls;
    }
    
    public String toString(){
        String str = "CatchStmt{\r\n";
        
        if(catchVarDecl!=null){
            str += "  catchVarDecl:" + catchVarDecl.toString()+"\r\n";
        }
        
        if(execStmt!=null){
            str += "  execStmt:" + execStmt.toString()+"\r\n";
        }
        
        return str+"}";
    }
}