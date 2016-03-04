package kalang.ast;
import java.util.*;
import kalang.core.*;
public class VarDeclStmt extends Statement{
    
    public List<LocalVarNode> vars;
    
    public VarDeclStmt(){
        
    }
    public VarDeclStmt(LocalVarNode var){
        this(Collections.singletonList(var));
    }
    
    
    public VarDeclStmt(List<LocalVarNode> var){
        
        
            this.vars = var;
        
    }
    
    
    public static VarDeclStmt create(){
        VarDeclStmt node = new VarDeclStmt();
        
        return node;
    }
    
    protected void addChild(List<AstNode> list,List nodes){
        if(nodes!=null) list.addAll(nodes);
    }
    
    protected void addChild(List<AstNode> list,AstNode node){
        if(node!=null) list.add(node);
    }
    
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        ls.addAll(vars);
        return ls;
    }
    
}