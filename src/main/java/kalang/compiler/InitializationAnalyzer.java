package kalang.compiler;

import java.util.ArrayList;
import java.util.List;

import kalang.ast.AssignExpr;
import kalang.ast.AstNode;
import kalang.ast.AstVisitor;
import kalang.ast.CatchBlock;
import kalang.ast.ClassNode;
import kalang.ast.IfStmt;
import kalang.ast.LoopStmt;
import kalang.ast.MethodNode;
import kalang.ast.Statement;
import kalang.ast.TryStmt;
import kalang.ast.VarExpr;
import java.util.Set;
import javax.annotation.Nullable;
import kalang.ast.AssignableExpr;
import kalang.ast.LocalVarNode;
import kalang.core.Type;
import kalang.core.VarTable;
import kalang.util.CollectionsUtil;

/**
 * The initialization analyzer class.
 *
 * @author Kason Yang
 */
public class InitializationAnalyzer extends AstVisitor<Object> {

    private AstLoader astLoader;

    private MethodNode method;

    private CompilationUnit source;

    private VarTable<LocalVarNode, Void> assignedVars = new VarTable<>();

    private DiagnosisReporter diagnosisReporter;

    public InitializationAnalyzer(CompilationUnit source, AstLoader astLoader) {
        this.astLoader = astLoader;
        this.source = source;
    }

    public void check(ClassNode clz,MethodNode method, DiagnosisHandler disgnosisHandler) {
        this.diagnosisReporter = new DiagnosisReporter(source.getCompileContext(), disgnosisHandler, source.getSource());
        this.visit(method);
    }

    @Override
    public Object visit(AstNode node) {
        if (node == null) {
            return null;
        }
        if (node instanceof VarExpr) {
            if (!assignedVars.exist(((VarExpr) node).getVar(), true)) {
                this.diagnosisReporter.report(Diagnosis.Kind.ERROR
                        , ((VarExpr) node).getVar().getName() + " is uninitialized!", ((VarExpr) node).offset);
            }
        }
        return super.visit(node);
    }

    @Override
    public Object visitAssignExpr(AssignExpr node) {
        AssignableExpr to = node.getTo();
        if (to instanceof VarExpr) {
            assignedVars.put(((VarExpr) to).getVar(), null);
        }
        return super.visitAssignExpr(node);
    }

    @Override
    public Type visitTryStmt(TryStmt node) {
        List<VarTable<LocalVarNode, Void>> assignedList = new ArrayList(node.getCatchStmts().size() + 1);
        enterNewFrame();
        assignedList.add(assignedVars);
        visit(node.getExecStmt());
        exitFrame();
        for (CatchBlock cs : node.getCatchStmts()) {
            enterNewFrame();
            assignedList.add(assignedVars);
            visit(cs);
            exitFrame();
        }
        addIntersectedAssignedVar(assignedList.toArray(new VarTable[assignedList.size()]));
        Statement finallyStmt = node.getFinallyStmt();
        if (finallyStmt != null) {
            visit(finallyStmt);
        }
        return null;
    }

    @Override
    public Type visitIfStmt(IfStmt node) {
        VarTable<LocalVarNode, Void> trueAssignedVars = null, falseAssignedVars = null;
        enterNewFrame();
        trueAssignedVars = assignedVars;
        visit(node.getTrueBody());
        exitFrame();
        enterNewFrame();
        falseAssignedVars = assignedVars;
        visit(node.getFalseBody());
        exitFrame();
        if (trueAssignedVars != null && falseAssignedVars != null) {
            addIntersectedAssignedVar(trueAssignedVars, falseAssignedVars);
        }
        return null;
    }

    @Override
    public Type visitLoopStmt(LoopStmt node) {
        visit(node.getPreConditionExpr());
        enterNewFrame();
        visit(node.getLoopBody());
        exitFrame();
        visit(node.getPostConditionExpr());
        return null;
    }

    @Override
    public Object visitMethodNode(MethodNode node) {
        method = node;
        return super.visitMethodNode(node);
    }

    protected void enterNewFrame() {
        assignedVars = new VarTable<>(assignedVars);
    }

    protected void exitFrame() {
        assignedVars = assignedVars.getParent();
    }

    protected void addIntersectedAssignedVar(VarTable<LocalVarNode, Void>... assignedVarsList) {
        Set<LocalVarNode>[] assigned = new Set[assignedVarsList.length];
        for (int i = 0; i < assigned.length; i++) {
            assigned[i] = assignedVarsList[i].keySet();
        }
        Set<LocalVarNode> sets = CollectionsUtil.getIntersection(assigned);
        for (LocalVarNode s : sets) {
            assignedVars.put(s, null);
        }
    }

}
