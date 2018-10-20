package kalang.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kalang.ast.AssignExpr;
import kalang.ast.ExprNode;
import kalang.ast.ExprStmt;
import kalang.ast.LocalVarNode;
import kalang.ast.MultiStmtExpr;
import kalang.ast.Statement;
import kalang.ast.VarDeclStmt;
import kalang.ast.VarExpr;
import kalang.ast.VarObject;

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
        this.referenceVarExpr = new VarExpr(tmpVar);
        this.varDeclStmt = new VarDeclStmt(tmpVar);
        this.tmpVar = tmpVar;
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

    public void putAccessibleVarObject(String name, VarObject var) {
        accessibleVarObjects.put(name, var);
    }

    public Map<String, VarObject> getAccessibleVarObjects() {
        return new HashMap(accessibleVarObjects);
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
