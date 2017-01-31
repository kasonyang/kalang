/*

*/
package kalang.ast;
import java.util.*;
import javax.annotation.Nullable;
import kalang.core.*;
public class BlockStmt extends Statement{
    
    public final List<Statement> statements = new LinkedList<>();
    protected final List<LocalVarNode> vars = new LinkedList();
    
    public BlockStmt(){
    }
    
    public BlockStmt(Statement... stmts){
        statements.addAll(Arrays.asList(stmts));
    }    
    
    @Override
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        addChild(ls,statements);
        return ls;
    }
    
}