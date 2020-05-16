package kalang.compiler.ast;

import kalang.annotation.Nullable;
import kalang.compiler.core.Type;
import kalang.compiler.core.Types;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MultiStmtExpr extends ExprNode {

    private final List<Statement> stmts = new LinkedList<>();

    @Nullable
    public ExprNode reference;

    public MultiStmtExpr(List<Statement> stmts,@Nullable ExprNode reference) {
        this.stmts.addAll(stmts);
        this.reference = reference;
    }

    @Override
    public List<AstNode> getChildren() {
        List<AstNode> ls = new LinkedList();
        addChild(ls, stmts);
        return ls;
    }

    @Override
    public Type getType() {
        return reference == null ? Types.VOID_TYPE : getType(reference);
    }
    
    public void addStatement(Statement stat) {
        stmts.add(stat);
    }

    public List<Statement> getStatements() {
        return new ArrayList(stmts);
    }
}
