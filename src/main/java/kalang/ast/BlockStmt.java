/*

*/
package kalang.ast;
import java.util.*;
import javax.annotation.Nullable;
import kalang.core.*;
public class BlockStmt extends Statement implements ScopeBlock{
    
    public final List<Statement> statements = new LinkedList<>();
    protected final List<LocalVarNode> vars = new LinkedList();
    
    protected BlockStmt parentBlock = null;
    
    public BlockStmt(@Nullable BlockStmt parent){
        parentBlock = parent;
    }
    
    public BlockStmt(@Nullable BlockStmt parent,Statement... stmts){
        this(parent);
        statements.addAll(Arrays.asList(stmts));
    }    
    
    @Override
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        addChild(ls,statements);
        return ls;
    }

    @Override
    public LocalVarNode[] getScopeVars() {
        return vars.toArray(new LocalVarNode[vars.size()]);
    }
    
    public void declareLocalVar(LocalVarNode var){
        vars.add(var);
    }

    public BlockStmt getParentBlock() {
        return parentBlock;
    }
    
}