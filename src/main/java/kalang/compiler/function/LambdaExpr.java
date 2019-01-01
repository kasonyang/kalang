package kalang.compiler.function;

import kalang.annotation.Nullable;
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

    private FunctionType functionType;

    public LambdaExpr(LocalVarNode tmpVar,@Nullable FunctionType functionType) {
        super(new LinkedList(), new VarExpr(tmpVar));
        this.referenceVarExpr = new VarExpr(tmpVar);
        this.varDeclStmt = new VarDeclStmt(tmpVar);
        this.tmpVar = tmpVar;
        this.functionType = functionType;
    }

    public VarExpr getReferenceExpr() {
        return referenceVarExpr;
    }

    public LocalVarNode getReferenceVar() {
        return referenceVarExpr.getVar();
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

    @Nullable
    public FunctionType getFunctionType() {
        return functionType;
    }

    public Map<String, VarObject> getAccessibleVarObjects() {
        return new HashMap(accessibleVarObjects);
    }

    @Override
    public List<AstNode> getChildren() {
        List<AstNode> list = new LinkedList();
        list.addAll(getStatements());
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
