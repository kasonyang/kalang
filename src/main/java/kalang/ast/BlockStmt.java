/*

*/
package kalang.ast;
import java.util.*;
import javax.annotation.Nullable;
import kalang.core.*;
public class BlockStmt extends Statement implements ScopeBlock{
    
    public final List<Statement> statements = new LinkedList<>();
    protected final VarTable<String, LocalVarNode> varTable;
    
    protected BlockStmt parentBlock = null;
    
    public BlockStmt(@Nullable BlockStmt parent){
        VarTable<String, LocalVarNode> parentVarTable = parent==null ? null : parent.getScopeVarTable();
        varTable = new VarTable<>(parentVarTable);
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
    public VarTable<String, LocalVarNode> getScopeVarTable() {
        return this.varTable;
    }

    public BlockStmt getParentBlock() {
        return parentBlock;
    }
    
}