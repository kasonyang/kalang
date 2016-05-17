package kalang.ast;
import java.util.*;
import kalang.core.*;
public class VarDeclStmt extends Statement{
    
    public final List<LocalVarNode> vars = new LinkedList<>();
    
    public VarDeclStmt(LocalVarNode var){
        this(Collections.singletonList(var));
    }
    
    public VarDeclStmt(List<LocalVarNode> var){
        this.vars.addAll(var);
    }
    
    
    @Override
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        ls.addAll(vars);
        return ls;
    }
    
}