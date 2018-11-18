/*

*/
package kalang.compiler.ast;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
public class BlockStmt extends Statement{
    
    public final List<Statement> statements = new LinkedList<>();
    protected final List<LocalVarNode> vars = new LinkedList();
    
    public BlockStmt(){
    }
    
    public BlockStmt(Statement[] stmts){
        statements.addAll(Arrays.asList(stmts));
    }    
    
    @Override
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        addChild(ls,statements);
        return ls;
    }
    
}