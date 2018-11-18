package kalang.compiler.ast;

import java.util.LinkedList;
import java.util.List;

public class MultiStmt extends Statement{
    
    public final List<Statement> statements = new LinkedList<>();
    
    public MultiStmt(){
        
    }
    
    @Override
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        addChild(ls,statements);
        return ls;
    }
    
}