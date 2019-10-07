package kalang.compiler.function;

import kalang.compiler.ast.*;

import java.util.*;

/**
 *
 * @author Kason Yang
 */
public class LambdaExpr extends MultiStmtExpr {

    private final VarExpr referenceVarExpr;

    private final Map<String, VarObject> accessibleVarObjects = new HashMap();

    private final Statement varDeclStmt;

    private ExprNode initExpr;

    private final LocalVarNode tmpVar;

    public LambdaExpr(LocalVarNode tmpVar) {
        super(new LinkedList(), new VarExpr(tmpVar));
        this.referenceVarExpr = (VarExpr) this.reference;
        this.varDeclStmt = new VarDeclStmt(tmpVar);
        this.tmpVar = tmpVar;
    }

    public VarExpr getReferenceExpr() {
        return referenceVarExpr;
    }

    public void setInitExpr(ExprNode initExpr) {
        this.initExpr = initExpr;
    }

    public ExprNode getInitExpr() {
        return initExpr;
    }

    public void putAccessibleVarObject(String name, VarObject var) {
        accessibleVarObjects.put(name, var);
    }

    public Map<String, VarObject> getAccessibleVarObjects() {
        return new HashMap(accessibleVarObjects);
    }

    @Override
    public List<AstNode> getChildren() {
        List<AstNode> list = new LinkedList(getStatements());
        return list;
    }

    @Override
    public List<Statement> getStatements() {
        List<Statement> statements = super.getStatements();
        List<Statement> list = new ArrayList();
        list.add(varDeclStmt);
        list.add(new ExprStmt(new AssignExpr(new VarExpr(tmpVar), initExpr)));
        list.addAll(statements);
        return list;
    }

}
