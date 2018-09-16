package kalang.function;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kalang.ast.LocalVarNode;
import kalang.ast.MultiStmtExpr;
import kalang.ast.Statement;
import kalang.ast.VarExpr;
import kalang.ast.VarObject;

/**
 *
 * @author Kason Yang
 */
public class LambdaExpr extends MultiStmtExpr {

    private final VarExpr referenceVarExpr;
    
    private final Map<String,VarObject> accessibleVarObjects = new HashMap();

    public LambdaExpr(List<Statement> stmts, VarExpr referenceExpr) {
        super(stmts, referenceExpr);
        this.referenceVarExpr = referenceExpr;
    }

    public VarExpr getReferenceExpr() {
        return referenceVarExpr;
    }
    
    public LocalVarNode getReferenceVar() {
        return referenceVarExpr.getVar();
    }
    
    public void putAccessibleVarObject(String name,VarObject var){
        accessibleVarObjects.put(name, var);
    }
    
    public Map<String,VarObject> getAccessibleVarObjects() {
        return new HashMap(accessibleVarObjects);
    }

}
